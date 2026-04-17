import java.util.Scanner;

public class Main {
    private static ArtistaCRUD artistaCRUD = new ArtistaCRUD();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = -1;
        while (opcion != 0) {
            try {
                System.out.println("\n--- GESTIÓN DE CONCIERTOS ---");
                System.out.println("1. Añadir Artista");
                System.out.println("2. Listar Artistas");
                System.out.println("3. Eliminar Artista");
                System.out.println("0. Salir");
                System.out.print("Seleccione: ");
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1 -> añadirArtista();
                    case 2 -> listarArtistas();
                    case 3 -> eliminarArtista();
                    case 0 -> System.out.println("Saliendo...");
                }
            } catch (NumberFormatException e) {
                System.err.println("Error: Por favor, introduce un número válido.");
            } catch (Exception e) {
                System.err.println("Error inesperado: " + e.getMessage());
            }
        }
    }

    private static void añadirArtista() throws Exception {
        System.out.print("Nombre: "); String n = sc.nextLine();
        System.out.print("Género: "); String g = sc.nextLine();
        System.out.print("País: "); String p = sc.nextLine();
        artistaCRUD.insertar(new Artista(0, n, g, p));
        System.out.println("Artista añadido con éxito.");
    }

    private static void listarArtistas() throws Exception {
        artistaCRUD.listar().forEach(System.out::println);
    }

    private static void eliminarArtista() throws Exception {
        System.out.print("ID del artista a eliminar: ");
        int id = Integer.parseInt(sc.nextLine());
        artistaCRUD.eliminar(id);
        System.out.println("Artista eliminado.");
    }
}