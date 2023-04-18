package lab1.tbd.serviciovoluntariado.repositories;

import lab1.tbd.serviciovoluntariado.models.EmeHabilidad;

import java.util.List;

public interface EmeHabilidadRepository {
    Long generateId();
    public int countTareaHabilidad();
    EmeHabilidad createEmeHabilidad(EmeHabilidad emeHabilidad);
    EmeHabilidad getEmeHabilidadById(Long id);
    List<EmeHabilidad> getAllEmeHabilidad();
    EmeHabilidad updateEmeHabilidad(EmeHabilidad emeHabilidad);
    void deleteEmeHabilidadById(Long id);
    void deleteEmeHabilidad();
}
