package es.uam.eps.ads.p2.apartado5;

/**
 * <p>Esta clase permite trabajar con sillas para el automóvil.</p>
 * 
 * @author <p>Alejandro Pascual (alejandro.pascualp@estudiante.uam.es)<br>
 *         Víctor Yrazusta (victor.yrazusta@estudiante.uam.es)</p>
 */
public class Silla extends ArticuloReparable {
    private int pesoMinimo;
    private int pesoMaximo;
    private boolean isofix;


    /**
     * Permite instanciar una silla dadas sus características.
     * @param codigoDeBarras Codigo de barras de la silla
     * @param marca Marca de la silla
     * @param modelo Modelo de la silla
     * @param color Color de la silla
     * @param pesoMinimo Peso mínimo soportado por la silla
     * @param pesoMaximo Peso máximo soportado por la silla
     * @param isofix Indica si la silla cuenta con el sistema Isofix
     */
    public Silla(String codigoDeBarras, String marca, String modelo,
                 String color, int pesoMinimo, int pesoMaximo, boolean isofix) {
        super(codigoDeBarras, marca, modelo, color);
        this.pesoMinimo = pesoMinimo;
        this.pesoMaximo = pesoMaximo;
        this.isofix = isofix;
    }

    /**
     * Permite recoger la información de la clase en una cadena de carácteres.
     * @return Cadena de caracteres con la información de la clase
     */
    public String toString() {
        return "[Silla " + codigoDeBarras + ", marca " + marca
        + ", modelo " + modelo + ", color " + color + ", rango de peso: [" + 
        pesoMinimo + ", " + pesoMaximo + "]]";
    }

    /**
     * Permite saber el peso mínimo soportado por la silla.
     * @return Peso mínimo soportado por la silla
     */
    public int getPesoMinimo() {
        return pesoMinimo;
    }

    /**
     * Permite saber el peso máximo soportado por la silla.
     * @return Peso máximo soportado por la silla
     */
    public int getPesoMaximo() {
        return pesoMaximo;
    }

    /**
     * Permite saber si la silla cuenta con el sistema Isofix.
     * @return "true" si la silla cuenta con el sistema Isofix, "false" en otro
     * caso
     */
    public boolean getIsofix() {
        return isofix;
    }
}

