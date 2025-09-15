package ClasesBiciShare;

public class Usuario {
    // nombre completo del usuario
    private String nombre;
    // id que identifique al usuario
    private int id;
    // indica si el usuario es Estudiante o Profesor
    private String TipoUsuario;

    /**
     * metodo constructor del usuario
     * permite crear un usuario nuevo con su nombre, id y su tipo
     */

    public Usuario(String nombre, int id, String TipoUsuario) {
        this.nombre = nombre;
        this.id = id;
        this.TipoUsuario = TipoUsuario;
    }

    // retorna el id del usuario
    public int getId() {
        return id;
    }

    // retorna el nombre completo del usuario
    public String getNombre() {
        return nombre;
    }

    // retorna si el usuario es Estudiante o Profesor
    public String getTipoUsuario() {
        return TipoUsuario;
    }

}
