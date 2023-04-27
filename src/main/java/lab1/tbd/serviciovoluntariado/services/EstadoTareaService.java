package lab1.tbd.serviciovoluntariado.services;

import lab1.tbd.serviciovoluntariado.models.EstadoTarea;
import lab1.tbd.serviciovoluntariado.repositories.EstadoTareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/estado-tarea")
public class EstadoTareaService {

    @Autowired
    EstadoTareaRepository estadoTareaRepository;

    @GetMapping
    public List<EstadoTarea> getAllEstadoTarea(){
        return estadoTareaRepository.getAllEstadoTarea();
    }

    @GetMapping("/{id}")
    public EstadoTarea getEstadoTareaById(@PathVariable(value = "id") int id){
        return estadoTareaRepository.getEstadoTareaById(id);
    }

    @GetMapping("/count")
    public Integer countEstadoTarea(){
        return estadoTareaRepository.countEstadoTarea();
    }

    @PostMapping
    @ResponseBody
    public EstadoTarea createEstadoTarea(@RequestBody EstadoTarea estadoTarea){
        EstadoTarea result = estadoTareaRepository.createEstadoTarea(estadoTarea);
        return result;
    }

    @PutMapping
    @ResponseBody
    public EstadoTarea updateEstadoTarea(@RequestBody EstadoTarea estadoTarea){
        EstadoTarea result = estadoTareaRepository.updateEstadoTarea(estadoTarea);
        return result;
    }

    @DeleteMapping("/{id}")
    public void deleteEstadoTareaById(@PathVariable(value = "id") int id){
        estadoTareaRepository.deleteEstadoTareaById(id);
    }
}
