package lab1.tbd.serviciovoluntariado.repositories;

import lab1.tbd.serviciovoluntariado.models.EstadoTarea;

import java.util.List;

public interface EstadoTareaRepository {

    public int countEstadoTarea();
    public List<EstadoTarea> getAllEstadoTarea();
    public EstadoTarea getEstadoTareaById(Long id);
    public EstadoTarea createEstadoTarea(EstadoTarea s);
    public EstadoTarea updateEstadoTarea(EstadoTarea s);
    public void deleteEstadoTareaById(Long id);

}
