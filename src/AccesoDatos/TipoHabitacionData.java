package AccesoDatos;

import Entidades.TipoHabitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TipoHabitacionData {

    private Connection con;

    public TipoHabitacionData() {
        con = Conexion.getConexion();
    }

    public void insertarTipoHabitacion(TipoHabitacion tipoHabitacion) {
        String sql = "INSERT INTO tipohabitacion (cantidadPersonas, cantidadCamas, tipoCamas, precioNoche) VALUES (?,?,?,?) ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, tipoHabitacion.getCantidadPersonas());
            ps.setInt(2, tipoHabitacion.getCantidadCamas());
            ps.setString(3, tipoHabitacion.getTipoCamas());
            ps.setDouble(4, tipoHabitacion.getPrecioNoche());
            //inserta un tipoHab 
            int registro = ps.executeUpdate();
            if (registro != 0) {
                JOptionPane.showMessageDialog(null, "Se registro un nuevo tipoHabitacion con exito");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la BDD");
        }
    }

    public void actualizarTipoHabitacion(TipoHabitacion tipoHabitacion) {
        String sql = "UPDATE tipohabitacion SET cantidadPersonas = ?, cantidadCamas = ?, tipoCamas = ?, precioNoche = ? "
                + " WHERE idTipoHabitacion = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, tipoHabitacion.getCantidadPersonas());
            ps.setInt(2, tipoHabitacion.getCantidadCamas());
            ps.setString(3, tipoHabitacion.getTipoCamas());
            ps.setDouble(4, tipoHabitacion.getPrecioNoche());
            ps.setInt(5, tipoHabitacion.getIdTipoHabitacion());
            int registro = ps.executeUpdate();
            if (registro != 0) {
                JOptionPane.showMessageDialog(null, "Se modifico el tipoHabitacion con exito");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la BDD");
        }
    }

    public void eliminarTipoHabitacion(int id) {
        String sql = "DELETE FROM tipohabitacion WHERE idTipoHabitacion = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int registro = ps.executeUpdate();
            if (registro != 0) {
                JOptionPane.showMessageDialog(null, "Se elimino el tipoHabitacion con exito");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la BDD");
        }

    }
    public List<TipoHabitacion>consultaTipoHabitacion(){
       List <TipoHabitacion> tiposhabitacion = new ArrayList<>();
       String sql = " SELECT * FROM tipohabitacion ";
       PreparedStatement ps = con.prepareStatement(sql);
       ResultSet rs = ps.executeQuery();
       while(rs.next()){
           TipoHabitacion tipoHabitacion = new TipoHabitacion();
       } 
    return tiposhabitacion;
    }
    
}
