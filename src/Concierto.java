public class Concierto {
    private int id;
    private int artistaId; // Guardamos el ID para la FK
    private String fecha;
    private String lugar;
    private double precioEntrada;

    public Concierto(int id, int artistaId, String fecha, String lugar, double precioEntrada) {
        this.id = id;
        this.artistaId = artistaId;
        this.fecha = fecha;
        this.lugar = lugar;
        this.precioEntrada = precioEntrada;
    }

    public int getId() { return id; }
    public int getArtistaId() { return artistaId; }
    public String getFecha() { return fecha; }
    public String getLugar() { return lugar; }
    public double getPrecioEntrada() { return precioEntrada; }

    @Override
    public String toString() {
        return "ID: " + id + " | Artista ID: " + artistaId + " | Fecha: " + fecha + " | Lugar: " + lugar + " | Precio: " + precioEntrada;
    }
}