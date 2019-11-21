package Modelo;

import static Conexion.CConexion.getConnection;
import java.sql.*;
import java.util.ArrayList;

public class CicloDao{
    
    public ArrayList<Ciclo> ListarCiclos() {

        ArrayList<Ciclo> lista = new ArrayList<>();

        String sql = "SELECT * FROM CICLO";

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ciclo oCiclo= new Ciclo(
                        rs.getInt("IDCICLO"),
                        rs.getString("NOMBRE"),
                        rs.getDouble("PRECIO"));

                lista.add(oCiclo);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public double GetMonto(int id) {
        double monto = 0;
        String sql = "SELECT * FROM CICLO WHERE IDCICLO = "+id+"";

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                monto = rs.getDouble("PRECIO");
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return monto;
    }
}
