package lab1.tbd.serviciovoluntariado.services;

import lab1.tbd.serviciovoluntariado.models.Tarea;
import lab1.tbd.serviciovoluntariado.repositories.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/tarea")
public class TareaService {

    @Autowired
    TareaRepository tareaRepository;

    @GetMapping
    public List<Tarea> getAllTarea(){
        return tareaRepository.getAllTarea();
    }

    @GetMapping("/{id}")
    public Tarea getTareaById(@PathVariable(value = "id") int id){
        return tareaRepository.getTareaById(id);
    }

    @GetMapping("/count")
    public Integer countTarea(){
        return tareaRepository.countTarea();
    }

    @PostMapping
    @ResponseBody
    public Tarea createTarea(@RequestBody Tarea tarea){
        Tarea result = tareaRepository.createTarea(tarea);
        return result;
    }

    @PutMapping
    @ResponseBody
    public Tarea updateTarea(@RequestBody Tarea tarea){
        Tarea result = tareaRepository.updateTarea(tarea);
        return result;
    }

    @DeleteMapping("/{id}")
    public void deleteTareaById(@PathVariable(value = "id") int id){
        tareaRepository.deleteTareaById(id);
    }
}
