package lab1.tbd.serviciovoluntariado.repositories;

import lab1.tbd.serviciovoluntariado.models.Institucion;

import java.util.List;

public interface InstitucionRepository {
    public int countInstitucion();
    public List<Institucion> getAllInstitucion();
    public Institucion getInstitucionById(Long id);
    public Institucion createInstitucion(Institucion i);
    public Institucion updateInstitucion(Institucion i);
    public void deleteInstitucionById(Long id);
}
