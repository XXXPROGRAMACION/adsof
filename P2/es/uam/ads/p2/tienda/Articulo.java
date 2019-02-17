package es.uam.ads.p2.tienda;

public abstract class Articulo {
    protected int id;
    protected String titulo;

    public Articulo(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }
}