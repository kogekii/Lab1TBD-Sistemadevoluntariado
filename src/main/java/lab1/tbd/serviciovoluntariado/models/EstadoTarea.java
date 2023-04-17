package lab1.tbd.serviciovoluntariado.models;


import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class EstadoTarea {
    private Long id;
    private String descrip;

    public EstadoTarea(Long id, String descrip) {
        this.id = id;
        this.descrip = descrip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
}
