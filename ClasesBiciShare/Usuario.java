package ClasesBiciShare;

public class Usuario {
    private String nombre;
    private int id;
    private String TipoUsuario;

    public Usuario(String nombre, int id, String TipoUsuario){
        this.nombre = nombre;
        this.id = id;
        this.TipoUsuario = TipoUsuario;
    }
    public int getId(){
        return id;
    }
    public String getNombre(){
        return nombre;
    }
    public String getTipoUsuario(){
        return TipoUsuario;
    }

}
