package ClasesBiciShare;

public class Bicicleta {
    // id para identificar la bicicleta
    private int id;
    // devuelve true si la bicicleta esta disponible para el prestamo
    private boolean estado;

    // metodo constructor el cual recibe un id y el estado en texto
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

    // metodos de consulta y actualizacion del estado a Disponible o no Disponible
    // en texto segun la condicion
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
