package GestionBiciShare;

import ClasesBiciShare.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("unused")
public class ControlBicishare {
    private ArrayList<Bicicleta> bicicletas = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Prestamo> prestamos = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new ControlBicishare().run();

    }

    private void run() {
        int opcion;

        do {
            System.out.println("\n  BiciShare");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Registrar bicicleta");
            System.out.println("3. Listar usuarios");
            System.out.println("4. Listar bicicletas (todas)");
            System.out.println("5. Listar bicicletas disponibles");
            System.out.println("6. Prestar bicicleta");
            System.out.println("7. Devolver bicicleta");
            System.out.println("8. Mostrar historial de préstamos");
            System.out.println("9. Salir");
            System.out.println("Elija una opcion ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    registrarUsuario();
                    break;
                case 2:
                    registrarBicicleta();
                    break;
                case 3:
                    listarUsuarios();
                    break;
                case 4:
                    listarBicicletas();
                    break;
                case 5:
                    listarDisponibles();
                    break;
                case 6:
                    prestarBicicleta();
                    break;
                case 7:
                    devolverBicicleta();
                    break;
                case 8:
                    mostrarHistorial();
                    break;
                case 9:
                    salir();
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 9);

    }

    public void registrarUsuario() {
        System.out.println("Registro de usuario");
        System.out.println("ingrese su ID");
        int id = sc.nextInt();
        System.out.println("ingrese su Nombre Completo");
        String nombre = sc.nextLine();
        System.out.println("Tipo (Estudiante/Profesor)");
        String tipo = sc.nextLine();

        Usuario usuarioNuevo = new Usuario(nombre, id, tipo);
        usuarios.add(usuarioNuevo);

        System.out.println(id);

    }

    @SuppressWarnings("unused")
    public void registrarBicicleta() {
        System.out.println("registrar Bicicleta");
        System.out.println("Ingrese el ID de la bicicleta:");
    int id = sc.nextInt();
    sc.nextLine(); 
    System.out.println("Ingrese el modelo de la bicicleta:");
    String modelo = sc.nextLine();
    System.out.println("Estado (Disponible/No disponible):");
    String estado = sc.nextLine();

   
    boolean estadoDisponible = estado.equalsIgnoreCase("Disponible");
    Bicicleta nuevaBici;
    

nuevaBici = new Bicicleta(id, modelo, estado);
bicicletas.add(nuevaBici);

System.out.println("Bicicleta registrada correctamente.");
}

    public void listarUsuarios() {
        return;
    }

    public void listarBicicletas() {
        return;
    }

    public void listarDisponibles() {
        return;
    }

    public void prestarBicicleta() {
        return;
    }

    public void devolverBicicleta() {
        return;
    }

    public void mostrarHistorial() {
        return;
    }

    public void salir() {
        System.out.println("¡Hasta luego!");
        return;
    }
}
