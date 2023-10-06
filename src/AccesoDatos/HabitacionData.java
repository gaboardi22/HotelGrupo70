
package AccesoDatos;

import Entidades.Habitacion;
import Entidades.TipoHabitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class HabitacionData {
    private Connection con;
    private TipoHabitacion tHab;

    public HabitacionData(Connection con) {
        con = Conexion.getConexion();
    }
    
    public void crearHabitacion(Habitacion habitacion){
           
        String SQL = "INSERT INTO habitacion (estado, tipoHabitacion, piso) VALUES (?,?,?)";
        try {
            
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setBoolean(1, true);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la BDD");
        }
        
    }
    
}
