package es.uam.ads.p2.tienda;

import es.uam.ads.p2.tienda.Articulo;

public class Disco extends Articulo {
    private String interprete;
    private int anoPublicacion;

    public Disco(int id, String titulo, String interprete, int anoPublicacion) {
        super(id, titulo);
        this.interprete = interprete;
        this.anoPublicacion = anoPublicacion;
    }

    public String toString() {
        return "[" + id + "]" + " DISCO: " + titulo + " - " + interprete + " (" + anoPublicacion + ")";
    }
}