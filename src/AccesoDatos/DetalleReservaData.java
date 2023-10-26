
package AccesoDatos;

import Entidades.DetalleReserva;
import Entidades.Habitacion;
import Entidades.Reserva;
import Entidades.TipoHabitacion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class DetalleReservaData {

    private Connection con;

    public DetalleReservaData() {
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
" WHERE (? NOT BETWEEN r.fechaCheckIn AND r.fechaCheckOut)\n" +
" AND (? NOT BETWEEN r.fechaCheckIn AND r.fechaCheckOut));";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setDate(1, Date.valueOf(fechaEntrada));
            ps.setDate(2, Date.valueOf(fechaSalida));
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                 Habitacion habitacion = new Habitacion();
                 TipoHabitacion tipoHabitacion = new TipoHabitacion();
                 habitacion.setNumeroHabitacion(rs.getInt("numeroHabitacion"));
                 habitacion.setPiso(rs.getInt("piso"));
                 tipoHabitacion.setCantidadCamas(rs.getInt("cantidadCamas"));
                 tipoHabitacion.setCantidadPersonas(rs.getInt("cantidadPersonas"));
                 tipoHabitacion.setTipoCamas(rs.getString("tipoCamas"));
                 tipoHabitacion.setPrecioNoche(rs.getDouble("precioNoche"));
                 habitacion.setTipoHabitacion(tipoHabitacion);
                 habitacionesDisponibles.add(habitacion);
            }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Reserva/Detalle: " + ex.getMessage());;
        }
        return habitacionesDisponibles;
    }
  
    
    
}
