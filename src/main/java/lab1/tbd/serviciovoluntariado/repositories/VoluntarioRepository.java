package lab1.tbd.serviciovoluntariado.repositories;

import lab1.tbd.serviciovoluntariado.models.Voluntario;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoluntarioRepository extends JpaRepository<Voluntario, Integer>{
    // public int countVoluntario();
    // public List<Voluntario> getAllVoluntario();
    // public Voluntario getVoluntarioById(Long id);
    // public Voluntario createVoluntario(Voluntario v);
    // public Voluntario updateVoluntario(Voluntario v);
    // public void deleteVoluntarioById(Long id);
    public Optional<Voluntario> findOneByCorreoElectronico(String email);
}
