package Modelo;

public class Administrador {
    private int id;
    private String nombre;
    private String apellido;
    private String dni;
    private String correo;
    private String usuario;
    private String clave;
    private String estado;
    
    public Administrador() {
    }

    public Administrador(int id, String usuario, String clave, String estado) {
        this.id = id;
        this.usuario = usuario;
        this.clave = clave;
        this.estado = estado;
    }

    public Administrador(String nombre, String apellido, String dni, String correo, String usuario, String clave, String estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.correo = correo;
        this.usuario = usuario;
        this.clave = clave;
        this.estado = estado;
    }

    public Administrador(int id, String nombre, String apellido, String dni, String correo, String usuario, String clave) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.correo = correo;
        this.usuario = usuario;
        this.clave = clave;
    }

    public Administrador(int id, String nombre, String apellido, String dni, String correo, String usuario, String clave, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.correo = correo;
        this.usuario = usuario;
        this.clave = clave;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
