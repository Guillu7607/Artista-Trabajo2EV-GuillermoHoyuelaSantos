import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistaCRUD {
    public void insertar(Artista a) throws SQLException {
        String sql = "INSERT INTO Artista (nombre, generoMusical, paisOrigen) VALUES (?, ?, ?)";
        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getGeneroMusical());
            ps.setString(3, a.getPaisOrigen());
            ps.executeUpdate();
        }
    }

    public List<Artista> listar() throws SQLException {
        List<Artista> lista = new ArrayList<>();
        String sql = "SELECT * FROM Artista";
        try (Connection conn = Conexion.conectar();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Artista(rs.getInt("id"), rs.getString("nombre"),
                        rs.getString("generoMusical"), rs.getString("paisOrigen")));
            }
        }
        return lista;
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM Artista WHERE id = ?";
        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}