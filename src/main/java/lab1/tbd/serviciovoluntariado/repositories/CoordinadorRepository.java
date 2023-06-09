package lab1.tbd.serviciovoluntariado.repositories;

import java.util.List;
import lab1.tbd.serviciovoluntariado.models.Coordinador;

public interface CoordinadorRepository {
    public String createCoordinador(Coordinador coordinador); //Create
    public List<Coordinador> getAllCoordinador(); //Read
    public Coordinador getCoordinadorById(Integer id);
    public String updateCoordinador(int id, Coordinador coordinador); //Update
    public String deleteCoordinador(int id);
    public int getIdCoordinadorMayor();
}