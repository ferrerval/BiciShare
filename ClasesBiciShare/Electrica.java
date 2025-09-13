package ClasesBiciShare;

public class Electrica extends Bicicleta {

    private int nivelBateria;

    public Electrica(int id, boolean estado, int nivelBateria) {
        super(id, estado);
        this.nivelBateria = nivelBateria;
    }

    public int getNivelBateria() {
        return nivelBateria;
    }

    public void setNivelBateria(int nivelBateria) {
        this.nivelBateria = nivelBateria;
    }
}