package Modelo;

public class Matricula {
    private int id;
    private int idSede;
    private int idTurno;
    private int idCiclo;
    private int idEst;
    private String fechaRegistro;
    private String fechaExpiracion;
    private String estado;
    
    private String NomSede;
    private String NomTurno;
    private String NomCiclo;
    private double Monto;
    
    public Matricula() {
    }

    public Matricula(int idSede, int idTurno, int idCiclo) {
        this.idSede = idSede;
        this.idTurno = idTurno;
        this.idCiclo = idCiclo;
    }
    
    public Matricula(int idSede, int idTurno, int idCiclo, int idEst) {
        this.idSede = idSede;
        this.idTurno = idTurno;
        this.idCiclo = idCiclo;
        this.idEst = idEst;
    }

    public Matricula(String fechaRegistro, String fechaExpiracion, String NomSede, String NomTurno, String NomCiclo, double Monto) {
        this.fechaRegistro = fechaRegistro;
        this.fechaExpiracion = fechaExpiracion;
        this.NomSede = NomSede;
        this.NomTurno = NomTurno;
        this.NomCiclo = NomCiclo;
        this.Monto = Monto;
    }

    public Matricula(int idSede, int idTurno, int idCiclo, int idEst, String fechaRegistro, String fechaExpiracion) {
        this.idSede = idSede;
        this.idTurno = idTurno;
        this.idCiclo = idCiclo;
        this.idEst = idEst;
        this.fechaRegistro = fechaRegistro;
        this.fechaExpiracion = fechaExpiracion;
    }

    public Matricula(int idSede, int idTurno, int idCiclo, int idEst, String fechaRegistro, String fechaExpiracion, String estado) {
        this.idSede = idSede;
        this.idTurno = idTurno;
        this.idCiclo = idCiclo;
        this.idEst = idEst;
        this.fechaRegistro = fechaRegistro;
        this.fechaExpiracion = fechaExpiracion;
        this.estado = estado;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSede() {
        return idSede;
    }

    public void setIdSede(int idSede) {
        this.idSede = idSede;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public int getIdCiclo() {
        return idCiclo;
    }

    public void setIdEst(int idCiclo) {
        this.idCiclo = idCiclo;
    }

    public int getIdEst() {
        return idEst;
    }

    public void setDniEst(int idEst) {
        this.idEst = idEst;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNomSede() {
        return NomSede;
    }

    public void setNomSede(String NomSede) {
        this.NomSede = NomSede;
    }

    public String getNomTurno() {
        return NomTurno;
    }

    public void setNomTurno(String NomTurno) {
        this.NomTurno = NomTurno;
    }

    public String getNomCiclo() {
        return NomCiclo;
    }

    public void setNomCiclo(String NomCiclo) {
        this.NomCiclo = NomCiclo;
    }

    public double getMonto() {
        return Monto;
    }

    public void setMonto(double Monto) {
        this.Monto = Monto;
    }
    
    
}
