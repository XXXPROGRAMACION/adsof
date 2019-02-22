package es.uam.eps.ads.p2.apartado5;

/**
 * <p>Esta clase permite generalizar la estructura y funcionalidades comunes
 * para los diferentes artículos.</p>
 * 
 * @author <p>Alejandro Pascual (alejandro.pascualp@estudiante.uam.es)<br>
 *         Víctor Yrazusta (victor.yrazusta@estudiante.uam.es)</p>
 */
public abstract class Articulo {
    protected String codigoDeBarras;
    protected boolean esteticaCorrecta;

    /**
     * Crea un artículo dado su código de barras.
     * @param codigoDeBarras Código de barras del artículo a instanciar
     */
    public Articulo(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    /**
     * Permite recoger la información de la clase en una cadena de carácteres.
     * @return Cadena de caracteres con la información de la clase
     */
    public String toString() {
        return "[Artículo " + codigoDeBarras + "]";
    }

    /**
     * Permite saber el código de barras de un artículo.
     * @return El código de barras de la instancia
     */
    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    /**
     * Permite modificar el valor de "esteticaCorrecta", que indica si un 
     * artículo posee o no defectos estéticos.
     * @param esteticaCorrecta El nuevo valor para la estética del artículo.
     */
    public void setEsteticaCorrecta(boolean esteticaCorrecta) {
        this.esteticaCorrecta = esteticaCorrecta;
    }

    /**
     * Permite saber si un producto se puede catalogar como Outlet.
     * @return "true" si el producto se puede clasificar como Outlet, "false"
     * en otro caso
     */
    public boolean esOutlet() {
        return !esteticaCorrecta;
    }

    /**
     * Permite saber si un producto es apto para su venta.
     * @return "true" en caso de que el producto sea apto para la venta,
     * "false" en otro caso
     */
    public abstract boolean esApto();
}