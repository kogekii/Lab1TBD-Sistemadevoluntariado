package lab1.tbd.serviciovoluntariado.models;


import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Instituicion {

    private Long id;
    private String nombre;
    private String descrip;

    public Instituicion(Long id, String nombre, String descrip) {
        this.id = id;
        this.nombre = nombre;
        this.descrip = descrip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
}
