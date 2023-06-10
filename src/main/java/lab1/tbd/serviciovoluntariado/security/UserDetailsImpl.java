package lab1.tbd.serviciovoluntariado.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lab1.tbd.serviciovoluntariado.models.Usuario;
import lab1.tbd.serviciovoluntariado.models.Voluntario;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails{

    // private final Usuario usuario;
    private final Voluntario voluntario;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        // return usuario.getPassword();
        return voluntario.getPassword();
    }

    @Override
    public String getUsername() {
        // return usuario.getEmail();
        return voluntario.getEmail();
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
        return voluntario.getNombre();
    }

    
}
