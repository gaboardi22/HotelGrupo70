
package AccesoDatos;

import Entidades.Habitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class HabitacionData {
    private Connection con;

    public HabitacionData(Connection con) {
        con = Conexion.getConexion();
    }
    
    public void crearHabitacion(Habitacion habitacion){
   
        String SQL = "INSERT INTO habitacion (estado, tipoHabitacion,piso) VALUES (?,?,?)";
        try {
            
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setBoolean(1, true);
            ps.se
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la BDD");
        }
        
    }
    
}
