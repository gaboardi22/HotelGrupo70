
package Entidades;

public class TipoHabitacion {
    private int idTipoHabitacion;
    private int cantidadPersonas;
    private  int cantidadCamas;
    private String tipoCamas;
    private Double precioNoche;

    public TipoHabitacion() {
    }

    public TipoHabitacion(int cantidadPersonas, int cantidadCamas, String tipoCamas, Double precioNoche) {
        this.cantidadPersonas = cantidadPersonas;
        this.cantidadCamas = cantidadCamas;
        this.tipoCamas = tipoCamas;
        this.precioNoche = precioNoche;
    }

    public TipoHabitacion(int idTipoHabitacion, int cantidadPersonas, int cantidadCamas, String tipoCamas, Double precioNoche) {
        this.idTipoHabitacion = idTipoHabitacion;
        this.cantidadPersonas = cantidadPersonas;
        this.cantidadCamas = cantidadCamas;
        this.tipoCamas = tipoCamas;
        this.precioNoche = precioNoche;
    }

    public int getIdTipoHabitacion() {
        return idTipoHabitacion;
    }

    public void setIdTipoHabitacion(int idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public int getCantidadCamas() {
        return cantidadCamas;
    }

    public void setCantidadCamas(int cantidadCamas) {
        this.cantidadCamas = cantidadCamas;
    }

    public String getTipoCamas() {
        return tipoCamas;
    }

    public void setTipoCamas(String tipoCamas) {
        this.tipoCamas = tipoCamas;
    }

    public Double getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(Double precioNoche) {
        this.precioNoche = precioNoche;
    }

    @Override
    public String toString() {
        return "TipoHabitacion{" + "idTipoHabitacion=" + idTipoHabitacion + ", cantidadPersonas=" + cantidadPersonas + ", cantidadCamas=" + cantidadCamas + ", tipoCamas=" + tipoCamas + ", precioNoche=" + precioNoche + '}';
    }
    
    
    
}   
