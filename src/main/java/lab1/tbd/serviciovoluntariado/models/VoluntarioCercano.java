package lab1.tbd.serviciovoluntariado.models;

import lombok.Data;

@Data
public class VoluntarioCercano
{
    private Long id;
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String coordenadas;
    private double longitude;
    private double latitude;

    /* Getters & Setters */

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre(){ return nombre; }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido(){ return apellido; }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreoElectronico(){ return correoElectronico; }
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
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
