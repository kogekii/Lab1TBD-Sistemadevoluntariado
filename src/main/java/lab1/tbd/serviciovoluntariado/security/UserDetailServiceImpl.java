package lab1.tbd.serviciovoluntariado.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lab1.tbd.serviciovoluntariado.models.Coordinador;
import lab1.tbd.serviciovoluntariado.repositories.CoordinadorRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService
{
    @Autowired
    private CoordinadorRepository coordinadorRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Usuario usuario = usuarioRepository
        //         .findOneByEmail(email)
        //         .orElseThrow(() -> new UsernameNotFoundException("el usuario con email " + email + "no existe" ));
        // return new UserDetailsImpl(usuario);

        Coordinador coordinador = coordinadorRepository.findOneByEmail(email);
        if(coordinador == null){
            throw new UsernameNotFoundException("el usuario con email " + email + "no existe" );
        }
        return new UserDetailsImpl(coordinador);
    }   
}
