package Entidades;

public class TipoHabitacion {

    private int idTipoHabitacion;
    private String nombre;
    private String descripcion;

    public TipoHabitacion() {
    }

    public TipoHabitacion(int idTipoHabitacion, String nombre, String descripcion) {
        this.idTipoHabitacion = idTipoHabitacion;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getIdTipoHabitacion() {
        return idTipoHabitacion;
    }

    public void setIdTipoHabitacion(int idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return idTipoHabitacion + ", " + nombre + ", " + descripcion;
    }

}
