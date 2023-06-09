package lab1.tbd.serviciovoluntariado.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lab1.tbd.serviciovoluntariado.models.Habilidad;
import lab1.tbd.serviciovoluntariado.repositories.HabilidadRepository;

@CrossOrigin
@RestController
@RequestMapping("/habilidad")
public class HabilidadService {

    @Autowired
    HabilidadRepository habilidadRepository;

    @GetMapping
    public List<Habilidad> getAllHabilidad(){
        return habilidadRepository.getAllHabilidad();
    }

    @GetMapping("/{id}")
    public Habilidad getHabilidadById(@PathVariable(value = "id") Long id){
        return habilidadRepository.getHabilidadById(id);
    }

    @GetMapping("/count")
    public Integer countHabilidad(){
        return habilidadRepository.countHabilidad();
    }

    @PostMapping
    @ResponseBody
    public Habilidad createHabilidad(@RequestBody Habilidad habilidad){
        Habilidad result = habilidadRepository.createHabilidad(habilidad);
        return result;
    }

    @PutMapping
    @ResponseBody
    public Habilidad updateHabilidad(@RequestBody Habilidad habilidad){
        Habilidad result = habilidadRepository.updateHabilidad(habilidad);
        return result;
    }

    @DeleteMapping("/{id}")
    public void deleteHabilidadById(@PathVariable(value = "id") Long id){
        habilidadRepository.deleteHabilidadById(id);
    }
}
