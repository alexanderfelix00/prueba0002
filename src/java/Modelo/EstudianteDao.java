package Modelo;

import static Conexion.CConexion.getConnection;
import java.sql.*;
import java.util.ArrayList;

public class EstudianteDao {
    
    public ArrayList<Estudiante> ListarEstudiantes() {
        
        ArrayList<Estudiante> lista = new ArrayList<>();
        String sql = "SELECT * FROM ESTUDIANTE";
        
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Estudiante oEst = new Estudiante(
                        rs.getInt("IDEST"),
                        rs.getString("DNI"),
                        rs.getString("NOMBRES"),
                        rs.getString("APELLIDOS"),
                        rs.getString("CORREO"),
                        rs.getString("TELEFONO"),
                        rs.getString("ESTADO"));
                
                lista.add(oEst);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public Estudiante ListarEstudiantePorId(int idEst) {
        Estudiante oEst = new Estudiante();
        String sql = "SELECT * FROM ESTUDIANTE WHERE IDEST = ?";
        
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idEst);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                oEst = new Estudiante(
                        rs.getInt("IDEST"),
                        rs.getString("DNI"),
                        rs.getString("NOMBRES"),
                        rs.getString("APELLIDOS"),
                        rs.getString("CORREO"),
                        rs.getString("TELEFONO"),
                        rs.getString("ESTADO"));
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return oEst;
    }
    
    public boolean RegistrarEstudiante(Estudiante oEst) {
        boolean respuesta = false;
        String sql = "INSERT INTO ESTUDIANTE VALUES(?,?,?,?,?,?,?)";
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, null);
            ps.setString(2, oEst.getDni());
            ps.setString(3, oEst.getNombre());
            ps.setString(4, oEst.getApellido());
            ps.setString(5, oEst.getCorreo());
            ps.setString(6, oEst.getTelefono());
            ps.setString(7, "ACTIVO");
            
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

    public boolean ActualizarEstudiante(Estudiante oEst) {
        boolean respuesta = false;
        String sql = "UPDATE ESTUDIANTE SET DNI = ?, NOMBRES = ?, APELLIDOS = ?, CORREO = ?, TELEFONO = ? WHERE IDEST = ?";
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, oEst.getDni());
            ps.setString(2, oEst.getNombre());
            ps.setString(3, oEst.getApellido());
            ps.setString(4, oEst.getCorreo());
            ps.setString(5, oEst.getTelefono());
            ps.setInt(6, oEst.getId());
            
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
    
    public boolean EliminarEstudiante(int idEst) {
        boolean respuesta = false;
        String sql = "DELETE FROM ESTUDIANTE WHERE IDEST = ?";
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, idEst);
            
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
