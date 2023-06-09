package lab1.tbd.serviciovoluntariado.services;
import lab1.tbd.serviciovoluntariado.models.Regiones;
import lab1.tbd.serviciovoluntariado.repositories.RegionesRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@CrossOrigin
@RestController
public class RegionesService {

    private final RegionesRepository RegionesRepository;

    //Constructor
    RegionesService(RegionesRepository regionesRepository) {
        this.RegionesRepository = regionesRepository;
    }

    //Read all
    @GetMapping("/regiones")
    @ResponseBody
    public List<Regiones> getAllRegiones() {
        return RegionesRepository.getAllRegiones();
    }

    //Consigue coodenadas del poligono por la id
    @GetMapping("/polyregion/{id}")
    @ResponseBody
    public List<Map<String, Object>> getRegionPoly(@PathVariable long id) {
        return RegionesRepository.getRegionPoly((int)id);
    }
}