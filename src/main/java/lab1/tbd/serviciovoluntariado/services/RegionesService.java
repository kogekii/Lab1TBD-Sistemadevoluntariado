package lab1.tbd.serviciovoluntariado.services;

import lab1.tbd.serviciovoluntariado.models.Regiones;
import lab1.tbd.serviciovoluntariado.repositories.RegionesRepository;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/region")
public class RegionesService {

    private final RegionesRepository regionesRepository;

    //Constructor
    RegionesService(RegionesRepository regionesRepository) {
        this.regionesRepository = regionesRepository;
    }

    // READ all
    @GetMapping
    @ResponseBody
    public List<Regiones> getAllRegiones() {
        return regionesRepository.getAllRegiones();
    }

    // READ one (con geometria como JSON)
    @GetMapping("/geo/{id}")
    @ResponseBody
    public List<Map<String, Object>> getRegionPoly(@PathVariable Long id) {
        return regionesRepository.getRegionPoly(id);
    }
}
