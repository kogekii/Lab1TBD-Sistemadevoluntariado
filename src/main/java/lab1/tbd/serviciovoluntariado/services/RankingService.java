package lab1.tbd.serviciovoluntariado.services;

import lab1.tbd.serviciovoluntariado.models.Ranking;
import lab1.tbd.serviciovoluntariado.repositories.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/ranking")
public class RankingService
{
    @Autowired
    RankingRepository rankingRepository;

    // READ all
    @GetMapping
    public List<Ranking> getAllRanking(){
        return rankingRepository.getAllRanking();
    }

    // READ one
    @GetMapping("/{id}")
    public Ranking getRankingById(@PathVariable(value = "id") Long id){
        return rankingRepository.getRankingById(id);
    }

    // READ all (by emergencia)
    @GetMapping("/by-emergencia/{id}")
    public List<Ranking> getRankingByEmergenciaId(@PathVariable(value = "id") Long id){
        return rankingRepository.getRankingByEmergenciaId(id);
    }

    // READ all (by tarea)
    @GetMapping("/by-tarea/{id}")
    public List<Ranking> getRankingByTareaId(@PathVariable(value = "id") Long id){
        return rankingRepository.getRankingByTareaId(id);
    }

    // CREATE
    @PostMapping
    @ResponseBody
    public Ranking createRanking(@RequestBody Ranking ranking){
        Ranking result = rankingRepository.createRanking(ranking);
        return result;
    }

    // UPDATE
    @PutMapping
    @ResponseBody
    public Ranking updateRanking(@RequestBody Ranking ranking){
        Ranking result = rankingRepository.updateRanking(ranking);
        return result;
    }

    // DELETE
    @DeleteMapping
    public void deleteRankingById(@PathVariable(value = "id") Long id){
        rankingRepository.deleteRankingById(id);
    }

    @GetMapping("/count")
    public Integer countRanking(){
        return rankingRepository.countRanking();
    }
}
