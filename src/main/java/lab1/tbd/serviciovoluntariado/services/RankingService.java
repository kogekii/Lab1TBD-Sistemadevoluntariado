package lab1.tbd.serviciovoluntariado.services;

import lab1.tbd.serviciovoluntariado.models.Ranking;
import lab1.tbd.serviciovoluntariado.repositories.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/ranking")
public class RankingService {

    @Autowired
    RankingRepository rankingRepository;

    @GetMapping
    public List<Ranking> getAllRanking(){
        return rankingRepository.getAllRanking();
    }

    @GetMapping("/{id}")
    public Ranking getRankingById(@PathVariable(value = "id") int id){
        return rankingRepository.getRankingById(id);
    }

    @GetMapping("/bytarea/{id}")
    public List<Ranking> getRankingByTareaId(@PathVariable(value = "id") int id){
        return rankingRepository.getRankingByTareaId(id);
    }

    @GetMapping("/count")
    public Integer countRanking(){
        return rankingRepository.countRanking();
    }

    @PostMapping
    @ResponseBody
    public Ranking createRanking(@RequestBody Ranking ranking){
        Ranking result = rankingRepository.createRanking(ranking);
        return result;
    }

    @PutMapping
    @ResponseBody
    public Ranking updateRanking(@RequestBody Ranking ranking){
        Ranking result = rankingRepository.updateRanking(ranking);
        return result;
    }

    @DeleteMapping
    public void deleteRankingById(@PathVariable(value = "id") int id){
        rankingRepository.deleteRankingById(id);
    }
}
