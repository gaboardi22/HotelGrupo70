
package Entidades;

import java.time.LocalDate;
import static java.time.temporal.TemporalQueries.localDate;

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

    @Override
    public String toString() {
        return "Reserva{" + "idReserva=" + idReserva + ", huesped=" + huesped + ", habitacion=" + habitacion + ", fechaCheckIn=" + fechaCheckIn + ", fechaCheckOut=" + fechaCheckOut + ", cantidadDeDias=" + cantidadDeDias + ", estado=" + estado + ", montoAPagar=" + montoAPagar + ", cantidadDePersonas=" + cantidadDePersonas + '}';
    }
    
}
