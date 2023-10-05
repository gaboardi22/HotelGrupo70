package AccesoDatos;

import Entidades.Estado;
import Entidades.Habitacion;
import Entidades.Huesped;
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
            //Preparar la conexión con la query
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //Modificar la query con los parametros recibidos
            ps.setString(1, "\"" + tipoHabitacion.getCodigo() + "\"");
            ps.setInt(2, tipoHabitacion.getCapacidad());
            ps.setInt(3, tipoHabitacion.getCantidadCamas());
            ps.setString(4, "\"" + tipoHabitacion.getTipoCamas() + "\"");
            ps.setDouble(5, tipoHabitacion.getPrecioNoche());
            //Ejecutar la query para insert, update o delete
            ps.executeUpdate();
            //Recuperar la clave primaria del insert
            ResultSet rs = ps.getGeneratedKeys();
            //Evaluar exito al insertar Tipo de Habitación
            if (rs.next()) {
                tipoHabitacion.setIdTipoHabitacion(rs.getInt("insert_id"));
                JOptionPane.showMessageDialog(null, "Tipo de Habitación añadido con éxito.");
            }
            //Cerrar el statment
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla TipoHabitacion: " + e.getMessage());
        }
    }

    public void modificarTipoHabitacion(TipoHabitacion tipoHabitacion) {
        try {
            String sql = "UPDATE tipohabitacion "
                    + "SET codigo = ?, capacidad =?, cantidadCamas = ?, tipoCamas = ?, precioNoche = ? "
                    + "WHERE  idTipoHabitacion = ?;";
            //Preparar la conexión con la query
            PreparedStatement ps = con.prepareStatement(sql);
            //Modificar la query con los parametros recibidos
            ps.setString(1, "\"" + tipoHabitacion.getCodigo() + "\"");
            ps.setInt(2, tipoHabitacion.getCapacidad());
            ps.setInt(3, tipoHabitacion.getCantidadCamas());
            ps.setString(4, "\"" + tipoHabitacion.getTipoCamas() + "\"");
            ps.setDouble(5, tipoHabitacion.getPrecioNoche());
            ps.setInt(6, tipoHabitacion.getIdTipoHabitacion());
            //Crear variable de control de actualización
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Tipo de Habitación modificado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No fue posible modificar el Tipo de Habitación.");
            }
            //Cerrar el statment
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla TipoHabitacion: " + e.getMessage());
        }
    }

    public void eliminarTipoHabitacion(int tipoHabitacion) {
        try {
            String sql = "DELETE FROM tipohabitacion "
                    + "WHERE idTipoHabitacion = ?;";
            //Preparar la conexión con la query
            PreparedStatement ps = con.prepareStatement(sql);
            //Modificar la query con los parametros recibidos
            ps.setInt(1, tipoHabitacion);
            //Crear variable de control de actualización
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Tipo de Habitación eliminado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No fue posible eliminar el Tipo de Habitación.");
            }
            //Cerrar el statment
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla TipoHabitacion: " + e.getMessage());
        }
    }

    // Acceso a datos de Habitació
    public List<Habitacion> listarHabitaciones() {
        List<Habitacion> habitaciones = new ArrayList<>();
        try {
            String sql = "SELECT * FROM habitacion, tipoHabitacion "
                    + "WHERE habitacion.tipoHabitacion = tipoHabitacion.idTipoHabitacion;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            //Recuperar estado
            Estado estadoHabitacion = null;
            for (Estado estado : Estado.values()) {
                if (estado.toString().equalsIgnoreCase(rs.getString("estado"))) {
                    estadoHabitacion = estado;
                }
            };

            while (rs.next()) {
                // Variables de recuperación
                Habitacion habitacion = new Habitacion();
                TipoHabitacion tipoHabitacion = new TipoHabitacion();
                // Recuperar habitaciones de la BD
                habitacion.setIdHabitacion(rs.getInt("idHsbitacion"));
                habitacion.setNumero(rs.getInt("numero"));
                habitacion.setPiso(rs.getInt("piso"));
                habitacion.setEstado(estadoHabitacion);
                // Recuperar Tipo de Habitación
                tipoHabitacion.setIdTipoHabitacion(rs.getInt("idHabitacion"));
                tipoHabitacion.setCodigo(rs.getString("codigo"));
                tipoHabitacion.setCapacidad(rs.getInt("capacidad"));
                tipoHabitacion.setCantidadCamas(rs.getInt("cantidadCamas"));
                tipoHabitacion.setTipoCamas(rs.getString("tipoCamas"));
                tipoHabitacion.setPrecioNoche(rs.getDouble("precioNoche"));
                // Continua recuperación de Habitación
                habitacion.setTipoHabitacion(tipoHabitacion);
                // Agregar habitación a la lista
                habitaciones.add(habitacion);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Habitacion: " + e.getMessage());
        }
        return habitaciones;
    }

    public void agregarAbitacion(Habitacion habitacion) {
        try {
            String sql = "INSERT INTO habitacion(numero, piso, estado, tipoHabitacion) "
                    + "VALUES (?, ?, ?, ?);";
            //Preparar la conexión con la query
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //Modificar la query con los parametros recibidos
            ps.setInt(1, habitacion.getNumero());
            ps.setInt(2, habitacion.getPiso());
            ps.setString(3, "\'" + habitacion.getEstado().toString() + "\'");
            ps.setInt(4, habitacion.getTipoHabitacion().getIdTipoHabitacion());
            //Ejecutar la query para insert, update o delete
            ps.executeUpdate();
            //Recuperar la clave primaria del insert
            ResultSet rs = ps.getGeneratedKeys();
            //Evaluar exito al insertar Tipo de Habitación
            if (rs.next()) {
                habitacion.setIdHabitacion(rs.getInt("insert_id"));
                JOptionPane.showMessageDialog(null, "Habitación añadida con éxito.");
            }
            //Cerrar el statment
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Habitacion: " + e.getMessage());
        }
    }

    public void modificarHabitacion(Habitacion habitacion) {
        try {
            String sql = "UPDATE habitacion "
                    + "SET numero = ?, piso = ?, estado = ?, tipoHabitacion = ? "
                    + "WHERE idHabitacion = ?;";
            //Preparar la conexión con la query
            PreparedStatement ps = con.prepareStatement(sql);
            //Modificar la query con los parametros recibidos
            ps.setInt(1, habitacion.getNumero());
            ps.setInt(2, habitacion.getPiso());
            ps.setString(3, "\'" + habitacion.getEstado().toString() + "\'");
            ps.setInt(4, habitacion.getTipoHabitacion().getIdTipoHabitacion());
            ps.setInt(5, habitacion.getIdHabitacion());
            //Crear variable de control de actualización
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Habitación modificada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No fue posible modificar la Habitación.");
            }
            //Cerrar el statment
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Habitacion: " + e.getMessage());
        }
    }

    public void eliminarHabitacion(int habitacion) {
        try {
            String sql = "DELETE FROM habitacion "
                    + "WHERE idHabitacion = ?;";
            //Preparar la conexión con la query
            PreparedStatement ps = con.prepareStatement(sql);
            //Modificar la query con los parametros recibidos
            ps.setInt(1, habitacion);
            //Crear variable de control de actualización
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Habitación eliminada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No fue posible eliminar la Habitación.");
            }
            //Cerrar el statment
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Habitacion: " + e.getMessage());
        }
    }

    // Acceso a datos de Huesped
    public List<Huesped> listarHuespedes() {
        List<Huesped> huespedes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM huesped;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            // Recuperar huespedes de la BD
            while (rs.next()) {
                Huesped huesped = new Huesped();
                huesped.setIdHuesped(rs.getInt("idHuesped"));
                huesped.setNombre(rs.getString("nombre"));
                huesped.setApellido(rs.getString("apellido"));
                huesped.setDni(rs.getString("dni"));
                huesped.setTelefono(rs.getString("telefono"));
                huesped.setEmail(rs.getString("email"));
                // Agregar huesped
                huespedes.add(huesped);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla TiposHabitacion: " + e.getMessage());
        }
        return huespedes;
    }

    // Acceso a datos de Reserva
    // Acceso a datos de Detalle Reserva
}
