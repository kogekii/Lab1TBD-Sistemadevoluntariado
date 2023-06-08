package lab1.tbd.serviciovoluntariado.repositories;

import lab1.tbd.serviciovoluntariado.models.Regiones;
import java.util.List;
import java.util.Map;

public interface RegionesRepository {
    public List<Regiones> getAllRegiones();
    public List<Map<String, Object>> getRegionPoly(int id); //Consigue el poligono que la describe
}