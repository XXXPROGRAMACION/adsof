package es.uam.eps.ads.p2.tienda;

/**
 * <p>Esta clase define los parametros de un artículo, sin funcionalidad.</p>
 * 
 * @author <p>Alejandro Pascual (alejandro.pascualp@estudiante.uam.es)<br>
 *         Víctor Yrazusta (victor.yrazusta@estudiante.uam.es)</p>
 */
public abstract class Articulo {
    protected int id;
    protected String titulo;

    /**
     * Permite instanciar un artículo dados su id y título.
     * @param id Id interna del artículo
     * @param titulo Título del artículo
     */
    public Articulo(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }
}