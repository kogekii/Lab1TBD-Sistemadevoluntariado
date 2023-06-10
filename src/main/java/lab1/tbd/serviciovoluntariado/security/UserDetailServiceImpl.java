package lab1.tbd.serviciovoluntariado.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lab1.tbd.serviciovoluntariado.models.Usuario;
import lab1.tbd.serviciovoluntariado.models.Voluntario;
import lab1.tbd.serviciovoluntariado.repositories.UsuarioRepository;
import lab1.tbd.serviciovoluntariado.repositories.VoluntarioRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

    // @Autowired
    // private UsuarioRepository usuarioRepository;
    @Autowired
    private VoluntarioRepository voluntarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Usuario usuario = usuarioRepository
        //         .findOneByEmail(email)
        //         .orElseThrow(() -> new UsernameNotFoundException("el usuario con email " + email + "no existe" ));
        // return new UserDetailsImpl(usuario);

        Voluntario voluntario = voluntarioRepository
                .findOneByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("el usuario con email " + email + "no existe" ));
        return new UserDetailsImpl(voluntario);
    }

 
    
}
