package lab1.tbd.serviciovoluntariado.services;

import lab1.tbd.serviciovoluntariado.models.VolHabilidad;
import lab1.tbd.serviciovoluntariado.repositories.VolHabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/voluntario-habilidad")
public class VolHabilidadService {

    @Autowired
    VolHabilidadRepository volHabilidadRepository;

    @GetMapping
    public List<VolHabilidad> getAllVolHabilidad(){
        return volHabilidadRepository.getAllVolHabilidad();
    }

    @GetMapping("/{id}")
    public VolHabilidad getVolHabilidadById(@PathVariable(value = "id") int id){
        return volHabilidadRepository.getVolHabilidadById(id);
    }

    @GetMapping("/count")
    public Integer countVolHabilidad(){
        return volHabilidadRepository.countVolHabilidad();
    }

    @PostMapping
    @ResponseBody
    public VolHabilidad createVolHabilidad(@RequestBody VolHabilidad volHabilidad){
        VolHabilidad result = volHabilidadRepository.createVolHabilidad(volHabilidad);
        return result;
    }

    @PutMapping
    @ResponseBody
    public VolHabilidad updateVolHabilidad(@RequestBody VolHabilidad volHabilidad){
        VolHabilidad result = volHabilidadRepository.updateVolHabilidad(volHabilidad);
        return result;
    }

    @DeleteMapping("/{id}")
    public void deleteVolHabilidadById(@PathVariable(value = "id") int id){
        volHabilidadRepository.deleteVolHabilidadById(id);
    }
}
