package lab1.tbd.serviciovoluntariado.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Date;

@EntityScan
public class Tarea {
    private Long id;
    private String nombre;
    private String descripcion;
    private Long id_estado_tarea;
    private Date created_at;
    private Date updated_at;
    private Long id_emergencia;
    private String coordenadas;
    private double longitude;
    private double latitude;


    //Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre(){ return nombre; }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion(){ return descripcion; }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getIdEstadoTarea() {
        return id_estado_tarea;
    }
    public void setIdEstadoTarea(Long id) {
        this.id_estado_tarea = id;
    }

    public Long getIdEmergencia() { return id_emergencia; }
    public void setIdEmeTarea(Long id) { this.id_emergencia = id; }

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

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }
}
