package lab1.tbd.serviciovoluntariado.security;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lab1.tbd.serviciovoluntariado.ServiciovoluntariadoApplication;
import lab1.tbd.serviciovoluntariado.models.Usuario;
import lab1.tbd.serviciovoluntariado.repositories.UsuarioRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository
                .findOneByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("el usuario con email " + email + "no existe" ));
        return new UserDetailsImpl(usuario);
    }

 
    
}
