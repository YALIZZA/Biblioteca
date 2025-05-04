import java.util.Scanner;


public class BibliotecaBST {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArbolLibros arbolLibros = new ArbolLibros();
        ArbolUsuarios arbolUsuarios = new ArbolUsuarios();

        arbolLibros.insertar(new Libro("1111", "El hombre mas rico de Babilonia", "George S. Clason"));
        arbolLibros.insertar(new Libro("1112", "los homres son de marthe y las mujeres son de venus", "Jhon Gray"));
        arbolLibros.insertar(new Libro("1113", "El gran libro de la mitología egipcia", " Donna Jo Napoli"));
        arbolLibros.insertar(new Libro("1114", "El sol, el mar y las estrellas", "Lulia Bochis"));

        while (true) {
            System.out.println("\nMENU DE LA BIBLIOTECA");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Prestar libro");
            System.out.println("3. Devolver libro");
            System.out.println("4. Mostrar todos los libros");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Nombre del usuario: ");
                    String nombre = scanner.nextLine();
                    arbolUsuarios.insertar(new Usuario(nombre));
                    System.out.println("Usuario registrado exitosamente.");
                    break;

                case "2":
                    System.out.print("Nombre del usuario: ");
                    nombre = scanner.nextLine();
                    Usuario usuario = arbolUsuarios.buscar(nombre);
                    if (usuario != null) {
                        System.out.print("Título del libro a prestar: ");
                        String titulo = scanner.nextLine();
                        Libro libro = arbolLibros.buscar(titulo);
                        if (libro != null) {
                            if (libro.disponible) {
                                libro.disponible = false;
                                System.out.println("Libro '" + libro.titulo + "' prestado a " + usuario.nombre + ".");
                            } else {
                                System.out.println("El libro ya está prestado.");
                            }
                        } else {
                            System.out.println("Libro no encontrado.");
                        }
                    } else {
                        System.out.println("Usuario no registrado.");
                    }
                    break;

                case "3":
                    System.out.print("Título del libro a devolver: ");
                    String titulo = scanner.nextLine();
                    Libro libro = arbolLibros.buscar(titulo);
                    if (libro != null) {
                        if (!libro.disponible) {
                            libro.disponible = true;
                            System.out.println("Libro devuelto exitosamente.");
                        } else {
                            System.out.println("Este libro no estaba prestado.");
                        }
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;

                case "4":
                    System.out.println("\nListado de libros:");
                    arbolLibros.mostrarInorden();
                    break;

                case "5":
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción inválida. Inténtalo de nuevo.");
            }
        }
    }
}
