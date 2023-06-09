
package lab1.tbd.serviciovoluntariado.services;

import lab1.tbd.serviciovoluntariado.models.TareaHabilidad;
import lab1.tbd.serviciovoluntariado.repositories.TareaHabilidadRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/tarea-habilidad")
public class TareaHabilidadService {

    @Autowired
    TareaHabilidadRepository tareaHabilidadRepository;

    @GetMapping
    public List<TareaHabilidad> getAllTareaHabilidad(){ return tareaHabilidadRepository.getAllTareaHabilidad();}

    @GetMapping("/{id}")
    public TareaHabilidad getTareaHabilidadById(@PathVariable Long id){
        return tareaHabilidadRepository.getTareaHabilidadById((long) id);
    }

    @GetMapping("/count")
    public Integer countTareaHabilidad(){
        return tareaHabilidadRepository.countTareaHabilidad();
    }

    @PostMapping
    @ResponseBody
    public TareaHabilidad createTareaHabilidad(@RequestBody TareaHabilidad tareaHabilidad){
        TareaHabilidad result = tareaHabilidadRepository.createTareaHabilidad(tareaHabilidad);
        return result;
    }

    @PutMapping
    @ResponseBody
    public TareaHabilidad updateTask_Skill(@RequestBody TareaHabilidad tareaHabilidad){
        TareaHabilidad result = tareaHabilidadRepository.updateTareaHabilidad(tareaHabilidad);
        return result;
    }

    @DeleteMapping("/{id}")
    public void deleteTareaHabilidad(@PathVariable Long id){
        tareaHabilidadRepository.deleteTareaHabilidadById((long) id);
    }

}
