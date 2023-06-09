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

<<<<<<< HEAD
    //Constructor
    TareaService(TareaRepository tareaRepository){
        this.TareaRepository = tareaRepository;
    }

    //Create
    @PostMapping("/createtarea")
=======
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
>>>>>>> 63eca21ce59e1b3ac45814616865b27577d9e15f
    @ResponseBody
    public Tarea createTarea(@RequestBody Tarea tarea){
        return TareaRepository.createTarea(tarea);
    }

    //Read
    @GetMapping("/tarea/get/{id}")
    @ResponseBody
<<<<<<< HEAD
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
=======
    public Tarea updateTarea(@RequestBody Tarea tarea){
        tareaRepository.updateTarea(tarea.getId(), tarea);
        Tarea tarea2 = tareaRepository.getTarea(tarea.getId());
        return tarea2;
    }

    @DeleteMapping("/{id}")
    public void deleteTareaById(@PathVariable(value = "id") int id){
        tareaRepository.deleteTarea(id);
>>>>>>> 63eca21ce59e1b3ac45814616865b27577d9e15f
    }
}
