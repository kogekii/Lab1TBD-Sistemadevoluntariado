package lab1.tbd.serviciovoluntariado.services;

import lab1.tbd.serviciovoluntariado.models.Emergencia;
import lab1.tbd.serviciovoluntariado.repositories.EmergenciaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/emergencia")
public class EmergenciaService {

    private final EmergenciaRepository emergenciaRepository;

    //Constructor
    EmergenciaService(EmergenciaRepository emergenciaRepository){
        this.emergenciaRepository = emergenciaRepository;
    }

    // READ all
    @GetMapping
    public List<Emergencia> getAllEmergencias(){
        return emergenciaRepository.getAllEmergencias();
    }

    // CREATE
    @PostMapping
    @ResponseBody
    public String createEmergencia(@RequestBody Emergencia emergencia){
        return emergenciaRepository.createEmergencia(emergencia);
    }

    // READ one
    @GetMapping("/{id}")
    @ResponseBody
    public Emergencia getEmergenciaById(@PathVariable Long id){
        return this.emergenciaRepository.getEmergenciaById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    @ResponseBody
    public String updateEmergencia(@PathVariable Long id, @RequestBody Emergencia emergencia){
        return emergenciaRepository.updateEmergencia(id, emergencia);
    }

    // DELETE
    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteEmergencia(@PathVariable Long id){
        return emergenciaRepository.deleteEmergencia(id);
    }
}
