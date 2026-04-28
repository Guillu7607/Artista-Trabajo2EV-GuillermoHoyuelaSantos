import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EntradaCRUD {
    public void registrarVenta(Entrada e) throws SQLException {
        String sql = "INSERT INTO ENTRADA (CONCIERTO_ID, COMPRADOR, CANTIDAD, FECHACOMPRA) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, e.getConciertoId());
            ps.setString(2, e.getComprador());
            ps.setInt(3, e.getCantidad());
            ps.setString(4, e.getFechaCompra());
            ps.executeUpdate();
        }
    }

    public List<Entrada> listar() throws SQLException {
        List<Entrada> lista = new ArrayList<>();
        String sql = "SELECT * FROM ENTRADA";
        try (Connection conn = Conexion.conectar();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Entrada(rs.getInt("ID"), rs.getInt("CONCIERTO_ID"),
                        rs.getString("COMPRADOR"), rs.getInt("CANTIDAD"), rs.getString("FECHACOMPRA")));
            }
        }
        return lista;
    }
}