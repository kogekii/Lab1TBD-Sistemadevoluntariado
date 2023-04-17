package lab1.tbd.serviciovoluntariado.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class TareaHabilidad {
    private Long id;
    private Long id_emehab;
    private Long id_tarea;

    public TareaHabilidad(Long id, Long id_emehab, Long id_tarea) {
        this.id = id;
        this.id_emehab = id_emehab;
        this.id_tarea = id_tarea;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_emehab() {
        return id_emehab;
    }

    public void setId_emehab(Long id_emehab) {
        this.id_emehab = id_emehab;
    }

    public Long getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(Long id_tarea) {
        this.id_tarea = id_tarea;
    }
}
