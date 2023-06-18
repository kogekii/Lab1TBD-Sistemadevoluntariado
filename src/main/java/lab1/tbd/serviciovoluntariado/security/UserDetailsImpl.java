package lab1.tbd.serviciovoluntariado.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lab1.tbd.serviciovoluntariado.models.Coordinador;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails{

    // private final Usuario usuario;
    private final Coordinador coordinador;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        // return usuario.getPassword();
        return coordinador.getPassword();
    }

    @Override
    public String getUsername() {
        // return usuario.getEmail();
        return coordinador.getCorreo_electronico();
    }

    @Override
    public boolean isAccountNonExpired() {
       return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
       return true;
    }

    public String getNombre() {
        // return usuario.getName();'
        return coordinador.getNombre();
    }

    
}
