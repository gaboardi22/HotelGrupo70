
package AccesoDatos;


import Entidades.Reserva;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
}
