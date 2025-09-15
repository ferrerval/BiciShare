package GestionBiciShare;

import ClasesBiciShare.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlBicishare {
    // Listas principales que usamos en el programa
    private ArrayList<Bicicleta> bicicletas = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Prestamo> prestamos = new ArrayList<>();
    // Scanner para leer la información que los usuarios escriben en consola
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new ControlBicishare().run();

    }

    /**
     * run()
     * 
     * Muestra el menú principal en un ciclo.
     * Cada número del menú llama a la función correspondiente.
     * El ciclo termina cuando el usuario elige salir.
     */
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
            System.out.println("8. Recargar bicicleta");
            System.out.println("9. Mostrar HIstorial de prestamos");
            System.out.println("10. Salir");
            System.out.println("Elija una opcion ");

            // Leemos la opción que ingresa el usuario
            opcion = sc.nextInt();

            // Según la opción, llamamos al método correspondiente
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
                    recargarBicicleta();
                    break;
                case 9:
                    mostrarHistorial();
                    break;
                case 10:
                    salir();
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
            // el ciclo se repite hasta que se elija la opción de salir
        } while (opcion != 10);

    }

    // Registra un nuevo usuario en el sistema pidiendo su información.
    public void registrarUsuario() {
        System.out.println("Registro de usuario");
        // ID: validamos que sea número y máx. 10 dígitos, y que no esté repetido
        int id;
        while (true) {
            System.out.print("Ingrese su ID (máx. 10 dígitos): ");
            // Mientras no escriba un número, pedimos de nuevo
            while (!sc.hasNextInt()) {
                System.out.println("  Solo se permiten números. Intente de nuevo.");
                sc.next();
            }

            id = sc.nextInt();
            sc.nextLine();
            // Limite de longitud (10 dígitos)
            if (String.valueOf(id).length() > 10) {
                System.out.println("  El ID no puede tener más de 10 dígitos. Intente de nuevo.");
                continue;
            }
            // Reviso que no exista otro usuario con ese ID
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
                break;// ID válido
            }
        }
        // Nombre: no puede quedar vacío
        String nombre;
        while (true) {
            System.out.print("Ingrese su Nombre Completo: ");
            nombre = sc.nextLine().trim();
            if (!nombre.isEmpty()) {
                break;
            }
            System.out.println("  El nombre no puede estar vacío. Intente de nuevo.");
        }
        // Tipo: solo Estudiante o Profesor
        String tipo;
        while (true) {
            System.out.print("Tipo (Estudiante/Profesor): ");
            tipo = sc.nextLine().trim();
            if (tipo.equalsIgnoreCase("Estudiante") || tipo.equalsIgnoreCase("Profesor")) {
                break;
            }
            System.out.println("  Solo se permite 'Estudiante' o 'Profesor'. Intente de nuevo.");
        }
        // Creo el usuario y lo guardo
        Usuario nuevoUsuario = new Usuario(nombre, id, tipo);
        usuarios.add(nuevoUsuario);
        System.out.println(" Usuario registrado correctamente.");

    }

    // Registra una bicicleta mecánica o eléctrica.
    // Valida que el id no se repita y que los datos sean correctos
    public void registrarBicicleta() {
        System.out.println("Registrar Bicicleta");

        int id;
        while (true) {
            System.out.print("Ingrese el ID de la bicicleta (máx. 5 dígitos): ");
            // ID: número, máx. 5 dígitos y único
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
            for (int i = 0; i < bicicletas.size(); i++) {
                Bicicleta b = bicicletas.get(i);
                if (b.getId() == id) {
                    repetido = true;
                    break;
                }
            }

            if (repetido) {
                System.out.println(" Ya existe una bicicleta con ese ID. Intente con otro.");
            } else {
                break;// ID validado
            }
        }
        // Modelo: solo Mecanica o Electrica
        String modelo;
        while (true) {
            System.out.print("Modelo (Mecanica/Electrica): ");
            modelo = sc.nextLine().trim();
            if (modelo.equalsIgnoreCase("Mecanica") || modelo.equalsIgnoreCase("Electrica")) {
                break;
            }
            System.out.println(" Solo se permite 'Mecanica' o 'Electrica'. Intente de nuevo.");
        }
        // Estado: solo Disponible o No disponible
        String estado;
        while (true) {
            System.out.print("Estado (Disponible/No disponible): ");
            estado = sc.nextLine().trim();
            if (estado.equalsIgnoreCase("Disponible") || estado.equalsIgnoreCase("No disponible")) {
                break;
            }
            System.out.println(" Solo se permite 'Disponible' o 'No disponible'. Intente de nuevo.");
        }
        // Creo la bicicleta según el modelo
        if (modelo.equalsIgnoreCase("Mecanica")) {
            // Para mecánica no hay nivel de batería
            bicicletas.add(new Mecanica(id, estado));
            System.out.println(" Bicicleta mecánica registrada.");
        } else {
            int nivel;
            while (true) {
                // Para eléctrica, pido nivel de batería y valido rango
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
                    break; // nivel validado
                }
            }

            Electrica nuevaBici = new Electrica(id, estado, nivel);
            bicicletas.add(nuevaBici);
            System.out.println(" Bicicleta eléctrica registrada.");
        }

    }

    // Muestra todos los usuarios registrados
    public void listarUsuarios() {
        System.out.println("\n Listado de usuarios");
        // Recorro y muestro en el formato que usamos en todo el proyecto
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario p = usuarios.get(i);
            System.out.println(
                    p.getId() + " - " + p.getNombre() + " - " + p.getTipoUsuario());
        }

    }

    // Muestra todas las bicicletas registradas (mecánicas y eléctricas)
    public void listarBicicletas() {
        System.out.println("\nListado de bicicletas:");
        // Muestro cada bici con su tipo y estado; en eléctricas agrego batería
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
                        m.getId() + " - " + m.getTipo() + " - " + m.getEstadoTexto());
            }

        }

    }

    // Muestra las bicicletas que están disponibles para prestar
    public void listarDisponibles() {
        System.out.println("\nListado de bicicletas disponibles");

        boolean hayDisponibles = false;

        // Recorro todas y muestro solo las que están en true (disponibles)
        for (int i = 0; i < bicicletas.size(); i++) {
            Bicicleta b = bicicletas.get(i);

            if (b.getEstado()) {
                hayDisponibles = true;

                // Si es eléctrica, muestro también la batería
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

    // Permite prestar una bicicleta a un usuario.
    // Comprueba que el usuario exista, que la bici esté libre
    // y que, si es eléctrica, tenga batería suficiente
    public void prestarBicicleta() {
        System.out.println("\n--- Prestar Bicicleta ---");

        // Pido ID de usuario y valido que sea número
        System.out.print("Ingrese su ID de usuario: ");
        while (!sc.hasNextInt()) {
            System.out.println(" Debe ingresar un número entero para el ID.");
            sc.next();
            System.out.print("Ingrese su ID de usuario: ");
        }
        int idUsuario = sc.nextInt();
        sc.nextLine();

        // Busco el usuario en la lista
        Usuario u = null;
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario user = usuarios.get(i);
            if (user.getId() == idUsuario) {
                u = user;
                break;
            }
        }
        if (u == null) {
            System.out.println(" No existe un usuario con ID " + idUsuario + ".");
            return;
        }
        // Muestro disponibles (las eléctricas con batería 0 no aparecen)
        System.out.println("\nBicicletas disponibles:");
        boolean hayDisponibles = false;
        for (int i = 0; i < bicicletas.size(); i++) {
            Bicicleta b = bicicletas.get(i);
            if (b.getEstado()) {
                if (b instanceof Electrica) {
                    Electrica e = (Electrica) b;
                    if (e.getNivelBateria() == 0) {
                        // si está en 0%, la salto (no prestable)
                        continue;
                    }
                    hayDisponibles = true;
                    System.out.println(e.getId() + " - " + "Electrica" + " - " + e.getEstadoTexto() + " - "
                            + e.getNivelBateria() + "%");
                } else if (b instanceof Mecanica) {
                    hayDisponibles = true;
                    System.out.println(b.getId() + " - " + "Mecanica" + " - " + b.getEstadoTexto());
                }
            }
        }
        if (!hayDisponibles) {
            System.out.println("No hay bicicletas disponibles en este momento.");
            return;
        }
        // Pido el ID de la bicicleta y valido que esté disponible
        System.out.print("\nIngrese el ID de la bicicleta que desea tomar: ");
        while (!sc.hasNextInt()) {
            System.out.println("  Debe ingresar un número entero.");
            sc.next();
            System.out.print("Ingrese el ID de la bicicleta que desea tomar: ");
        }
        int idBici = sc.nextInt();
        sc.nextLine();

        Bicicleta biciElegida = null;
        for (int i = 0; i < bicicletas.size(); i++) {
            Bicicleta b = bicicletas.get(i);
            if (b.getId() == idBici && b.getEstado()) {
                // Si es eléctrica y tiene 0%, la bloqueo acá también por si acaso
                if (b instanceof Electrica) {
                    Electrica e = (Electrica) b;
                    if (e.getNivelBateria() == 0) {
                        System.out.println(" La bicicleta eléctrica (ID " + e.getId()
                                + ") tiene batería 0% y no se puede prestar. Recárguela.");
                        return;
                    }
                }
                biciElegida = b;
                break;
            }
        }
        if (biciElegida == null) {
            System.out.println(" El ID " + idBici + " no existe o no está disponible.");
            return;
        }
        // Registro el préstamo y marco la bici como no disponible
        Prestamo nuevo = new Prestamo(u, biciElegida);
        prestamos.add(nuevo);
        biciElegida.setEstado(false);

        // Mensaje de confirmación
        String tipo;
        if (biciElegida instanceof Electrica) {
            tipo = "Electrica";
        } else {
            tipo = "Mecanica";
        }
        System.out.println(" Préstamo registrado:");
        System.out.println("   Usuario: " + u.getNombre() + " (ID " + u.getId() + ")");
        System.out.println("   Bicicleta: " + tipo + " (ID " + biciElegida.getId() + ")");

    }

    // Permite devolver una bicicleta prestada.
    // Marca la bicicleta como disponible y descuenta batería si es eléctrica.
    public void devolverBicicleta() {
        System.out.println("\n--- Devolver Bicicleta ---");
        // Pido ID de usuario y valido que sea número
        System.out.print("Ingrese su ID de usuario: ");
        while (!sc.hasNextInt()) {
            System.out.println(" Debe ingresar un número entero para el ID.");
            sc.next();
            System.out.print("Ingrese su ID de usuario: ");
        }
        int idUsuario = sc.nextInt();
        sc.nextLine();
        // Busco el usuario
        Usuario u = null;
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario user = usuarios.get(i);
            if (user.getId() == idUsuario) {
                u = user;
                break;
            }
        }
        if (u == null) {
            System.out.println(" No existe un usuario con ID " + idUsuario + ".");
            return;
        }
        // Busco su préstamo activo (asumimos 1 por usuario)
        Prestamo prestamoUsuario = null;
        for (int i = 0; i < prestamos.size(); i++) {
            Prestamo p = prestamos.get(i);
            if (p.getUsuario().getId() == u.getId()) {
                prestamoUsuario = p;
                break;
            }
        }
        if (prestamoUsuario == null) {
            System.out.println(" El usuario " + u.getNombre() + " no tiene bicicletas en préstamo.");
            return;
        }
        // Muestro la bici que va a devolver
        Bicicleta b = prestamoUsuario.getBici();
        System.out.println("\nBicicleta en préstamo de " + u.getNombre() + ":");
        if (b instanceof Electrica) {
            Electrica e = (Electrica) b;
            System.out.println(
                    e.getId() + " - " + "Electrica" + " - " + e.getEstadoTexto() + " - " + e.getNivelBateria() + "%");
        } else if (b instanceof Mecanica) {
            System.out.println(b.getId() + " - " + "Mecanica" + " - " + b.getEstadoTexto());
        }
        // Si es eléctrica, descargo un 15% (sin dejar negativo)
        if (b instanceof Electrica) {
            Electrica e = (Electrica) b;
            int nueva = e.getNivelBateria() - 15;
            if (nueva < 0) {
                nueva = 0;
            }
            e.setNivelBateria(nueva);
        }

        // Marco disponible y elimino el préstamo
        b.setEstado(true);

        for (int i = 0; i < prestamos.size(); i++) {
            Prestamo p = prestamos.get(i);
            if (p.getUsuario().getId() == u.getId() && p.getBici().getId() == b.getId()) {
                prestamos.remove(i);
                break;
            }
        }
        // Confirmación final
        String tipo;
        if (b instanceof Electrica) {
            tipo = "Electrica";
        } else {
            tipo = "Mecanica";
        }

        System.out.println(" Devolución registrada:");
        System.out.println("   Usuario: " + u.getNombre() + " (ID " + u.getId() + ")");
        if (b instanceof Electrica) {
            Electrica e = (Electrica) b;
            System.out.println("   Bicicleta: " + tipo + " (ID " + b.getId() + ") ahora Disponible - Batería: "
                    + e.getNivelBateria() + "%");
        } else {
            System.out.println("   Bicicleta: " + tipo + " (ID " + b.getId() + ") ahora Disponible");
        }
    }

    // Permite recargar la batería de una bicicleta eléctrica
    public void recargarBicicleta() {
        System.out.println("\n--- Recargar Bicicleta ---");

        // Pido el ID de la bici y valido que sea número
        System.out.print("Ingrese el ID de la bicicleta: ");
        while (!sc.hasNextInt()) {
            System.out.println(" Debe ingresar un número entero.");
            sc.next();
            System.out.print("Ingrese el ID de la bicicleta: ");
        }
        int id = sc.nextInt();
        sc.nextLine();
        // Busco la bici por ID
        Bicicleta b = null;
        for (int i = 0; i < bicicletas.size(); i++) {
            if (bicicletas.get(i).getId() == id) {
                b = bicicletas.get(i);
                break;
            }
        }
        if (b == null) {
            System.out.println(" No existe una bicicleta con ese ID.");
            return;
        }

        // Si es eléctrica, pongo batería en 100. Si es mecánica, aviso que no aplica
        if (b instanceof Electrica) {
            Electrica e = (Electrica) b;
            e.setNivelBateria(100);
            System.out.println(" Bicicleta eléctrica (ID " + e.getId() + ") recargada al 100%.");
        } else {
            System.out.println(" La bicicleta (ID " + b.getId() + ") es mecánica y no requiere recarga.");
        }
    }

    // Muestra solo los préstamos que siguen activos en el momento
    public void mostrarHistorial() {
        System.out.println("\n--- Historial de préstamos activos ---");
        // Si no hay préstamos, lo informo y salgo
        if (prestamos.isEmpty()) {
            System.out.println(" No hay préstamos activos en este momento.");
            return;
        }

        // Recorro cada préstamo y muestro el usuario y la bici asociada
        for (int i = 0; i < prestamos.size(); i++) {
            Prestamo p = prestamos.get(i);
            Usuario u = p.getUsuario();
            Bicicleta b = p.getBici();

            String tipo;
            if (b instanceof Electrica) {
                tipo = "Electrica";
                Electrica e = (Electrica) b;
                System.out.println(
                        "Usuario: " + u.getNombre() + " (ID " + u.getId() + ") - "
                                + "Bicicleta: " + tipo + " (ID " + e.getId() + ") - "
                                + "Estado: " + e.getEstadoTexto() + " - "
                                + "Batería: " + e.getNivelBateria() + "%");
            } else if (b instanceof Mecanica) {
                tipo = "Mecanica";
                System.out.println(
                        "Usuario: " + u.getNombre() + " (ID " + u.getId() + ") - "
                                + "Bicicleta: " + tipo + " (ID " + b.getId() + ") - "
                                + "Estado: " + b.getEstadoTexto());
            }
        }
    }

    // Muestra un mensaje de despedida y cierra el programa
    public void salir() {
        // Mensaje corto de cierre y fin del programa
        System.out.println("¡Hasta luego!");
        System.exit(0);
    }
}