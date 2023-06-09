package lab1.tbd.serviciovoluntariado.repositories;

import lab1.tbd.serviciovoluntariado.models.Ranking;

import java.util.List;

public interface RankingRepository {
    public int countRanking();
    public List<Ranking> getAllRanking();
    public Ranking getRankingById(Long id);
    public List<Ranking> getRankingByTareaId(Long id);
    public Ranking createRanking(Ranking r);
    public Ranking updateRanking(Ranking r);
    public void deleteRankingById(Long id);
}
