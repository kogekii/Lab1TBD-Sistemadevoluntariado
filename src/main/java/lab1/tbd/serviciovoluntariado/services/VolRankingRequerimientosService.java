package lab1.tbd.serviciovoluntariado.services;
import lab1.tbd.serviciovoluntariado.models.VolCantidadHabilidades;
import lab1.tbd.serviciovoluntariado.repositories.VolRankingRequerimientosRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class VolRankingRequerimientosService {
    private final VolRankingRequerimientosRepository volRankingRequerimientosRepository;
    public VolRankingRequerimientosService(VolRankingRequerimientosRepository volRankingRequerimientosRepository) {
        this.volRankingRequerimientosRepository = volRankingRequerimientosRepository;
    }

    @GetMapping("/voluntarioHabilidades/{id}")
    @ResponseBody
    public List<VolCantidadHabilidades> getVoluntarioHabilidades(@PathVariable int id){
        return volRankingRequerimientosRepository.getVoluntariosRequerimiento(id);
    }

}