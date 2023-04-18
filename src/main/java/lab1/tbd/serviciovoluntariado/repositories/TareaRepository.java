
package lab1.tbd.serviciovoluntariado.repositories;

import lab1.tbd.serviciovoluntariado.models.Tarea;
import java.util.List;


public interface TareaRepository {

    public int countTarea();
    public List<Tarea> getAllTarea();
    public Tarea getTareaById(int id);
    public Tarea createTarea(Tarea t);
    public Tarea updateTarea(Tarea t);
    public void deleteTareaById(int id);
}
