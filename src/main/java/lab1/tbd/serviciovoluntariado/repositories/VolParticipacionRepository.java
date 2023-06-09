package lab1.tbd.serviciovoluntariado.repositories;
import lab1.tbd.serviciovoluntariado.models.VolParticipacion;
import java.util.List;

public interface VolParticipacionRepository {
    public List<VolParticipacion> getVoluntariesPerParticipation(Long id);
}
