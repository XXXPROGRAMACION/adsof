package es.uam.eps.ads.p2.tienda;

/**
 * <p>Esta clase permite trabajar con una película como artículo.</p>
 * 
 * @author <p>Alejandro Pascual (alejandro.pascualp@estudiante.uam.es)<br>
 *         Víctor Yrazusta (victor.yrazusta@estudiante.uam.es)</p>
 */
public class Pelicula extends Articulo {
    private String genero;
    private String director;

    /**
     * Permite instanciar una película dados su id, título, genero y director.
     * @param id Id interna de la película
     * @param titulo Título de la película
     * @param genero Género de la película
     * @param director Director de la película
     */
    public Pelicula(int id, String titulo, String genero, String director) {
        super(id, titulo);
        this.genero = genero;
        this.director = director;
    }

    /**
     * Recoge en una cadena la información de la clase.
     * @return Cadena con los datos de la instancia
     */
    public String toString() {
        return "[" + id + "]" + " PELICULA: " + titulo + " (" + genero + "). Dir: " + director;
    }
}