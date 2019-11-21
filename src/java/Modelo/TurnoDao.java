package Modelo;

import static Conexion.CConexion.getConnection;
import java.sql.*;
import java.util.ArrayList;

public class TurnoDao  {

    public ArrayList<Turno> ListarTurnos() {

        ArrayList<Turno> lista = new ArrayList<>();

        String sql = "SELECT * FROM TURNO";

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Turno oTurno = new Turno(
                        rs.getInt("IDTURNO"),
                        rs.getString("NOMBRE"),
                        rs.getString("HORA_INICIO"),
                        rs.getString("HORA_FINAL"));

                lista.add(oTurno);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

}
