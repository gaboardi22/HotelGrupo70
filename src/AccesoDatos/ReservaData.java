
package AccesoDatos;


import Entidades.Habitacion;
import Entidades.Huesped;
import Entidades.Reserva;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ReservaData {
    private Connection con;

    public ReservaData() {
        con = Conexion.getConexion();
    }
    
    public void insertarReserva(Reserva reserva){
        String SQL = "INSERT INTO reserva (idHuesped, fechaChekIn, fechaCheckOut, cantidadDeDias, estado, montoAPagar, cantidadDePersonas)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps =con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, reserva.getHuesped().getIdHuesped());
            ps.setDate(2, Date.valueOf(reserva.getFechaCheckIn()));
            ps.setDate(3, Date.valueOf(reserva.getFechaCheckOut()));
            ps.setInt(4, reserva.getCantidadDeDias());
            ps.setBoolean(5, true);
            ps.setDouble(6, reserva.getMontoAPagar());
            ps.setInt(7, reserva.getCantidadDePersonas());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                reserva.setIdReserva(rs.getInt("idReserva"));
                JOptionPane.showMessageDialog(null, "Reserva generada con exito");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al conectarse a la BDD");
        }
    }
    
   public void actualizarReserva(Reserva reserva){
       String SQL = "UPDATE rserva SET idHuesped = ?, fechaCheckIn = ?, fechaCheckOut = ?, cantidadDias = ?, estado = ?, montoAPagar = ?, cantidadPersonas = ?";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1,reserva.getHuesped().getIdHuesped());
            ps.setDate(2, Date.valueOf(reserva.getFechaCheckIn()));
            ps.setDate(3, Date.valueOf(reserva.getFechaCheckOut()));
            ps.setInt(4, reserva.getCantidadDeDias());
            ps.setBoolean(5, reserva.isEstado());
            ps.setDouble(6, reserva.getMontoAPagar());
            ps.setInt(7, reserva.getCantidadDePersonas());
            int registro = ps.executeUpdate();
            if(registro >0){
                JOptionPane.showMessageDialog(null, "reserva modificada con exito");
            }else{
                JOptionPane.showMessageDialog(null, "no se pudo modificar la reserva");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al conectarse a la BDD");
        }
       
   }
   
   public void eliminarReserva(int id){
       String SQL = "DELETE FROM reserva where idReserva = ?";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            int registro = ps.executeUpdate();
            if(registro >0){
                JOptionPane.showMessageDialog(null, "la reserva ha sido eliminada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al conectarse a la BDD");
        }
   }
   
    public List<Reserva> listarReservas() {
        List<Reserva> reservas = new ArrayList<>();
        String SQL = "SELECT * FROM reserva, huesped WHERE reserva.idHuesped = huesped.idHuesped";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Reserva reserva = new Reserva();
                Huesped huesped = new Huesped();

                reserva.setIdReserva(rs.getInt("idReserva"));
                reserva.setFechaCheckIn(rs.getDate("fechaCheckIn").toLocalDate());
                reserva.setFechaCheckOut(rs.getDate("fechaCheckOut").toLocalDate());
                reserva.setCantidadDeDias(rs.getInt("cantidadDias"));
                reserva.setCantidadDePersonas(rs.getInt("cantidadPersonas"));
                reserva.setEstado(rs.getBoolean("estado"));
                reserva.setMontoAPagar(rs.getDouble("montoAPagar"));

                huesped.setIdHuesped(rs.getInt("idHuesped"));
                huesped.setApellido(rs.getString("apellido"));
                huesped.setNombre(rs.getString("nombre"));
                huesped.setDocumento(rs.getInt("documento"));
                huesped.setCorreo(rs.getString("correo"));
                huesped.setTelefono(rs.getInt("telefono"));

                reserva.setHuesped(huesped); // agrega el huesped a la tabla reserva
                reservas.add(reserva); //arega la reserva a la lista reservas
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al conectarse a la BDD");
        }
        return reservas;
    }
}
