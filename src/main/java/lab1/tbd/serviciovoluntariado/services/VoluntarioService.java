package lab1.tbd.serviciovoluntariado.services;

import lab1.tbd.serviciovoluntariado.models.Voluntario;
import lab1.tbd.serviciovoluntariado.repositories.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return voluntarioRepository.getAllVoluntario();
    }

    @GetMapping("/{id}")
    public Voluntario getVoluntarioById(@PathVariable(value = "id") int id){
        return voluntarioRepository.getVoluntarioById(id);
    }

    @GetMapping("count")
    public Integer countVoluntario(){
        return voluntarioRepository.countVoluntario();
    }

    @PostMapping
    @ResponseBody
    public Voluntario createVoluntario(@RequestBody Voluntario voluntario){
        Voluntario result = voluntarioRepository.createVoluntario(voluntario);
        return result;
    }

    @PutMapping
    @ResponseBody
    public Voluntario updateVoluntario(@RequestBody Voluntario voluntario){
        Voluntario result = voluntarioRepository.updateVoluntario(voluntario);
        return result;
    }

    @DeleteMapping
    public void deleteVoluntarioById(@PathVariable(value = "id") int id){
        voluntarioRepository.deleteVoluntarioById(id);
    }
}
