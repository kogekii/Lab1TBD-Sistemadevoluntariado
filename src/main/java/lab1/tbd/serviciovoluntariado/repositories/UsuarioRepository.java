package lab1.tbd.serviciovoluntariado.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lab1.tbd.serviciovoluntariado.models.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> findOneByEmail(String email);

}
