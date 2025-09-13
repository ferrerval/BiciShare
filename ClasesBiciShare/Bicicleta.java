package ClasesBiciShare;

public class Bicicleta {
    
    private int id;
    private boolean estado;

    public Bicicleta(int id, boolean estado){
        this.id=id;
        this.estado=estado;
    }
    public int getId(){
        return id;
    }
    public boolean getEstado(){
        return estado;
    }
    public void setEstado(boolean estado){
        this.estado=estado;
    }
}
