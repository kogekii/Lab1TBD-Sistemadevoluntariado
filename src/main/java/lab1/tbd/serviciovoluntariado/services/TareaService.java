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
        return tareaRepository.getAllTareas();
    }

    @GetMapping("/{id}")
    public Tarea getTareaById(@PathVariable(value = "id") int id){
        return tareaRepository.getTarea(id);
    }

    @GetMapping("/count")
    public Integer countTarea(){
        return tareaRepository.countTarea();
    }

    @GetMapping("/byemergencia/{id}")
    public List<Tarea> getTareaByEmeId(@PathVariable(value = "id") int id){
        return tareaRepository.getTareaByEmeId(id);
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
        tareaRepository.updateTarea(tarea.getId(), tarea);
        Tarea tarea2 = tareaRepository.getTarea(tarea.getId());
        return tarea2;
    }

    @DeleteMapping("/{id}")
    public void deleteTareaById(@PathVariable(value = "id") int id){
        tareaRepository.deleteTarea(id);
    }
}
