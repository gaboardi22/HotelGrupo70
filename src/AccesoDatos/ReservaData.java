
package AccesoDatos;

import Entidades.Habitacion;
import Entidades.Huesped;
import java.sql.Connection;


public class ReservaData {
    private Connection con;

    public ReservaData() {
        con = Conexion.getConexion();
    }
    
    public void insertarReserva(Huesped huesped, Habitacion habitacion){
        String SQL = "INSERT INTO reserva (huesped, habitacion, fechaChekIn, fechaCheckOut, cantidadDias, estado, montoAPagar, cantidadPersonas)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
    }
}
