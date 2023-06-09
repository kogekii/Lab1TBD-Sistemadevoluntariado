
package lab1.tbd.serviciovoluntariado.repositories;

import lab1.tbd.serviciovoluntariado.models.Tarea;
import java.util.List;

public interface TareaRepository
{
    public Tarea createTarea(Tarea tarea); //Create
    public List<Tarea> getAllTareas(); //Read
<<<<<<< HEAD
    public String updateTarea(Long id, Tarea tarea); //Update
    public String deleteTarea(Long id);
    public Tarea getTarea(Long id);
    public List<Tarea> getTareasByRegion(Long gid);
=======
    public String updateTarea(long id, Tarea tarea); //Update
    public String deleteTarea(long id);
    public Tarea getTarea(long id);
    public List<Tarea> getTareasByRegion(int gid);
    public List<Tarea> getTareaByEmeId(int id);
    public Integer countTarea();
>>>>>>> 63eca21ce59e1b3ac45814616865b27577d9e15f
}
