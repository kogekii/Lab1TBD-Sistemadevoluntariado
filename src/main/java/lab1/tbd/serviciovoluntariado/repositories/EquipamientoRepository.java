package lab1.tbd.serviciovoluntariado.repositories;
import lab1.tbd.serviciovoluntariado.models.Equipamiento;


import java.util.List;


public interface EquipamientoRepository {

    public String createEquipamiento(Equipamiento equipamiento);
    public Long getIdEquipamientoMayor();
    public List<Equipamiento> getAllEquipamiento();
    public Equipamiento getEquipamientoById(Long id);
    public String updateEquipamiento(Long id,Equipamiento equipamiento);
    public String deleteEquipamiento(Long id);
}