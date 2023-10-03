package AccesoDatos;

import Entidades.Huesped;
import java.sql.Connection;

public class HuespedData {

    private Connection con;

    public HuespedData() {
        con = Conexion.getConexion();
    }
    
    public void agregarHuesped(Huesped huesped){
    }
    
    public void eliminarHuesped(Huesped huesped){
    }
    
    public void modificarHuesped(Huesped huesped){
    }
}
