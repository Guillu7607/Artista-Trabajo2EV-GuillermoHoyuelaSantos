public class Entrada {
    private int id;
    private int conciertoId;
    private String comprador;
    private int cantidad;
    private String fechaCompra;

    public Entrada(int id, int conciertoId, String comprador, int cantidad, String fechaCompra) {
        this.id = id;
        this.conciertoId = conciertoId;
        this.comprador = comprador;
        this.cantidad = cantidad;
        this.fechaCompra = fechaCompra;
    }
    public int getConciertoId() { return conciertoId; }
    public String getComprador() { return comprador; }
    public int getCantidad() { return cantidad; }
    public String getFechaCompra() { return fechaCompra; }

    @Override
    public String toString() {
        return "Ticket ID: " + id + " | Concierto ID: " + conciertoId + " | Comprador: " + comprador + " | Cantidad: " + cantidad;
    }
}