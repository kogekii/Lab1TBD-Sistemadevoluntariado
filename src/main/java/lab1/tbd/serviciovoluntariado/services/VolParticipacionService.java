package lab1.tbd.serviciovoluntariado.services;

import lab1.tbd.serviciovoluntariado.models.VolParticipacion;
import lab1.tbd.serviciovoluntariado.repositories.VolParticipacionRepository;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin
@RestController
public class VolParticipacionService {

    private final VolParticipacionRepository volParticipacionRepository;

    //Constructor
    VolParticipacionService (VolParticipacionRepository volParticipacionRepository){
        this.volParticipacionRepository = volParticipacionRepository;
    }

    //Conseguir los voluntarios que se han realizado mas tareas de una emergencia
    @GetMapping("/voluntariesPerParticipation/{id}") //id de la emergencia
    @ResponseBody
    public List<VolParticipacion> getVoluntariesPerParticipation(@PathVariable int id){
        return this.volParticipacionRepository.getVoluntariesPerParticipation(id);
    }
}