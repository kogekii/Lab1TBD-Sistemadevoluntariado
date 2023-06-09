package lab1.tbd.serviciovoluntariado.models;

public class VolCantidadHabilidades {
    private Long id;
    private int cantidad_habilidades;
    private String nombre;
    private String apellido;
    private String estado_salud;

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEstadoSalud() {
        return estado_salud;
    }

    public void setEstadoSalud(String estado_salud) {
        this.estado_salud = estado_salud;
    }
    public int getCantidadHabilidades() {
        return cantidad_habilidades;
    }

    public void setCantidadHabilidades(int cantidad_habilidades) {
        this.cantidad_habilidades = cantidad_habilidades;
    }
}
