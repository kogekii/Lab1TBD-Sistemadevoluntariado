package lab1.tbd.serviciovoluntariado.repositories;

import lab1.tbd.serviciovoluntariado.models.Emergencia;

import java.util.List;


public interface EmergenciaRepository {
    public String createEmergencia(Emergencia emergencia); //Create
    public List<Emergencia> getAllEmergencias(); //Read
    public String updateEmergencia(int id, Emergencia emergencia); //Update
    public String deleteEmergencia(int id);
    public Emergencia getEmergenciaById(Integer id);
    public int getIdEmergenciaMayor();
}
