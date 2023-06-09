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

    private final TareaRepository TareaRepository;

    //Constructor
    TareaService(TareaRepository tareaRepository){
        this.TareaRepository = tareaRepository;
    }

    //Create
    @PostMapping("/createtarea")
    @ResponseBody
    public Tarea createTarea(@RequestBody Tarea tarea){
        return TareaRepository.createTarea(tarea);
    }

    //Read
    @GetMapping("/tarea/get/{id}")
    @ResponseBody
    public Tarea getTarea(@PathVariable Long id){
        return TareaRepository.getTarea(id);
    }

    //Read all
    @GetMapping("/tareas")
    @ResponseBody
    public List<Tarea> getAllTareas(){
        return TareaRepository.getAllTareas();
    }

    //Update
    @PutMapping("/tarea/update/{id}")
    @ResponseBody
    public String updateTarea(@PathVariable Long id, @RequestBody Tarea tarea){
        return TareaRepository.updateTarea(id, tarea);
    }

    //Delete
    @DeleteMapping("/tarea/delete/id={id}")
    @ResponseBody
    public String deleteTarea(@PathVariable Long id){
        return TareaRepository.deleteTarea(id);
    }

    //Conseguir tareas por region
    @GetMapping("/tareaByRegion/{id}")
    @ResponseBody
    public List<Tarea> getTareasByRegion(@PathVariable Long id){
        return TareaRepository.getTareasByRegion(id);
    }
}
