
package AccesoDatos;

import Entidades.Huesped;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class HuespedData {
    private Connection con;

    public HuespedData() {
        con = Conexion.getConexion();
    }
    
    public void insertarHuesped(Huesped huesped) { // metodo para cargar huespedes
        String SQL = "INSERT INTO huesped (nombre, apellido, documento, domicilio, correo,  telefono) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, huesped.getNombre());
            ps.setString(2, huesped.getApellido());
            ps.setInt(3, huesped.getDocumento());
            ps.setString(4, huesped.getDomicilio());
            ps.setString(5, huesped.getCorreo());
            ps.setInt(6, huesped.getTelefono());

            int registro = ps.executeUpdate();
            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "huesped registrado");
            }
            ps.close();
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "Ya existe un huésped con el mismo número de documento.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos: " + ex.getMessage());
        }
    }
    
    public void actualizarHuesped(Huesped huesped){
        String SQL = "UPDATE huesped SET  nombre = ?, apellido  = ?, documento = ?, domicilio = ?, correo = ?, telefono = ? WHERE idHuesped = ? ";
        
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, huesped.getNombre());
            ps.setString(2, huesped.getApellido());
            ps.setInt(3, huesped.getDocumento());
            ps.setString(4, huesped.getDomicilio());
            ps.setString(5, huesped.getCorreo());
            ps.setInt(6, huesped.getTelefono());
            ps.setInt(7, huesped.getIdHuesped());
            int registro = ps.executeUpdate();
            if(registro > 0){
               JOptionPane.showMessageDialog(null, "huesped modificado"); 
            }else{
                JOptionPane.showMessageDialog(null, "el huesped no existe"); 
            }
            ps.close();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "error al conectar a la base de datos");
        }
    }
    
    public void eliminarHuesped(int id){
        String Sql = "DELETE FROM huesped WHERE idHuesped = ?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(Sql);
            ps.setInt(1, id);
            int registro = ps.executeUpdate();
            if(registro >0){
                JOptionPane.showMessageDialog(null, "el huesped ha sido eliminado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al conectar a la base de datos");
        }
    }
    
    public List<Huesped> consultaHuesped(){
        List<Huesped> huespedes = new ArrayList<>();
        String SQL = "SELECT * FROM huesped ";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Huesped huesped = new Huesped();
                huesped.setApellido(rs.getString("apellido"));
                huesped.setNombre(rs.getString("nombre"));
                huesped.setDocumento(rs.getInt("documento"));
                huesped.setDomicilio(rs.getString("domicilio"));
                huesped.setCorreo(rs.getString("correo"));
                huesped.setTelefono(rs.getInt("telefono"));
                huespedes.add(huesped);
            }
            ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "error al conectar a la base de datos");
        }
        return huespedes;
    }
    
     public Huesped consultaHuesdPorDni(int documento){
        String SQL = "SELECT  FROM huesped WHERE documento = ?";
        Huesped huesped = null; 
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, documento);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                //huesped = new Huesped(); 
                huesped.setApellido(rs.getString("apellido"));
                huesped.setNombre(rs.getString("nombre"));
                huesped.setDocumento(rs.getInt("documento"));
                huesped.setDomicilio(rs.getString("domicilio"));
                huesped.setCorreo(rs.getString("correo"));
                huesped.setTelefono(rs.getInt("telefono"));
            }
            ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "error al conectar a la base de datos");
        }
        return huesped;
    }
}
