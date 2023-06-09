package lab1.tbd.serviciovoluntariado.services;
import lab1.tbd.serviciovoluntariado.models.Coordinador;
import lab1.tbd.serviciovoluntariado.repositories.CoordinadorRepository;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class CoordinadorService {
    private final CoordinadorRepository coordinadorRepository;

    //Constructor
    CoordinadorService(CoordinadorRepository coordinadorRepository){
        this.coordinadorRepository = coordinadorRepository;
    }

    //Create
    @PostMapping("/coodinador")
    @ResponseBody
    public String createCoordinador(@RequestBody Coordinador coordinador){
        return coordinadorRepository.createCoordinador(coordinador);
    }

    //Read all
    @GetMapping("/coodinador")
    public List<Coordinador> getAllCoordinador(){
        return coordinadorRepository.getAllCoordinador();

    }

    //Leer uno
    @GetMapping("/coordinador/{id}")
    @ResponseBody
    public Coordinador getCoordinadorById(@PathVariable int id){
        return this.coordinadorRepository.getCoordinadorById(id);
    }

    //Update
    @PutMapping("/coodinador/update/{id}")
    @ResponseBody
    public String updateCoordinador(@PathVariable int id, @RequestBody Coordinador coordinador){
        return coordinadorRepository.updateCoordinador(id, coordinador);
    }

    //Delete
    @DeleteMapping("/coodinador/delete/id={id}")
    @ResponseBody
    public String deleteCoordinador(@PathVariable int id){
        return coordinadorRepository.deleteCoordinador(id);
    }
}