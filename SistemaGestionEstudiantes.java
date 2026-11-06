import java.util.ArrayList;
import java.util.Scanner;

class Estudiante {

    private int id;
    private String nombre;
    private int edad;

    public Estudiante(int id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}

public class SistemaGestionEstudiantes {

    static ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    static int totalEstudiantes = 0;

    public static void main(String[] args) {

        boolean banderaSalir = false;

        while (!banderaSalir) {

            mostrarMenu();

            try {

                int opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {

                    case 1:
                        agregarEstudiante();
                        break;

                    case 2:
                        mostrarEstudiantes();
                        break;

                    case 3:
                        buscarEstudiantePorId();
                        break;

                    case 4:
                        banderaSalir = true;
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opción inválida.");
                }

            } catch (Exception e) {

                System.out.println("Debe ingresar un número válido.");
            }
        }

        scanner.close();
    }

    public static void mostrarMenu() {

        System.out.println("\n===== SISTEMA DE GESTIÓN DE ESTUDIANTES =====");
        System.out.println("1. Agregar estudiante");
        System.out.println("2. Mostrar estudiantes");
        System.out.println("3. Buscar estudiante por ID");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static void agregarEstudiante() {

        try {

            System.out.print("Ingrese ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Ingrese Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese Edad: ");
            int edad = Integer.parseInt(scanner.nextLine());

            Estudiante estudiante =
                    new Estudiante(id, nombre, edad);

            listaEstudiantes.add(estudiante);

            totalEstudiantes++;

            System.out.println("Estudiante agregado correctamente");
            System.out.println("Total estudiantes: "
                    + totalEstudiantes);

        } catch (Exception e) {

            System.out.println("Error en los datos ingresados.");
        }
    }

    public static void mostrarEstudiante(Estudiante estudiante) {

        System.out.println("------------------------");
        System.out.println("ID: " + estudiante.getId());
        System.out.println("Nombre: " + estudiante.getNombre());
        System.out.println("Edad: " + estudiante.getEdad());
    }

    public static void mostrarEstudiantes() {

        if (listaEstudiantes.isEmpty()) {

            System.out.println("No hay estudiantes registrados.");
            return;
        }

        for (Estudiante estudiante : listaEstudiantes) {

            mostrarEstudiante(estudiante);
        }
    }

    public static void buscarEstudiantePorId() {

        try {

            System.out.print("Ingrese el ID: ");

            int idBuscar =
                    Integer.parseInt(scanner.nextLine());

            boolean encontrado = false;

            for (Estudiante estudiante : listaEstudiantes) {

                if (estudiante.getId() == idBuscar) {

                    mostrarEstudiante(estudiante);

                    encontrado = true;

                    break;
                }
            }

            if (!encontrado) {

                System.out.println("Estudiante no encontrado.");
            }

        } catch (Exception e) {

            System.out.println("ID inválido.");
        }
    }
}
