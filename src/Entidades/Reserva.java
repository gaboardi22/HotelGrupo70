
package Entidades;

import java.time.LocalDate;

public class Reserva {
    private int idReserva;
    private Huesped huesped;
    private Habitacion habitacion;
    private LocalDate fechaCheckIn;
    private LocalDate fechaCheckOut;
    private int cantidadDeDias;
    private boolean estado;
    private double montoAPagar;
    private int cantidadDePersonas;

    public Reserva() {
    }

    public Reserva(Huesped huesped, Habitacion habitacion, LocalDate fechaCheckIn, LocalDate fechaCheckOut, int cantidadDeDias, boolean estado, double montoAPagar, int cantidadDePersonas) {
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.fechaCheckIn = fechaCheckIn;
        this.fechaCheckOut = fechaCheckOut;
        this.cantidadDeDias = cantidadDeDias;
        this.estado = estado;
        this.montoAPagar = montoAPagar;
        this.cantidadDePersonas = cantidadDePersonas;
    }

    public Reserva(int idReserva, Huesped huesped, Habitacion habitacion, LocalDate fechaCheckIn, LocalDate fechaCheckOut, int cantidadDeDias, boolean estado, double montoAPagar, int cantidadDePersonas) {
        this.idReserva = idReserva;
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.fechaCheckIn = fechaCheckIn;
        this.fechaCheckOut = fechaCheckOut;
        this.cantidadDeDias = cantidadDeDias;
        this.estado = estado;
        this.montoAPagar = montoAPagar;
        this.cantidadDePersonas = cantidadDePersonas;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public LocalDate getFechaCheckIn() {
        return fechaCheckIn;
    }

    public void setFechaCheckIn(LocalDate fechaCheckIn) {
        this.fechaCheckIn = fechaCheckIn;
    }

    public LocalDate getFechaCheckOut() {
        return fechaCheckOut;
    }

    public void setFechaCheckOut(LocalDate fechaCheckOut) {
        this.fechaCheckOut = fechaCheckOut;
    }

    public int getCantidadDeDias() {
        return cantidadDeDias;
    }

    public void setCantidadDeDias(int cantidadDeDias) {
        this.cantidadDeDias = cantidadDeDias;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getMontoAPagar() {
        return montoAPagar;
    }

    public void setMontoAPagar(double montoAPagar) {
        this.montoAPagar = montoAPagar;
    }

    public int getCantidadDePersonas() {
        return cantidadDePersonas;
    }

    public void setCantidadDePersonas(int cantidadDePersonas) {
        this.cantidadDePersonas = cantidadDePersonas;
    }

    @Override
    public String toString() {
        return "Reserva{" + "idReserva=" + idReserva + ", huesped=" + huesped + ", habitacion=" + habitacion + ", fechaCheckIn=" + fechaCheckIn + ", fechaCheckOut=" + fechaCheckOut + ", cantidadDeDias=" + cantidadDeDias + ", estado=" + estado + ", montoAPagar=" + montoAPagar + ", cantidadDePersonas=" + cantidadDePersonas + '}';
    }
    
}
