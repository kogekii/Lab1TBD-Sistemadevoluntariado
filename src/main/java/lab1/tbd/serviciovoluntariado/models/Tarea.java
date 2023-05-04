package lab1.tbd.serviciovoluntariado.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Date;

@EntityScan
public class Tarea {
    private Long id;
    private String nombre;
    private String descrip;
    private Integer cant_vol_requeridos;
    private Integer cant_vol_inscritos;
    private Long id_emergencia;
    private Date finicio;
    private Date ffin;
    private Long id_estado;

    public Tarea(Long id, String nombre, String descrip, Integer cant_vol_requeridos, Integer cant_vol_inscritos, Long id_emergencia, Date finicio, Date ffin, Long id_estado) {
        this.id = id;
        this.nombre = nombre;
        this.descrip = descrip;
        this.cant_vol_requeridos = cant_vol_requeridos;
        this.cant_vol_inscritos = cant_vol_inscritos;
        this.id_emergencia = id_emergencia;
        this.finicio = finicio;
        this.ffin = ffin;
        this.id_estado = id_estado;
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

    public Integer getCant_vol_requeridos() {
        return cant_vol_requeridos;
    }

    public void setCant_vol_requeridos(Integer cant_vol_requeridos) {
        this.cant_vol_requeridos = cant_vol_requeridos;
    }

    public Integer getCatn_vol_inscritos() {
        return cant_vol_inscritos;
    }

    public void setCatn_vol_inscritos(Integer catn_vol_inscritos) {
        this.cant_vol_inscritos = catn_vol_inscritos;
    }

    public Long getId_emergencia() {
        return id_emergencia;
    }

    public void setId_emergencia(Long id_emergencia) {
        this.id_emergencia = id_emergencia;
    }

    public Date getFinicio() {
        return finicio;
    }

    public void setFinicio(Date finicio) {
        this.finicio = finicio;
    }

    public Date getFfin() {
        return ffin;
    }

    public void setFfin(Date ffin) {
        this.ffin = ffin;
    }

    public Long getId_estado() {
        return id_estado;
    }

    public void setId_estado(Long id_estado) {
        this.id_estado = id_estado;
    }
}
