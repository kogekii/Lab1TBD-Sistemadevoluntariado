package lab1.tbd.serviciovoluntariado.repositories;
import lab1.tbd.serviciovoluntariado.models.VolRanking;
import java.util.List;

public interface VolRankingTareaRepository {
    public List<VolRanking> getVoluntariesRankedPerTask(long id);
}
