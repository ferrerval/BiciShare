package ClasesBiciShare;

public class Usuario {

    private String nombre;
    private int id;
    private String TipoUsuario;

    // metodo constructor que recibe la informacion del nuevo usuario

    public Usuario(String nombre, int id, String TipoUsuario) {
        this.nombre = nombre;
        this.id = id;
        this.TipoUsuario = TipoUsuario;
    }

    // metodos para obtener los datos del usuario por el encapsulamiento, usados en
    // todo el sistema
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoUsuario() {
        return TipoUsuario;
    }

}
