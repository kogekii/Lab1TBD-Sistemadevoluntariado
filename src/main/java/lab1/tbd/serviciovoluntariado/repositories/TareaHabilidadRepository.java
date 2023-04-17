package lab1.tbd.serviciovoluntariado.repositories;

import lab1.tbd.serviciovoluntariado.models.TareaHabilidad;

import java.util.List;


public interface TareaHabilidadRepository {
    Long generateId();
    TareaHabilidad createTareaHabilidad(TareaHabilidad tareaHabilidad);
    TareaHabilidad getTareaHabilidadById(Long id);
    List<TareaHabilidad> getAllTareaHabilidad();
    TareaHabilidad updateTareaHabilidad(TareaHabilidad tareaHabilidad);
    void deleteTareaHabilidadById(Long id);
    void deleteTareaHabilidad();

}
