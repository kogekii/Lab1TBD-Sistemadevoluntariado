package lab1.tbd.serviciovoluntariado.repositories;

import java.util.List;

import lab1.tbd.serviciovoluntariado.models.Coordinador;

public interface CoordinadorRepository {
    public Coordinador createCoordinador(Coordinador coordinador); //Create
    public List<Coordinador> getAllCoordinador(); //Read
    public Coordinador getCoordinadorById(Long id);
    public Coordinador findOneByEmail(String email);
    public String updateCoordinador(Long id, Coordinador coordinador); //Update
    public String deleteCoordinador(Long id);
    public Long getIdCoordinadorMayor();
}