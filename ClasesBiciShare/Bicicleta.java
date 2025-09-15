package ClasesBiciShare;

public class Bicicleta {

    private int id;
    private boolean estado;

    public Bicicleta(int id, String estado) {
        this.id = id;
        if (estado == null) {
            this.estado = false;
        } else if (estado.equalsIgnoreCase("Disponible")) {
            this.estado = true;
        } else if (estado.equalsIgnoreCase("No disponible")) {
            this.estado = false;
        } else {
            this.estado = Boolean.parseBoolean(estado.trim());
        }
    }

    public int getId() {
        return id;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getEstadoTexto() {
        if (estado) {
            return "Disponible";
        } else {
            return "No disponible";
        }
    }
}
