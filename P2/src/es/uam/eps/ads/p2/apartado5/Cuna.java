package es.uam.eps.ads.p2.apartado5;

/**
 * <p>Esta clase permite trabajar con cunas.</p>
 * 
 * @author <p>Alejandro Pascual (alejandro.pascualp@estudiante.uam.es)<br>
 *         Víctor Yrazusta (victor.yrazusta@estudiante.uam.es)</p>
 */
public class Cuna extends Articulo {
    private boolean pliegeCorrecto;

    /**
     * Permite inicializar una cuna dado su código de barras.
     * @param codigoDeBarras Código de barras de la cuna
     */
    public Cuna(String codigoDeBarras) {
        super(codigoDeBarras);
    }

    /**
     * Permite recoger la información de la clase en una cadena de carácteres.
     * @return Cadena de caracteres con la información de la clase
     */
    public String toString() {
        return "[Cuna " + codigoDeBarras + "]";
    }

    /**
     * Permite modificar el valor de corrección del pliegue de una cuna.
     * @param pliegueCorrecto Valor de la correción del pliegue de la cuna
     */
    public void setPliegueCorrecto(boolean pliegeCorrecto) {
        this.pliegeCorrecto = pliegeCorrecto;
    }


    /**
     * Permite saber si el pliegue de una cuna es correcto.
     * @return "true" si el pliegue de la cuna es correcto, "false" en caso
     * contrario
     */
    public boolean getPliegueCorrecto() {
        return pliegeCorrecto;
    }

    /**
     * Permite saber si la cuna es apta para la venta.
     * @return "true" si la cuna es apta para la venta, "false" en el caso
     * contrario.
     */
    @Override
    public boolean esApto() {
        return pliegeCorrecto;
    }
}