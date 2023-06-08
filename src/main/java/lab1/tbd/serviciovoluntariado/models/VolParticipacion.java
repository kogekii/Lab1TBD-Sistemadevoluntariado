package lab1.tbd.serviciovoluntariado.models;

public class VolParticipacion {
    private int id;
    private String nombre;
    private String apellido;
    private int cantidad_tareas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getCantidad_tareas() {
        return cantidad_tareas;
    }

    public void setCantidad_tareas(int cantidad_tareas) {
        this.cantidad_tareas = cantidad_tareas;
    }

}