
package Entidades;


public class Huesped {
    private int idHuesped;
    private String nombre;
    private String apellido;
    private String documento;
    private String domicilio;
    private String correo;
    private String telefono;

    public Huesped() {
    }

    public Huesped(String nombre, String apellido, String documento, String domicilio, String correo, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.domicilio = domicilio;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Huesped(int idHuesped, String nombre, String apellido, String documento, String domicilio, String correo, String telefono) {
        this.idHuesped = idHuesped;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.domicilio = domicilio;
        this.correo = correo;
        this.telefono = telefono;
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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Huesped{" + "idHuesped=" + idHuesped + ", nombre=" + nombre + ", apellido=" + apellido + ", documento=" + documento + ", domicilio=" + domicilio + ", correo=" + correo + ", telefono=" + telefono + '}';
    }

    
}