package lab1.tbd.serviciovoluntariado.services;

import lab1.tbd.serviciovoluntariado.models.Equipamiento;
import lab1.tbd.serviciovoluntariado.repositories.EquipamientoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class EquipamientoService {
    private final EquipamientoRepository equipamientoRepository;

    public EquipamientoService(EquipamientoRepository equipamientoRepository) {
        this.equipamientoRepository = equipamientoRepository;
    }

    @PutMapping("/equipments")
    @ResponseBody
    public String createEquipamiento(@RequestBody Equipamiento equipamiento){
        return equipamientoRepository.createEquipamiento(equipamiento);
    }

    @GetMapping("/equipments")
    public List<Equipamiento> getAllEquipamiento(){
        return equipamientoRepository.getAllEquipamiento();
    }

    @GetMapping("/equipments/{id}")
    @ResponseBody
    public Equipamiento getEquipamientoById(@PathVariable int id){
        return equipamientoRepository.getEquipamientoById(id);
    }

    @PutMapping("/equipments/update/{id}")
    @ResponseBody
    public String updateEquipamiento(@PathVariable int id, @RequestBody Equipamiento equipamiento){
        return equipamientoRepository.updateEquipamiento(id,equipamiento);
    }

    @DeleteMapping("/equipments/delete/id={id}")
    @ResponseBody
    public String deleteEquipamiento(@PathVariable int id){
        return equipamientoRepository.deleteEquipamiento(id);
    }


}