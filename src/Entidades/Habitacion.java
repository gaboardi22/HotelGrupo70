
package Entidades;


public class Habitacion  {
    
    private int idHabitacion;
    private boolean estado;
    private TipoHabitacion tipoHabitacion;
    private int piso;

    public Habitacion() {
    }

    public Habitacion(boolean estado, TipoHabitacion tipoHabitacion, int piso) {
        this.estado = estado;
        this.tipoHabitacion = tipoHabitacion;
        this.piso = piso;
    }

    public Habitacion(int idHabitacion, boolean estado, TipoHabitacion tipoHabitacion, int piso) {
        this.idHabitacion = idHabitacion;
        this.estado = estado;
        this.tipoHabitacion = tipoHabitacion;
        this.piso = piso;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "idHabitacion=" + idHabitacion + ", estado=" + estado + ", tipoHabitacion=" + tipoHabitacion + ", piso=" + piso + '}';
    }
    
}
