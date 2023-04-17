package lab1.tbd.serviciovoluntariado.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Ranking {
    private Long id;
    private Long id_voluntario;
    private Long id_tarea;
    private Integer puntaje;
    private Integer flg_invitado;
    private Integer flg_participa;

    public Ranking(Long id, Long id_voluntario, Long id_tarea, Integer puntaje, Integer flg_invitado, Integer flg_participa) {
        this.id = id;
        this.id_voluntario = id_voluntario;
        this.id_tarea = id_tarea;
        this.puntaje = puntaje;
        this.flg_invitado = flg_invitado;
        this.flg_participa = flg_participa;
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

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public Integer getFlg_invitado() {
        return flg_invitado;
    }

    public void setFlg_invitado(Integer flg_invitado) {
        this.flg_invitado = flg_invitado;
    }

    public Integer getFlg_participa() {
        return flg_participa;
    }

    public void setFlg_participa(Integer flg_participa) {
        this.flg_participa = flg_participa;
    }
}
