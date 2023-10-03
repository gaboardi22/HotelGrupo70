package Entidades;

public class Habitacion {

    private int idHabitacion;
    private int numero;
    private int piso;
    private boolean estado;
    TipoHabitacion tipo;

    public Habitacion() {
    }

    public Habitacion(int idHabitacion, int numero, int piso, boolean estado, TipoHabitacion tipo) {
        this.idHabitacion = idHabitacion;
        this.numero = numero;
        this.piso = piso;
        this.estado = estado;
        this.tipo = tipo;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public TipoHabitacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoHabitacion tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        String estadoHabitacion = "";
        if(estado){
        estadoHabitacion = "Libre";
        } else {
            estadoHabitacion = "Ocupado";
        }
        return "Id: " + idHabitacion + ", N°: " + numero + ", Piso: " + piso + ", Estado: " + estadoHabitacion + ", Tipo: " + tipo;
    }

}
