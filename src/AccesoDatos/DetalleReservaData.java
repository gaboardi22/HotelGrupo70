
package AccesoDatos;

import Entidades.DetalleReserva;
import Entidades.Habitacion;
import Entidades.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class DetalleReservaData {

    private Connection con;

    public DetalleReservaData(Connection con) {
        con = Conexion.getConexion();
    }
    
    public void insertarDetalleReserva(List<Habitacion> habitaciones, int idReserva){
        String SQL = "INSERT INTO  detallereserva(idReserva, idHabitacion) VALUES (?, ?)";
        
        
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "error al conectarse a la BDD");
        }
        
    }

    public List<DetalleReserva> nuevoDetalleReservaData(Reserva reserva, Habitacion habitacion) {
        List<DetalleReserva> detalleReservas = new ArrayList<>();
        String SQL = "SELECT * FROM d detallereserva ";

        return detalleReservas;
    }
}
