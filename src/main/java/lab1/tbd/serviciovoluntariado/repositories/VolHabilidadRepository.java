package lab1.tbd.serviciovoluntariado.repositories;

import lab1.tbd.serviciovoluntariado.models.VolHabilidad;

import java.util.List;

public interface VolHabilidadRepository {
    
    public int countVolHabilidad();
    public List<VolHabilidad> getAllVolHabilidad();
    public VolHabilidad getVolHabilidadById(Long id);
    public VolHabilidad createVolHabilidad(VolHabilidad v);
    public VolHabilidad updateVolHabilidad(VolHabilidad v);
    public void deleteVolHabilidadById(Long id);
}
