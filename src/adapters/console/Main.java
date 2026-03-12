package adapters.console;

import java.util.List;
import java.util.Scanner;
import entities.Material;
import entities.Prestamo;
import entities.Usuario;
import infrastructure.repositories.InMemoryMaterialRepository;
import infrastructure.repositories.InMemoryPrestamoRepository;
import infrastructure.repositories.InMemoryUsuarioRepository;
import infrastructure.services.SimpleIdGenerator;
import usecases.dto.OperationResult;
import usecases.services.BibliotecaApp;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BibliotecaApp biblioteca = new BibliotecaApp(
                "Biblioteca Central",
                new InMemoryMaterialRepository(),
                new InMemoryUsuarioRepository(),
                new InMemoryPrestamoRepository(),
                new SimpleIdGenerator()
        );

        cargarDatosSemilla(biblioteca);

        int op;
        do {
            System.out.println("\n=== " + biblioteca.getNombre() + " ===");
            System.out.println("1) Listar materiales");
            System.out.println("2) Listar usuarios");
            System.out.println("3) Prestar material");
            System.out.println("4) Devolver material");
            System.out.println("5) Listar préstamos");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            op = leerEntero(sc);

            switch (op) {
                case 1 -> imprimirLista("Materiales", biblioteca.listarMateriales());
                case 2 -> imprimirLista("Usuarios", biblioteca.listarUsuarios());
                case 3 -> {
                    System.out.print("ID Usuario: ");
                    String idU = sc.nextLine();
                    System.out.print("ID Material: ");
                    String idM = sc.nextLine();
                    System.out.print("Días de préstamo: ");
                    int dias = leerEntero(sc);
                    OperationResult resultado = biblioteca.prestar(idU, idM, dias);
                    System.out.println(resultado.getMessage());
                }
                case 4 -> {
                    System.out.print("ID Préstamo: ");
                    String idP = sc.nextLine();
                    OperationResult resultado = biblioteca.devolver(idP);
                    System.out.println(resultado.getMessage());
                }
                case 5 -> imprimirLista("Préstamos", biblioteca.listarPrestamos());
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (op != 0);

        sc.close();
    }

    private static void cargarDatosSemilla(BibliotecaApp biblioteca) {
        biblioteca.registrarUsuario("Ana");
        biblioteca.registrarUsuario("Luis");
        biblioteca.registrarLibro("Cálculo I", "Stewart", 500);
        biblioteca.registrarRevista("Electrónica Hoy", 42);
    }

    private static int leerEntero(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un número válido: ");
            }
        }
    }

    private static <T> void imprimirLista(String titulo, List<T> elementos) {
        if (elementos.isEmpty()) {
            System.out.println("No hay " + titulo.toLowerCase() + ".");
            return;
        }
        System.out.println("\n--- " + titulo + " ---");
        for (T elemento : elementos) {
            System.out.println(elemento);
        }
    }
}
