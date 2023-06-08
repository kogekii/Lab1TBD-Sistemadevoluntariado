package lab1.tbd.serviciovoluntariado.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lab1.tbd.serviciovoluntariado.models.Registration;
import lab1.tbd.serviciovoluntariado.models.Usuario;
import lab1.tbd.serviciovoluntariado.repositories.UsuarioRepository;

@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Registration registration){

        Usuario usuario = new Usuario();
        usuario.setEmail(registration.getEmail());
        usuario.setName(registration.getPassword());
        usuario.setPassword(new BCryptPasswordEncoder().encode(registration.getPassword()));
        usuarioRepository.save(usuario);
        return ResponseEntity.ok("usuario añadido");
    }
}
