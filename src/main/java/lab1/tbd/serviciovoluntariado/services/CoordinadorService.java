package lab1.tbd.serviciovoluntariado.services;

import lab1.tbd.serviciovoluntariado.models.Coordinador;
import lab1.tbd.serviciovoluntariado.models.Registration;
import lab1.tbd.serviciovoluntariado.models.CoordinadorRegisterResponse;
import lab1.tbd.serviciovoluntariado.repositories.CoordinadorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/coordinador")
public class CoordinadorService {
    private final CoordinadorRepository coordinadorRepository;

    /* Constructor */
    CoordinadorService(CoordinadorRepository coordinadorRepository){
        this.coordinadorRepository = coordinadorRepository;
    }

    // READ all
    @GetMapping
    public List<Coordinador> getAllCoordinador(){
        return coordinadorRepository.getAllCoordinador();
    }

    // READ one
    @GetMapping("/{id}")
    @ResponseBody
    public Coordinador getCoordinadorById(@PathVariable Long id){
        return this.coordinadorRepository.getCoordinadorById(id);
    }

    // CREATE
    @PostMapping
    @ResponseBody
    public Coordinador createCoordinador(@RequestBody Coordinador coordinador){
        return coordinadorRepository.createCoordinador(coordinador);
    }

    // UPDATE
    @PutMapping("/{id}")
    @ResponseBody
    public String updateCoordinador(@PathVariable Long id, @RequestBody Coordinador coordinador){
        return coordinadorRepository.updateCoordinador(id, coordinador);
    }

    // DELETE
    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteCoordinador(@PathVariable Long id){
        return coordinadorRepository.deleteCoordinador(id);
    }

    @PostMapping("/register")
    public ResponseEntity<CoordinadorRegisterResponse> registerCoordinador(@RequestBody Registration registration){
        Coordinador coordinador = coordinadorRepository.findOneByEmail(registration.getEmail());
        CoordinadorRegisterResponse response = new CoordinadorRegisterResponse();
        if(coordinador == null){
            // Crear usuario
            coordinador = new Coordinador();
            coordinador.setCorreo_electronico(registration.getEmail());
            coordinador.setNombre(registration.getNombre());
            coordinador.setApellido(registration.getApellido());
            coordinador.setPassword(new BCryptPasswordEncoder().encode(registration.getPassword()));
            coordinador = coordinadorRepository.createCoordinador(coordinador);
            // Contruir response
            response.setError(false);
            response.setMessage("El usuario se creó correctamente");
            response.setUsuario(coordinador);
        }
        else{
            response.setError(true);
            response.setMessage("El usuario ya existe!");
            response.setUsuario(null);
        }
        return ResponseEntity.ok(response);
    }
}
