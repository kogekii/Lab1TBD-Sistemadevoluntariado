package lab1.tbd.serviciovoluntariado.repositories;

import lab1.tbd.serviciovoluntariado.models.Habilidad;

import java.util.List;

public interface HabilidadRepository {
    public int countHabilidad();
    public List<Habilidad> getAllHabilidad();
    public Habilidad getHabilidadById(int id);
    public Habilidad createHabilidad(Habilidad h);
    public Habilidad updateHabilidad(Habilidad h);
    public void deleteHabilidadById(int id);
    public List<Habilidad> getHabilidadByEmergency(int id);
}
