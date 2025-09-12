package ClasesBiciShare;

public class Bicicleta {
    
    private int id;
    private String estado;

    public Bicicleta(int id, String estado){
        this.id=id;
        this.estado=estado;
    }
    public int getId(){
        return id;
    }
    public String getEstado(){
        return estado;
    }
    public void setEstado(String estado){
        this.estado=estado;
    }
}
