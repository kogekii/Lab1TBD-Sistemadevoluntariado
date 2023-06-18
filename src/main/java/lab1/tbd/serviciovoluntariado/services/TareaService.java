package lab1.tbd.serviciovoluntariado.services;

import lab1.tbd.serviciovoluntariado.models.Tarea;
import lab1.tbd.serviciovoluntariado.models.VoluntarioCercano;
import lab1.tbd.serviciovoluntariado.repositories.TareaRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/tarea")
public class TareaService {

    private final TareaRepository tareaRepository;

    // Constructor
    TareaService(TareaRepository tareaRepository){
        this.tareaRepository = tareaRepository;
    }

    // READ all
    @GetMapping
    @ResponseBody
    public List<Tarea> getAllTareas(){
        return tareaRepository.getAllTareas();
    }

    // CREATE
    @PostMapping
    @ResponseBody
    public Tarea createTarea(@RequestBody Tarea tarea){
        return tareaRepository.createTarea(tarea);
    }

    // READ one
    @GetMapping("/{id}")
    @ResponseBody
    public Tarea getTarea(@PathVariable Long id){
        return tareaRepository.getTarea(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    @ResponseBody
    public String updateTarea(@PathVariable Long id, @RequestBody Tarea tarea){
        return tareaRepository.updateTarea(id, tarea);
    }

    // DELETE
    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteTarea(@PathVariable Long id){
        return tareaRepository.deleteTarea(id);
    }

    // READ all (by-region)
    @GetMapping("/by-region/{id}")
    @ResponseBody
    public List<Tarea> getTareasByRegion(@PathVariable Long id){
        return tareaRepository.getTareasByRegion(id);
    }

    // READ all (by-emergencia)
    @GetMapping("/by-emergencia/{id}")
    @ResponseBody
    public List<Tarea> getTareaByEmergenciaId(@PathVariable Long id){
        return tareaRepository.getTareasByEmergencia(id);
    }

    // Special query
    @GetMapping("/{id}/voluntarios")
    @ResponseBody
    public List<VoluntarioCercano> getClosestVoluntarios(@PathVariable Long id, @RequestParam Map<String,String> searchParams){
        Long limit;
        if(searchParams.containsKey("limit")){
            try {
                limit = Long.parseLong(searchParams.get("limit"));
            }
            catch(Exception err) {
                System.out.println(err.getMessage());
                limit = 10L;
            }
        }
        else {
            limit = 10L;
        }
        return tareaRepository.getClosestVoluntarios(id, limit);
    }
}
