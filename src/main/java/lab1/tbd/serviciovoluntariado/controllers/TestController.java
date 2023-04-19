package lab1.tbd.serviciovoluntariado.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class TestController {
    @GetMapping("/{name}")
    public String sayMyName(@PathVariable String name) {
        return "My name is " + name;
    }
    
}
