package ClasesBiciShare;

public class Prestamo {
    private Usuario usuario;
    private Bicicleta bici;

    public Prestamo(Usuario usuario, Bicicleta bici){
        this.usuario = usuario;
        this.bici = bici;
    }

    public Usuario getUsuario(){
        return usuario;
    }

    public Bicicleta getBici(){
        return bici;
    }

}
