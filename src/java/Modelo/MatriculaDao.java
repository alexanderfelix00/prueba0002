package Modelo;

import static Conexion.CConexion.getConnection;
import java.sql.*;
import java.text.SimpleDateFormat;

public class MatriculaDao  {

    public String[] fechas(){
        java.util.Date now = new java.util.Date(System.currentTimeMillis());
        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");

        String fechaActual = date.format(now);
        String[] datos = fechaActual.split("/");
        
        String año = datos[0]; 
        String mes = datos[1]; 
        int dia = Integer.parseInt(datos[2])+2;
        
        String fechaFinal = año+"/"+mes+"/"+dia;
        
        String[] fechas = {fechaActual,fechaFinal};
        
        return fechas;
    }
    
    public int GetIdEst(){
        String sql = "SELECT MAX(IDEST) AS ID FROM ESTUDIANTE";
        int id = 0;
        
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("ID");
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
    
    public Matricula DatosMatriculaPorID(int idMat){
        
        Matricula bean = new Matricula();
        String sql = "SELECT S.NOMBRE AS SEDE, C.NOMBRE AS CICLO, T.NOMBRE AS TURNO, C.PRECIO AS MONTO, \n" +
                    "M.FECHA_REGISTRO, M.FECHA_EXPIRACION FROM MATRICULA M \n" +
                    "INNER JOIN SEDE S ON S.IDSEDE = M.IDSEDE\n" +
                    "INNER JOIN CICLO C ON C.IDCICLO = M.IDCICLO\n" +
                    "INNER JOIN TURNO T ON T.IDTURNO = M.IDTURNO  WHERE M.IDMATRICULA = "+ idMat +"";
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                bean = new Matricula(
                        rs.getString("FECHA_REGISTRO"), 
                        rs.getString("FECHA_EXPIRACION"), 
                        rs.getString("SEDE"), 
                        rs.getString("CICLO"), 
                        rs.getString("TURNO"),
                        rs.getDouble("MONTO"));
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
    
    public boolean RegistrarMatricula(Matricula oMat) {
        boolean respuesta = false;
        String sql = "INSERT INTO MATRICULA VALUES(?,?,?,?,?,?,?,?)";
        String[] fechas = fechas();
        int idEstudiante = GetIdEst();
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, null);
            ps.setInt(2, oMat.getIdSede());
            ps.setInt(3, oMat.getIdTurno());
            ps.setInt(4, oMat.getIdCiclo());
            ps.setInt(5, idEstudiante);
            ps.setString(6, fechas[0]);
            ps.setString(7, fechas[1]);
            ps.setString(8, "EMITIDO");

            int filas = ps.executeUpdate();

            if (filas == 1) {
                respuesta = true;
            } else {
                respuesta = false;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return respuesta;
    }

    public boolean ActualizarMatricula(Matricula oMat) {
        boolean respuesta = false;
        String sql = "UPDATE MATRICULA SET IDSEDE = ?, IDTURNO = ?, IDCICLO = ? WHERE IDMATRICULA = ?";
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, oMat.getIdSede());
            ps.setInt(2, oMat.getIdTurno());
            ps.setInt(3, oMat.getIdCiclo());
            ps.setInt(4, oMat.getId());
            
            int filas = ps.executeUpdate();
            
            if (filas == 1) {
                respuesta = true;
            } else {
                respuesta = false;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return respuesta;
    }
    
    public boolean AnularMatricula(Matricula oMat) {
        boolean respuesta = false;
        String sql = "UPDATE MATRICULA SET ESTADO = ? WHERE IDMATRICULA = ?";
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, oMat.getEstado());
            ps.setInt(2, oMat.getId());

            int filas = ps.executeUpdate();

            if (filas == 1) {
                respuesta = true;
            } else {
                respuesta = false;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return respuesta;
    }

}
