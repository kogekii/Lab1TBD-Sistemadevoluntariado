package lab1.tbd.serviciovoluntariado.repositories;

import lab1.tbd.serviciovoluntariado.models.Emergencia;

import java.util.List;


public interface EmergenciaRepository {
    public String createEmergencia(Emergencia emergencia); //Create
    public List<Emergencia> getAllEmergencias(); //Read
<<<<<<< HEAD
    public String updateEmergencia(Long id, Emergencia emergencia); //Update
    public String deleteEmergencia(Long id);
    public Emergencia getEmergenciaById(Long id);
    public Long getIdEmergenciaMayor();
=======
    public String updateEmergencia(int id, Emergencia emergencia); //Update
    public String deleteEmergencia(int id);
    public Emergencia getEmergenciaById(Integer id);
    public long getIdEmergenciaMayor();
>>>>>>> 63eca21ce59e1b3ac45814616865b27577d9e15f
}
