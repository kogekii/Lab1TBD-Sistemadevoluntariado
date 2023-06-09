package lab1.tbd.serviciovoluntariado.repositories;
import lab1.tbd.serviciovoluntariado.models.VolCantidadHabilidades;
import java.util.List;

public interface VolRankingRequerimientosRepository {
    public List<VolCantidadHabilidades> getVoluntariosRequerimiento(Long idEmergencia);
}