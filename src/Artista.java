public class Artista {
    private int id;
    private String nombre;
    private String generoMusical;
    private String paisOrigen;

    public Artista(int id, String nombre, String generoMusical, String paisOrigen) {
        this.id = id;
        this.nombre = nombre;
        this.generoMusical = generoMusical;
        this.paisOrigen = paisOrigen;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public String getGeneroMusical() { return generoMusical; }
    public String getPaisOrigen() { return paisOrigen; }

    @Override
    public String toString() {
        return String.format("ID: %d | Nombre: %s | Género: %s | País: %s", id, nombre, generoMusical, paisOrigen);
    }
}