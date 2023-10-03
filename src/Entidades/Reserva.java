package Entidades;

import java.time.LocalDate;

public class Reserva {

    private int idReserva;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int dias;
    private double monto;
    private boolean estado;
    private Huesped huesped;
    private Habitacion habitacion;
    private String observacion;

    public Reserva() {
    }

    public Reserva(int idReserva, LocalDate fechaInicio, LocalDate fechaFin, int dias, double monto, boolean estado, Huesped huesped, Habitacion habitacion, String observacion) {
        this.idReserva = idReserva;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.dias = dias;
        this.monto = monto;
        this.estado = estado;
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.observacion = observacion;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
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

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Override
    public String toString() {
        String estadoHabitacion = "";
        if(estado){
        estadoHabitacion = "Libre";
        } else {
            estadoHabitacion = "Ocupado";
        }
        return "idReserva: " + idReserva + ", Inicio: " + fechaInicio + ", Fin: " + fechaFin + ", Dias: " + dias + ", Monto: " + monto + ", Estado=" + estadoHabitacion + ", Huesped: " + huesped + ", Habitacion: " + habitacion + ", Observacion: " + observacion;
    }
    
}
