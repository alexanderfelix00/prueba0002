package Modelo;

public class Turno {
    private int id;
    private String nombre;
    private String hora_inicio;
    private String hora_fin;

    public Turno() {
    }

    public Turno(String nombre, String hora_inicio, String hora_fin) {
        this.nombre = nombre;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
    }

    public Turno(int id, String nombre, String hora_inicio, String hora_fin) {
        this.id = id;
        this.nombre = nombre;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
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

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }
    
    
}
