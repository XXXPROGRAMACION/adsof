package es.uam.ads.p2.tienda;

import es.uam.ads.p2.tienda.Articulo;

public class Pelicula extends Articulo {
    private String genero;
    private String director;

    public Pelicula(int id, String titulo, String genero, String director) {
        super(id, titulo);
        this.genero = genero;
        this.director = director;
    }

    public String toString() {
        return "[" + id + "]" + " PELICULA: " + titulo + " (" + genero + "). Dir: " + director;
    }
}