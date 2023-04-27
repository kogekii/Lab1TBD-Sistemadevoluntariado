package lab1.tbd.serviciovoluntariado.services;

import lab1.tbd.serviciovoluntariado.models.EmeHabilidad;
import lab1.tbd.serviciovoluntariado.repositories.EmeHabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/emergencia-habilidad")
public class EmeHabilidadService {

    @Autowired
    EmeHabilidadRepository emeHabilidadRepository;

    @GetMapping
    public List<EmeHabilidad>getAllEmeHabilidad(){
        return emeHabilidadRepository.getAllEmeHabilidad();
    }

    @GetMapping("/{id}")
    public EmeHabilidad getEmeHabilidadById(@PathVariable int id){
        return emeHabilidadRepository.getEmeHabilidadById((long)id);
    }

    @GetMapping("/count")
    public Integer countEmeHabilidad(){
        return emeHabilidadRepository.countTareaHabilidad();
    }

    @PostMapping
    @ResponseBody
    public EmeHabilidad createEmeHabilidad(@RequestBody EmeHabilidad emeHabilidad){
        EmeHabilidad result = emeHabilidadRepository.createEmeHabilidad(emeHabilidad);
        return result;
    }

    @PutMapping
    @ResponseBody
    public EmeHabilidad updateEmeHabilidad(@RequestBody EmeHabilidad emeHabilidad){
        EmeHabilidad result = emeHabilidadRepository.updateEmeHabilidad(emeHabilidad);
        return result;
    }

    @DeleteMapping("/{id}")
    public void deleteEmeHabilidad(@PathVariable int id){
        emeHabilidadRepository.deleteEmeHabilidadById((long)id);
    }
}
