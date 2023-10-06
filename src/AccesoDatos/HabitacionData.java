package AccesoDatos;

import Entidades.Habitacion;
import Entidades.TipoHabitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class HabitacionData {

    private Connection con;

    public HabitacionData() {
        con = Conexion.getConexion();
    }

    public void crearHabitacion(Habitacion habitacion) {

        String SQL = "INSERT INTO habitacion (estado, tipoHabitacion, piso) VALUES (?,?,?)";
        try {

            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setBoolean(1, true);
            ps.setInt(2, habitacion.getTipoHabitacion().getIdTipoHabitacion());
            ps.setInt(3, habitacion.getPiso());
            int registro = ps.executeUpdate();
            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "habitacion creada con exito");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la BDD");
        }
    }

    public void actualizarHabitacion(Habitacion habitacion) {
        String SQL = "UPDATE habitacion SET estado = ?, tipoHabitacion = ?, piso = ? WHERE idHabitacion = ?";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setBoolean(1, habitacion.isEstado());
            ps.setInt(2, habitacion.getTipoHabitacion().getIdTipoHabitacion());
            ps.setInt(3, habitacion.getPiso());
            ps.setInt(4, habitacion.getIdHabitacion());
            int registro = ps.executeUpdate();
            if(registro >0){
                JOptionPane.showMessageDialog(null, "habitacion modificada con exito");
            }else{
                JOptionPane.showMessageDialog(null, "no se pudo modificar la habitacion");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la BDD");
        }
    }
    public void eliminarHabitacion(int id){
         String SQL = "DELETE FROM habitacion WHERE idHabitacion = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            int registro = ps.executeUpdate();
            if(registro >0){
                JOptionPane.showMessageDialog(null, "habitacion eliminada con exito");
            }else{
                JOptionPane.showMessageDialog(null, "no se pudo eliminar la habitacion"); 
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la BDD");
        }
    }
    public List<Habitacion> listarHabitacion(){
        List<Habitacion> habitaciones = new ArrayList<>();
        String SQL = "SELECT * FROM habitacion";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Habitacion habitacion = new Habitacion();
                TipoHabitacion tipoHabitacion = new TipoHabitacion();
                habitacion.setIdHabitacion(rs.getInt("idHabitacion"));
                habitacion.setEstado(rs.getBoolean("estado"));
                habitacion.setPiso(rs.getInt("piso"));
                tipoHabitacion.setIdTipoHabitacion(rs.getInt("idHabitacion"));
                tipoHabitacion.setCantidadPersonas(rs.getInt("cantidadPersonas"));
                tipoHabitacion.setCantidadCamas(rs.getInt("cantidadCamas"));
                tipoHabitacion.setTipoCamas(rs.getString("tipoCamas"));
                tipoHabitacion.setPrecioNoche(rs.getDouble("precioNoche"));
                habitacion.setTipoHabitacion(tipoHabitacion);
                habitaciones.add(habitacion);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la BDD");
        }
        return habitaciones;
    }
}
