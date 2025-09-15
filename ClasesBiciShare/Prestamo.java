package ClasesBiciShare;

public class Prestamo {
    // Usuario que tiene la bicicleta prestada
    private Usuario usuario;
    // Bicicleta que el usuario tomó en préstamo
    private Bicicleta bici;

    // Crea un nuevo préstamo ligando un usuario con una bicicleta.
    // Se usa cuando el usuario toma una bicicleta
    public Prestamo(Usuario usuario, Bicicleta bici) {
        this.usuario = usuario;
        this.bici = bici;
    }

    // Métodos para consultar el usuario o la bicicleta de este préstamo.
    // Se usan para mostrar el historial y para las devoluciones.
    public Usuario getUsuario() {
        return usuario;
    }

    public Bicicleta getBici() {
        return bici;
    }

}
