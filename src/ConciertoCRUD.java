import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConciertoCRUD {
    public void insertar(Concierto c) throws SQLException {
        String sql = "INSERT INTO CONCIERTO (ARTISTA_ID, FECHA, LUGAR, PRECIOENTRADA) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, c.getArtistaId());
            ps.setString(2, c.getFecha());
            ps.setString(3, c.getLugar());
            ps.setDouble(4, c.getPrecioEntrada());
            ps.executeUpdate();
        }
    }

    public List<Concierto> listar() throws SQLException {
        List<Concierto> lista = new ArrayList<>();
        String sql = "SELECT * FROM CONCIERTO";
        try (Connection conn = Conexion.conectar();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Concierto(rs.getInt("ID"), rs.getInt("ARTISTA_ID"),
                        rs.getString("FECHA"), rs.getString("LUGAR"), rs.getDouble("PRECIOENTRADA")));
            }
        }
        return lista;
    }
}

