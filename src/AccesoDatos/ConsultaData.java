package AccesoDatos;

import Entidades.TipoHabitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;

public class ConsultaData {

    private Connection con;

    public ConsultaData() {
        con = Conexion.getConexion();
    }

    // Acceso a datos de Tipo de Habitación
    public List<TipoHabitacion> listarTipoHabitacion() {
        List<TipoHabitacion> tiposHabitacion = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tipohabitacion;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TipoHabitacion tipoHabitacion = new TipoHabitacion();
                tipoHabitacion.setIdTipoHabitacion(rs.getInt("idHabitacion"));
                tipoHabitacion.setCodigo(rs.getString("codigo"));
                tipoHabitacion.setCapacidad(rs.getInt("capacidad"));
                tipoHabitacion.setCantidadCamas(rs.getInt("cantidadCamas"));
                tipoHabitacion.setTipoCamas(rs.getString("tipoCamas"));
                tipoHabitacion.setPrecioNoche(rs.getDouble("precioNoche"));
                tiposHabitacion.add(tipoHabitacion);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla TiposHabitacion: " + e.getMessage());
        }
        return tiposHabitacion;
    }

    public void agregarTipoHabitacion(TipoHabitacion tipoHabitacion) {
        try {
            String sql = "INSERT INTO tipohabitacion(codigo, capacidad, cantidadCamas, tipoCamas, precioNoche) "
                    + "VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,"\"" + tipoHabitacion.getCodigo() + "\"");
            ps.setInt(2, tipoHabitacion.getCapacidad());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla TiposHabitacion: " + e.getMessage());
        }
    }

    // Acceso a datos de Habitació
    // Acceso a datos de Huesped
    // Acceso a datos de Reserva
    // Acceso a datos de Detalle Reserva
}
