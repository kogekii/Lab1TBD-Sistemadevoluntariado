package lab1.tbd.serviciovoluntariado.services;

import lab1.tbd.serviciovoluntariado.models.Registration;
import lab1.tbd.serviciovoluntariado.models.Usuario;
import lab1.tbd.serviciovoluntariado.models.Voluntario;
import lab1.tbd.serviciovoluntariado.repositories.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/voluntario")
public class VoluntarioService {

    @Autowired
    VoluntarioRepository voluntarioRepository;

    @GetMapping
    public List<Voluntario> getAllVoluntario(){
        // return voluntarioRepository.getAllVoluntario();
        return voluntarioRepository.findAll();

    }

    @GetMapping("/{id}")
    public Voluntario getVoluntarioById(@PathVariable(value = "id") int id){
        return voluntarioRepository.getById(id);
    }

    // @GetMapping("count")
    // public Integer countVoluntario(){
    //     // return voluntarioRepository.countVoluntario();
    //     // return voluntarioRepository.count();

    // }

    @PostMapping("/create")
    @ResponseBody
    public Voluntario createVoluntario(@RequestBody Voluntario voluntario){
        Voluntario result = voluntarioRepository.save(voluntario);
        return result;
    }

    // @PutMapping
    // @ResponseBody
    // public Voluntario updateVoluntario(@RequestBody Voluntario voluntario){
    //     Voluntario result = voluntarioRepository.(voluntario);
    //     return result;
    // }

    @DeleteMapping
    public void deleteVoluntarioById(@PathVariable(value = "id") Integer id){
        voluntarioRepository.deleteById(id);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Registration registration){
        Voluntario voluntario = new Voluntario();
        voluntario.setEmail(registration.getEmail());
        voluntario.setNombre(registration.getName());
        voluntario.setPassword(new BCryptPasswordEncoder().encode(registration.getPassword()));
        voluntarioRepository.save(voluntario);
        return ResponseEntity.ok("usuario añadido");
    }
}
