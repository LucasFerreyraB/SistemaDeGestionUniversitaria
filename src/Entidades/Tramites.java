package Entidades;

public class Tramites {
    private int nro;
    private boolean estado;

    public Tramites() {
    }

    public Tramites(int nro, boolean estado) {
        this.nro = nro;
        this.estado = estado;
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
