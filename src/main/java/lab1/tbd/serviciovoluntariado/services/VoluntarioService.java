package lab1.tbd.serviciovoluntariado.services;

import lab1.tbd.serviciovoluntariado.models.Registration;
import lab1.tbd.serviciovoluntariado.models.Voluntario;
import lab1.tbd.serviciovoluntariado.models.VoluntarioRegisterResponse;
import lab1.tbd.serviciovoluntariado.repositories.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/voluntario")
public class VoluntarioService
{
    @Autowired
    VoluntarioRepository voluntarioRepository;

    // READ all
    @GetMapping
    public List<Voluntario> getAllVoluntario(){
        return voluntarioRepository.findAll();
    }

    // READ one
    @GetMapping("/{id}")
    public Voluntario getVoluntarioById(@PathVariable(value = "id") int id){
        return voluntarioRepository.findById(id).orElse(null);
    }

    // CREATE
    @PostMapping("/{id}")
    @ResponseBody
    public Voluntario createVoluntario(@RequestBody Voluntario voluntario){
        Voluntario result = voluntarioRepository.save(voluntario);
        return result;
    }

    // UPDATE
    // @PutMapping("/{id}")
    // @ResponseBody
    // public Voluntario updateVoluntario(@RequestBody Voluntario voluntario){
    //     Voluntario result = voluntarioRepository.(voluntario);
    //     return result;
    // }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteVoluntarioById(@PathVariable(value = "id") Integer id){
        voluntarioRepository.deleteById(id);
    }

    // @GetMapping("count")
    // public Integer countVoluntario(){
    //     // return voluntarioRepository.countVoluntario();
    //     // return voluntarioRepository.count();
    // }

    @PostMapping("/register")
    public ResponseEntity<VoluntarioRegisterResponse> register(@RequestBody Registration registration){
        Voluntario voluntario = voluntarioRepository.findOneByCorreoElectronico(registration.getEmail()).orElse(null);
        VoluntarioRegisterResponse response = new VoluntarioRegisterResponse();
        if(voluntario == null){
            // Crear usuario
            voluntario = new Voluntario();
            voluntario.setCorreoElectronico(registration.getEmail());
            voluntario.setNombre(registration.getNombre());
            voluntario.setApellido(registration.getApellido());
            voluntario.setPassword(new BCryptPasswordEncoder().encode(registration.getPassword()));
            voluntario = voluntarioRepository.save(voluntario);
            // Contruir response
            response.setError(false);
            response.setMessage("El usuario se creó correctamente");
            response.setUsuario(voluntario);
        }
        else{
            response.setError(true);
            response.setMessage("El usuario ya existe!");
            response.setUsuario(null);
        }
        return ResponseEntity.ok(response);
    }
}
