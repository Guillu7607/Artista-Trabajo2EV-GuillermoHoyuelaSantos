import java.util.Scanner;

public class Main {
    private static ArtistaCRUD artistaCRUD = new ArtistaCRUD();
    private static ConciertoCRUD conciertoCRUD = new ConciertoCRUD();
    private static EntradaCRUD entradaCRUD = new EntradaCRUD();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = -1;
        while (opcion != 0) {
            try {
                System.out.println("\n--- SISTEMA DE GESTIÓN DE EVENTOS MUSICALES ---");
                System.out.println("1. Añadir Artista");
                System.out.println("2. Listar Artistas");
                System.out.println("3. Eliminar Artista");
                System.out.println("---------------------------");
                System.out.println("4. Añadir Concierto");
                System.out.println("5. Listar Conciertos");
                System.out.println("---------------------------");
                System.out.println("6. Registrar Venta de Entrada");
                System.out.println("7. Listar Ventas");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");

                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1 -> añadirArtista();
                    case 2 -> listarArtistas();
                    case 3 -> eliminarArtista();
                    case 4 -> añadirConcierto();
                    case 5 -> listarConciertos();
                    case 6 -> registrarVenta();
                    case 7 -> listarVentas();
                    case 0 -> System.out.println("Cerrando programa");
                    default -> System.out.println("Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Error: Número inválido.");
            } catch (Exception e) {
                System.err.println("Error en la operación: " + e.getMessage());
            }
        }
    }

    private static void añadirArtista() throws Exception {
        System.out.print("Nombre del artista: "); String n = sc.nextLine();
        System.out.print("Género musical: "); String g = sc.nextLine();
        System.out.print("País de origen: "); String p = sc.nextLine();
        artistaCRUD.insertar(new Artista(0, n, g, p));
        System.out.println("Artista guardado correctamente.");
    }

    private static void listarArtistas() throws Exception {
        System.out.println("\n--- LISTA DE ARTISTAS ---");
        artistaCRUD.listar().forEach(System.out::println);
    }

    private static void eliminarArtista() throws Exception {
        System.out.print("ID del artista a eliminar: ");
        int id = Integer.parseInt(sc.nextLine());
        artistaCRUD.eliminar(id);
        System.out.println("Artista eliminado con éxito.");
    }

    private static void añadirConcierto() throws Exception {
        System.out.print("ID del Artista : ");
        int idArt = Integer.parseInt(sc.nextLine());
        System.out.print("Fecha : ");
        String fecha = sc.nextLine();
        System.out.print("Lugar: ");
        String lugar = sc.nextLine();
        System.out.print("Precio de la entrada: ");
        double precio = Double.parseDouble(sc.nextLine());

        conciertoCRUD.insertar(new Concierto(0, idArt, fecha, lugar, precio));
        System.out.println("Concierto creado con éxito.");
    }

    private static void listarConciertos() throws Exception {
        System.out.println("\n--- PRÓXIMOS CONCIERTOS ---");
        conciertoCRUD.listar().forEach(System.out::println);
    }

    private static void registrarVenta() throws Exception {
        System.out.print("ID del Concierto: ");
        int idConc = Integer.parseInt(sc.nextLine());
        System.out.print("Nombre del Comprador: ");
        String comprador = sc.nextLine();
        System.out.print("Cantidad de entradas: ");
        int cant = Integer.parseInt(sc.nextLine());
        System.out.print("Fecha de compra (Hoy): ");
        String fecha = sc.nextLine();

        entradaCRUD.registrarVenta(new Entrada(0, idConc, comprador, cant, fecha));
        System.out.println("Venta registrada con éxito.");
    }

    private static void listarVentas() throws Exception {
        System.out.println("\n--- HISTORIAL DE VENTAS ---");
        entradaCRUD.listar().forEach(System.out::println);
    }
}