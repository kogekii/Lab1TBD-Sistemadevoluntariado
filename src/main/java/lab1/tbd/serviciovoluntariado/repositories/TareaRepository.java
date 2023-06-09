
package lab1.tbd.serviciovoluntariado.repositories;

import lab1.tbd.serviciovoluntariado.models.Tarea;
import java.util.List;

public interface TareaRepository
{
    public Tarea createTarea(Tarea tarea); //Create
    public List<Tarea> getAllTareas(); //Read
    public String updateTarea(long id, Tarea tarea); //Update
    public String deleteTarea(long id);
    public Tarea getTarea(long id);
    public List<Tarea> getTareasByRegion(int gid);
    public List<Tarea> getTareaByEmeId(int id);
    public Integer countTarea();
}
