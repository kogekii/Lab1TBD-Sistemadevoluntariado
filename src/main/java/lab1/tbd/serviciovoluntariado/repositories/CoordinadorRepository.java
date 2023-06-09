package lab1.tbd.serviciovoluntariado.repositories;

import java.util.List;
<<<<<<< HEAD

=======
>>>>>>> 63eca21ce59e1b3ac45814616865b27577d9e15f
import lab1.tbd.serviciovoluntariado.models.Coordinador;

public interface CoordinadorRepository {
    public String createCoordinador(Coordinador coordinador); //Create
    public List<Coordinador> getAllCoordinador(); //Read
    public Coordinador getCoordinadorById(Long id);
    public String updateCoordinador(Long id, Coordinador coordinador); //Update
    public String deleteCoordinador(Long id);
    public Long getIdCoordinadorMayor();
}