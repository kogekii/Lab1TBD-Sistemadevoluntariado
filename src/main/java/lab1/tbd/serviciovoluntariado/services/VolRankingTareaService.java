package lab1.tbd.serviciovoluntariado.services;
import lab1.tbd.serviciovoluntariado.models.VolRanking;
import lab1.tbd.serviciovoluntariado.repositories.VolRankingTareaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class VolRankingTareaService {

    private final VolRankingTareaRepository volRankingTareaRepository;

    //Constructor
    VolRankingTareaService(VolRankingTareaRepository volRankingTareaRepository){
        this.volRankingTareaRepository = volRankingTareaRepository;
    }

    //Conseguir el ranking de voluntarios para una cierta tarea
    @GetMapping("/voluntariesRankedPerTask/{id}") //id de la tarea
    @ResponseBody
    public List<VolRanking> getVoluntariesRankedPerTask(@PathVariable int id){
        return this.volRankingTareaRepository.getVoluntariesRankedPerTask(id);
    }
}