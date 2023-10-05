
package AccesoDatos;

import Entidades.Habitacion;
import java.sql.Connection;


public class HabitacionData {
    private Connection con;

    public HabitacionData(Connection con) {
        con = Conexion.getConexion();
    }
    
    public void crearHabitacion(Habitacion habitacion){
        String SQL = "INSERT INTO habitacion () VALUES ";
    }
    
}
