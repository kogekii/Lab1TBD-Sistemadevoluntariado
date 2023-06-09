package lab1.tbd.serviciovoluntariado.services;

import lab1.tbd.serviciovoluntariado.models.Institucion;
import lab1.tbd.serviciovoluntariado.repositories.InstitucionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/institucion")
public class InstitucionService {

    @Autowired
    InstitucionRepository institucionRepository;

    @GetMapping
    public List<Institucion> getAllInstitucion(){
        return institucionRepository.getAllInstitucion();
    }

    @GetMapping("/{id}")
    public Institucion getInstitucionById(@PathVariable(value = "id") Long id){
        return institucionRepository.getInstitucionById(id);
    }

    @GetMapping("/count")
    private Integer countInstitucion(){
        return institucionRepository.countInstitucion();
    }

    @PostMapping
    @ResponseBody
    public Institucion createInstitucion(@RequestBody Institucion institucion){
        Institucion result = institucionRepository.createInstitucion(institucion);
        return result;
    }

    @PutMapping
    @ResponseBody
    public Institucion updateInstitucion(@RequestBody Institucion institucion){
        Institucion result = institucionRepository.updateInstitucion(institucion);
        return result;
    }

    @DeleteMapping("/{id}")
    public void deleteInstitucionById(@PathVariable(value = "id") Long id){
        institucionRepository.deleteInstitucionById(id);
    }
}
