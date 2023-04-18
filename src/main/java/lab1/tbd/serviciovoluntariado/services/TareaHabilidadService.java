/*
package lab1.tbd.serviciovoluntariado.services;

import lab1.tbd.serviciovoluntariado.models.TareaHabilidad;
import lab1.tbd.serviciovoluntariado.repositories.TareaHabilidadRepository;


import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class TareaHabilidadService {

    private final TareaHabilidadRepository tareaHabilidadRepository;
    TareaHabilidadService(TareaHabilidadRepository tareaHabilidadRepository)
    {this.tareaHabilidadRepository = tareaHabilidadRepository;}

    @GetMapping("/tareaHabilidad")
    public List<TareaHabilidad> getAllTareaHabilidad(){ return tareaHabilidadRepository.getAllTareaHabilidad();}
    @GetMapping("/tareaHabilidad/count")
    @PostMapping("/tareaHabilidad")
    @ResponseBody
    public TareaHabilidad createTareaHabilidad(@RequestBody TareaHabilidad tareaHabilidad){
        TareaHabilidad result = tareaHabilidadRepository.createTareaHabilidad(tareaHabilidad);
        return result;
    }

    @PutMapping("/tareaHabilidad")
    @ResponseBody
    public TareaHabilidad updateTask_Skill(@RequestBody TareaHabilidad tareaHabilidad){
        TareaHabilidad result = tareaHabilidadRepository.updateTareaHabilidad(tareaHabilidad);
        return result;
    }

    @DeleteMapping("/tareaHabilidad/{id}")
    public void deleteTareaHabilidad(@PathVariable int id){
        tareaHabilidadRepository.deleteTareaHabilidadById((long) id);
    }

    @GetMapping("/tareaHabilidad/{id}")
    public TareaHabilidad getTareaHabilidadById(@PathVariable int id){
        return tareaHabilidadRepository.getTareaHabilidadById((long) id);
    }



}
*/