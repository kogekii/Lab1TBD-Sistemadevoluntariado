package lab1.tbd.serviciovoluntariado.repositories;
import lab1.tbd.serviciovoluntariado.models.Equipamiento;


import java.util.List;


public interface EquipamientoRepository {

    public String createEquipamiento(Equipamiento equipamiento);
    public int getIdEquipamientoMayor();
    public List<Equipamiento> getAllEquipamiento();
    public Equipamiento getEquipamientoById(int id);
    public String updateEquipamiento(int id,Equipamiento equipamiento);
    public String deleteEquipamiento(int id);
}