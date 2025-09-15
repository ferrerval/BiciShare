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

        int id;
        while (true) {
            System.out.print("Ingrese su ID (máx. 10 dígitos): ");

            while (!sc.hasNextInt()) {
                System.out.println("  Solo se permiten números. Intente de nuevo.");
                sc.next();
            }

            id = sc.nextInt();
            sc.nextLine();

            if (String.valueOf(id).length() > 10) {
                System.out.println("  El ID no puede tener más de 10 dígitos. Intente de nuevo.");
                continue;
            }

            boolean repetido = false;
            for (Usuario u : usuarios) {
                if (u.getId() == id) {
                    repetido = true;
                    break;
                }
            }

            if (repetido) {
                System.out.println("  Ya existe un usuario con ese ID. Intente con otro.");
            } else {
                break;
            }
        }

        String nombre;
        while (true) {
            System.out.print("Ingrese su Nombre Completo: ");
            nombre = sc.nextLine().trim();
            if (!nombre.isEmpty()) {
                break;
            }
            System.out.println("  El nombre no puede estar vacío. Intente de nuevo.");
        }

        String tipo;
        while (true) {
            System.out.print("Tipo (Estudiante/Profesor): ");
            tipo = sc.nextLine().trim();
            if (tipo.equalsIgnoreCase("Estudiante") || tipo.equalsIgnoreCase("Profesor")) {
                break;
            }
            System.out.println("  Solo se permite 'Estudiante' o 'Profesor'. Intente de nuevo.");
        }

        Usuario nuevoUsuario = new Usuario(nombre, id, tipo);
        usuarios.add(nuevoUsuario);
        System.out.println(" Usuario registrado correctamente.");

    }

    public void registrarBicicleta() {
        System.out.println("Registrar Bicicleta");

        int id;
        while (true) {
            System.out.print("Ingrese el ID de la bicicleta (máx. 5 dígitos): ");

            while (!sc.hasNextInt()) {
                System.out.println(" Solo se permiten números. Intente de nuevo.");
                sc.next();
            }

            id = sc.nextInt();
            sc.nextLine();

            if (String.valueOf(id).length() > 5) {
                System.out.println(" El ID no puede tener más de 5 dígitos. Intente de nuevo.");
                continue;
            }

            boolean repetido = false;
            for (Bicicleta b : bicicletas) {
                if (b.getId() == id) {
                    repetido = true;
                    break;
                }
            }

            if (repetido) {
                System.out.println(" Ya existe una bicicleta con ese ID. Intente con otro.");
            } else {
                break;
            }
        }

        String modelo;
        while (true) {
            System.out.print("Modelo (Mecanica/Electrica): ");
            modelo = sc.nextLine().trim();
            if (modelo.equalsIgnoreCase("Mecanica") || modelo.equalsIgnoreCase("Electrica")) {
                break;
            }
            System.out.println(" Solo se permite 'Mecanica' o 'Electrica'. Intente de nuevo.");
        }

        String estado;
        while (true) {
            System.out.print("Estado (Disponible/No disponible): ");
            estado = sc.nextLine().trim();
            if (estado.equalsIgnoreCase("Disponible") || estado.equalsIgnoreCase("No disponible")) {
                break;
            }
            System.out.println(" Solo se permite 'Disponible' o 'No disponible'. Intente de nuevo.");
        }

        if (modelo.equalsIgnoreCase("Mecanica")) {
            bicicletas.add(new Mecanica(id, estado));
            System.out.println(" Bicicleta mecánica registrada.");
        } else { // Electrica
            int nivel;
            while (true) {
                System.out.print("Nivel de batería (0-100): ");

                while (!sc.hasNextInt()) {
                    System.out.println("  Debe ingresar un número entero entre 0 y 100.");
                    sc.next();
                }

                nivel = sc.nextInt();
                sc.nextLine();

                if (nivel < 0 || nivel > 100) {
                    System.out.println("  El nivel de batería debe estar entre 0 y 100. Intente de nuevo.");
                } else {
                    break;
                }
            }

            Electrica nuevaBici = new Electrica(id, modelo, nivel);
            bicicletas.add(nuevaBici);
            System.out.println(" Bicicleta eléctrica registrada.");
        }

    }

    public void listarUsuarios() {
        System.out.println("\n Listado de usuarios");
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario p = usuarios.get(i);
            System.out.println(
                    p.getId() + " - " + p.getNombre() + " - " + p.getTipoUsuario());
        }

    }

    public void listarBicicletas() {
        System.out.println("\nListado de bicicletas:");
        for (int i = 0; i < bicicletas.size(); i++) {
            Bicicleta b = bicicletas.get(i);

            if (b instanceof Electrica) {
                Electrica e = (Electrica) b;
                System.out.println(
                        e.getId() + " - " + e.getTipo() + " - " + e.getEstadoTexto() + " - " + e.getNivelBateria()
                                + "%");

            } else if (b instanceof Mecanica) {
                Mecanica m = (Mecanica) b;
                System.out.println(
                        m.getId() + " - " + m.getTipo() + "-" + m.getEstadoTexto());
            }

        }

    }

    public void listarDisponibles() {
        System.out.println("\nListado de bicicletas disponibles");

        boolean hayDisponibles = false;

        for (int i = 0; i < bicicletas.size(); i++) {
            Bicicleta b = bicicletas.get(i);

            if (b.getEstado()) {
                hayDisponibles = true;

                if (b instanceof Electrica) {
                    Electrica e = (Electrica) b;
                    System.out.println(
                            e.getId() + " - " + e.getTipo() + " - : " + e.getEstadoTexto() + " - " + e.getNivelBateria()
                                    + "%");
                } else if (b instanceof Mecanica) {
                    Mecanica m = (Mecanica) b;
                    System.out.println(
                            m.getId() + " - " + m.getTipo() + " - " + m.getEstadoTexto());
                }
            }
        }

        if (!hayDisponibles) {
            System.out.println("No hay bicicletas disponibles en este momento.");
        }
    }

    public void prestarBicicleta() {
        System.out.println("Prestamo de bicicleta");

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