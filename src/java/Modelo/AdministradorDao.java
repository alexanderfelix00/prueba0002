package Modelo;

import static Conexion.CConexion.getConnection;
import java.sql.*;
import java.util.ArrayList;

public class AdministradorDao {

    public int ObtenerNumFilas() {
        Administrador oAdm = new Administrador();
        String sql = "SELECT COUNT(IDMATRICULA) AS FILAS FROM MATRICULA";
        int filas = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                filas = rs.getInt("FILAS");
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filas;
    }
    
    public Administrador ValidarUsuario(String usu_email) {
        
        Administrador oAdm = new Administrador();
        String sql = "SELECT * FROM ADMINISTRADOR WHERE USUARIO = ?";
        
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usu_email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                oAdm = new Administrador(
                        rs.getInt("IDADMIN"),
                        rs.getString("USUARIO"),
                        rs.getString("CLAVE"),
                        rs.getString("ESTADO"));
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return oAdm;
    }
    public ArrayList<Informe> InformeDeMatriculados(){
        ArrayList<Informe> listado = new ArrayList<>();
        Informe obj = new Informe();
        
        String sql = "SELECT E.DNI, E.NOMBRES , E.APELLIDOS ,S.NOMBRE AS SEDE, C.NOMBRE AS CICLO, T.NOMBRE AS TURNO, \n" +
                    "C.PRECIO AS MONTO, M.FECHA_REGISTRO, M.FECHA_EXPIRACION FROM MATRICULA M \n" +
                    "INNER JOIN SEDE S ON S.IDSEDE = M.IDSEDE\n" +
                    "INNER JOIN CICLO C ON C.IDCICLO = M.IDCICLO\n" +
                    "INNER JOIN TURNO T ON T.IDTURNO = M.IDTURNO\n" +
                    "INNER JOIN ESTUDIANTE E ON E.IDEST = M.IDEST;";
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                obj = new Informe(
                        rs.getString("DNI"),
                        rs.getString("NOMBRES"),
                        rs.getString("APELLIDOS"),
                        rs.getString("SEDE"),
                        rs.getString("CICLO"),
                        rs.getString("TURNO"),
                        rs.getDouble("MONTO"),
                        rs.getString("FECHA_REGISTRO"),
                        rs.getString("FECHA_EXPIRACION"));
                
                listado.add(obj);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listado;
    }
    public Administrador ListarDatosPorId(int idAdm) {
        Administrador oAd = new Administrador();
        String sql = "SELECT * FROM ADMINISTRADOR WHERE IDADMIN = ?";
        
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAdm);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                oAd = new Administrador(
                        rs.getInt("IDADMIN"),
                        rs.getString("NOMRBRES"),
                        rs.getString("APELLIDOS"),
                        rs.getString("DNI"),
                        rs.getString("CORREO"),
                        rs.getString("USUARIO"),
                        rs.getString("CLAVE"),
                        rs.getString("ESTADO"));
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return oAd;
    }

}
