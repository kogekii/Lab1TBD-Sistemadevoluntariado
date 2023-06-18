
package lab1.tbd.serviciovoluntariado.repositories;

import lab1.tbd.serviciovoluntariado.models.Tarea;
import lab1.tbd.serviciovoluntariado.models.VoluntarioCercano;

import java.util.List;

public interface TareaRepository
{
    public Tarea createTarea(Tarea tarea); //Create
    public List<Tarea> getAllTareas(); //Read
    public String updateTarea(Long id, Tarea tarea); //Update
    public String deleteTarea(Long id);
    public Tarea getTarea(Long id);
    public List<Tarea> getTareasByRegion(Long gid);
    public List<Tarea> getTareasByEmergencia(Long eid);
    public List<VoluntarioCercano> getClosestVoluntarios(Long tid, Long limit);
}
