package lab1.tbd.serviciovoluntariado.repositories;

import lab1.tbd.serviciovoluntariado.models.Emergencia;

import java.util.List;


public interface EmergenciaRepository {
    public int countEmergencia();
    public List<Emergencia> getAllEmergencia();
    public Emergencia getEmergenciaById(int id);
    public Emergencia createEmergencia(Emergencia h);
    public Emergencia updateEmergencia(Emergencia h);
    public void deleteEmergenciaById(int id);
}
