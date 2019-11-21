package Modelo;

public class Informe {
    /*
SELECT E.DNI, E.NOMBRES , E.APELLIDOS ,S.NOMBRE AS SEDE, C.NOMBRE AS CICLO, T.NOMBRE AS TURNO, 
C.PRECIO AS MONTO, M.FECHA_REGISTRO, M.FECHA_EXPIRACION ;*/
    
    private String dniE;
    private String nombreE;
    private String apellidoE;
    private String nomSede;
    private String nomCiclo;
    private String nomTurno;   
    private double monto;  
    private String fechaReg;
    private String fechaExp;

    public Informe() {
    }
    
    public Informe(String dniE, String nombreE, String apellidoE, String nomSede, String nomCiclo, String nomTurno, double monto, String fechaReg, String fechaExp) {
        this.dniE = dniE;
        this.nombreE = nombreE;
        this.apellidoE = apellidoE;
        this.nomSede = nomSede;
        this.nomCiclo = nomCiclo;
        this.nomTurno = nomTurno;
        this.monto = monto;
        this.fechaReg = fechaReg;
        this.fechaExp = fechaExp;
    }

    public String getDniE() {
        return dniE;
    }

    public void setDniE(String dniE) {
        this.dniE = dniE;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getApellidoE() {
        return apellidoE;
    }

    public void setApellidoE(String apellidoE) {
        this.apellidoE = apellidoE;
    }

    public String getNomSede() {
        return nomSede;
    }

    public void setNomSede(String nomSede) {
        this.nomSede = nomSede;
    }

    public String getNomCiclo() {
        return nomCiclo;
    }

    public void setNomCiclo(String nomCiclo) {
        this.nomCiclo = nomCiclo;
    }

    public String getNomTurno() {
        return nomTurno;
    }

    public void setNomTurno(String nomTurno) {
        this.nomTurno = nomTurno;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(String fechaReg) {
        this.fechaReg = fechaReg;
    }

    public String getFechaExp() {
        return fechaExp;
    }

    public void setFechaExp(String fechaExp) {
        this.fechaExp = fechaExp;
    }
    
    
}
