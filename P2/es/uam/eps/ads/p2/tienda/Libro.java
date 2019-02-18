package es.uam.eps.ads.p2.tienda;

/**
 * <p>Esta clase permite trabajar con un libro como artículo.</p>
 * 
 * @author <p>Alejandro Pascual (alejandro.pascualp@estudiante.uam.es)<br>
 *         Víctor Yrazusta (victor.yrazusta@estudiante.uam.es)</p>
 */
public class Libro extends Articulo {
    private String autor;
    private String editorial;

    /**
     * Permite instanciar un libro dados su id, título, autor y editorial.
     * @param id Id interna del libro
     * @param titulo Título del libro
     * @param autor Autor del libro
     * @param editorial Editorial del libro
     */
    public Libro(int id, String titulo, String autor, String editorial) {
        super(id, titulo);
        this.autor = autor;
        this.editorial = editorial;
    }

    /**
     * Recoge en una cadena la información de la clase.
     * @return Cadena con los datos de la instancia
     */
    public String toString() {
        return "[" + id + "]" + " LIBRO: " + titulo + ". " + autor + ". " + editorial;
    }
}