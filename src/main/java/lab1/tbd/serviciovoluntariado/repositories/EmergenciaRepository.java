package lab1.tbd.serviciovoluntariado.repositories;

import lab1.tbd.serviciovoluntariado.models.Emergencia;

import java.util.List;


public interface EmergenciaRepository {
    public String createEmergencia(Emergencia emergencia); //Create
    public List<Emergencia> getAllEmergencias(); //Read
    public String updateEmergencia(Long id, Emergencia emergencia); //Update
    public String deleteEmergencia(Long id);
    public Emergencia getEmergenciaById(Long id);
    public Long getIdEmergenciaMayor();
}
