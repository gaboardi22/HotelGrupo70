
package AccesoDatos;

import Entidades.DetalleReserva;
import Entidades.Habitacion;
import Entidades.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

    public List<Habitacion> listarHabitacionesDisponibles(LocalDate fechaEntrada, LocalDate fechaSalida) {
        List<Habitacion> habitacionesDisponibles = new ArrayList<>();
        String SQL = "SELECT * FROM habitacion\n" +
"INNER JOIN tipohabitacion ON habitacion.tipoHabitacion = tipohabitacion.idTipoHabitacion\n" +
"WHERE habitacion.idHabitacion NOT IN (\n" +
" SELECT DISTINCT r.idReserva\n" +
" FROM reserva r\n" +
" WHERE ('2023-10-12' NOT BETWEEN r.fechaCheckIn AND r.fechaCheckOut)\n" +
" AND ('2023-10-22' NOT BETWEEN r.fechaCheckIn AND r.fechaCheckOut)\n" +
");";
        
        return habitacionesDisponibles;
    }
  
    
    
}
