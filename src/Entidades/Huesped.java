
package Entidades;


public class Huesped {
    private int idHuesped;
    private String nombre;
    private String apellido;
    private int documento;
    private String domicilio;
    private String correo;
    private int telefono;

    public Huesped(int idHuesped, String nombre, String apellido, int documento, String domicilio, String correo, int telefono) {
        this.idHuesped = idHuesped;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.domicilio = domicilio;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Huesped(String nombre, String apellido, int documento, String domicilio, String correo, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.domicilio = domicilio;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Huesped() {
    }

    public int getIdHuesped() {
        return idHuesped;
    }

    public void setIdHuesped(int idHuesped) {
        this.idHuesped = idHuesped;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Huesped{" + "idHuesped=" + idHuesped + ", nombre=" + nombre + ", apellido=" + apellido + ", documento=" + documento + ", domicilio=" + domicilio + ", correo=" + correo + ", telefono=" + telefono + '}';
    }
    
        
    
}
