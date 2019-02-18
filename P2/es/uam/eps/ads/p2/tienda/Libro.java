package es.uam.eps.ads.p2.tienda;

public class Libro extends Articulo {
    private String autor;
    private String editorial;

    public Libro(int id, String titulo, String autor, String editorial) {
        super(id, titulo);
        this.autor = autor;
        this.editorial = editorial;
    }

    public String toString() {
        return "[" + id + "]" + " LIBRO: " + titulo + ". " + autor + ". " + editorial;
    }
}