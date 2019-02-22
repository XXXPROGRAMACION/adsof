package es.uam.eps.ads.p2.tienda;

/**
 * <p>Esta clase permite trabajar con un disco como artículo.</p>
 * 
 * @author <p>Alejandro Pascual (alejandro.pascualp@estudiante.uam.es)<br>
 *         Víctor Yrazusta (victor.yrazusta@estudiante.uam.es)</p>
 */
public class Disco extends Articulo {
    private String interprete;
    private int anoPublicacion;

    /**
     * Permite instanciar un disco dados su id, título, intérprete y año de publicación.
     * @param id Id interna del disco
     * @param titulo Título del disco
     * @param interprete Intérprete del disco
     * @param anoPublicacion Año de publicación del disco
     */
    public Disco(int id, String titulo, String interprete, int anoPublicacion) {
        super(id, titulo);
        this.interprete = interprete;
        this.anoPublicacion = anoPublicacion;
    }

    /**
     * Recoge en una cadena la información de la clase.
     * @return Cadena con los datos de la instancia
     */
    public String toString() {
        return "[" + id + "]" + " DISCO: " + titulo + " - " + interprete + " (" + anoPublicacion + ")";
    }
}