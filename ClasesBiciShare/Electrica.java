package ClasesBiciShare;

//Hereda de Bicicleta e incluye un atributo extra: nivelBateria
public class Electrica extends Bicicleta {
    // porcentaje de batería de la bicicleta (0 a 100)
    private int nivelBateria;

    // Constructor: crea una bici eléctrica con id, estado y nivel de batería
    public Electrica(int id, String estado, int nivelBateria) {
        super(id, estado);
        this.nivelBateria = nivelBateria;
    }

    // Métodos para consultar o actualizar el nivel de batería.
    // Devuelve el nivel de batería actual
    public int getNivelBateria() {
        return nivelBateria;
    }

    // Permite cambiar el nivel de batería (al recargar o descargar)
    public void setNivelBateria(int nivelBateria) {
        this.nivelBateria = nivelBateria;
    }

    public String getTipo() {
        return "Electrica";
    }
}