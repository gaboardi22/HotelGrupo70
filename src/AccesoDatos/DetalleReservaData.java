
package AccesoDatos;

import Entidades.DetalleReserva;
import Entidades.Habitacion;
import Entidades.Reserva;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


public class DetalleReservaData {
    private Connection con;

    public DetalleReservaData(Connection con) {
        con = Conexion.getConexion();
    }
    
public List<DetalleReserva> nuevoDetalleReservaData(Reserva reserva, Habitacion habitacion){
        List<DetalleReserva>detalleReservas = new ArrayList<>();
        String SQL= "SELECT * FROM d detallereserva ";
   
                
        return detalleReservas ;       
}
}