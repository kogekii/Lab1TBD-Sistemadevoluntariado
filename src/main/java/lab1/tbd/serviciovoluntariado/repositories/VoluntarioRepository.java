package lab1.tbd.serviciovoluntariado.repositories;

import lab1.tbd.serviciovoluntariado.models.Voluntario;
import java.util.List;

public interface VoluntarioRepository{
    public int countVoluntario();
    public List<Voluntario> getAllVoluntario();
    public Voluntario getVoluntarioById(Long id);
    public Voluntario createVoluntario(Voluntario v);
    public Voluntario updateVoluntario(Voluntario v);
    public void deleteVoluntarioById(Long id);
}
