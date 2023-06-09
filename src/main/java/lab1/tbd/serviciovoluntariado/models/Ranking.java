package lab1.tbd.serviciovoluntariado.models;

import java.util.Date;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Ranking {
    private Long id;
    private Long id_voluntario;
    private Long id_tarea;
    private Integer puntos;
    private Date created_at;
    private Date updated_at;

    public Ranking(Long id, Long id_voluntario, Long id_tarea, Integer puntos) {
        this.id = id;
        this.id_voluntario = id_voluntario;
        this.id_tarea = id_tarea;
        this.puntos = puntos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_voluntario() {
        return id_voluntario;
    }

    public void setId_voluntario(Long id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    public Long getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(Long id_tarea) {
        this.id_tarea = id_tarea;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public Date getCreatedAt() {
        return created_at;
    }
    public void setCreatedAt(Date fecha) {
        this.created_at = fecha;
    }

    public Date getUpdatedAt() {
        return updated_at;
    }
    public void setUpdateAt(Date fecha) {
        this.updated_at = fecha;
    }
}
