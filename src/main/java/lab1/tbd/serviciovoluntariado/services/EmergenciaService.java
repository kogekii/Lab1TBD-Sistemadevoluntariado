package lab1.tbd.serviciovoluntariado.services;

import lab1.tbd.serviciovoluntariado.models.Emergencia;
import lab1.tbd.serviciovoluntariado.repositories.EmergenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/emergencia")
public class EmergenciaService {

    @Autowired
    EmergenciaRepository emergenciaRepository;

    @GetMapping
    public List<Emergencia> getAllEmergencia(){
        return emergenciaRepository.getAllEmergencia();
    }

    @GetMapping("/{id}")
    public Emergencia getEmergenciaById(@PathVariable int id){
        return emergenciaRepository.getEmergenciaById(id);
    }

    @GetMapping("/count")
    public Integer countEmergencia(){
        return emergenciaRepository.countEmergencia();
    }

    @PostMapping
    @ResponseBody
    public Emergencia createEmergencia(@RequestBody Emergencia emergencia){
        Emergencia result = emergenciaRepository.createEmergencia(emergencia);
        return result;
    }

    @PutMapping
    @ResponseBody
    public Emergencia updateEmergencia(@RequestBody Emergencia emergencia){
        Emergencia result = emergenciaRepository.updateEmergencia(emergencia);
        return result;
    }

    @DeleteMapping("/{id}")
    public void deleteEmergenciaById(@PathVariable int id){
        emergenciaRepository.deleteEmergenciaById(id);
    }
}
