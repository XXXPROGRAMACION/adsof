package es.uam.eps.ads.p2.apartado5;

/**
 * <p>Esta clase permite trabajar con carritos.</p>
 * 
 * @author <p>Alejandro Pascual (alejandro.pascualp@estudiante.uam.es)<br>
 *         Víctor Yrazusta (victor.yrazusta@estudiante.uam.es)</p>
 */
public class Carrito extends ArticuloReparable {
    boolean engancheCorrecto;
    boolean capazo;
    boolean bolsaDeViaje;
    boolean cuco;

    /**
     * Permite instanciar un carrito dadas sus características.
     * @param codigoDeBarras Codigo de barras del carrito
     * @param marca Marca del carrito
     * @param modelo Modelo del carrito
     * @param color Color del carrito
     * @param capazo Indica si el carrito tiene capazo
     * @param bolsaDeViaje Indica si el carrito tiene bolsa de viaje
     * @param cuco Indica si el carrito tiene cuco
     */
    public Carrito(String codigoDeBarras, String marca, String modelo,
                            String color, boolean capazo, 
                            boolean bolsaDeViaje, boolean cuco) {
        super(codigoDeBarras, marca, modelo, color);
        this.capazo = capazo;
        this.bolsaDeViaje = bolsaDeViaje;
        this.cuco = cuco;
    }

    /**
     * Permite recoger la información de la clase en una cadena de carácteres.
     * @return Cadena de caracteres con la información de la clase
     */
    public String toString() {
        return "[Carrito " + codigoDeBarras + ", marca " + marca
        + ", modelo " + modelo + ", color " + color + "]";
    }

    /**
     * Permite modificar la información de si el enganche del carrito es 
     * correcto.
     * @param engancheCorrecto Determina si el enganche del carrito es correcto
     */
    public void setEngancheCorrecto(boolean engancheCorrecto) {
        this.engancheCorrecto = engancheCorrecto;
    }

    /**
     * Permite saber si el enganche del carrito es correcto.
     * @return "true" si el enganche del carrito es correcto, "false" en otro
     * caso
     */
    public boolean getEngancheCorrecto() {
        return engancheCorrecto;
    }

    /**
     * Permite saber si el carrito tiene capazo.
     * @return "true" si el carrito tiene capazo, "false" en otro caso
     */
    public boolean tieneCapazo() {
        return capazo;
    }

    /**
     * Permite saber si el carrito tiene bolsa de viaje.
     * @return "true" si el carrito tiene bolsa de viaje, "false" en otro caso
     */
    public boolean tieneBolsaDeViaje() {
        return bolsaDeViaje;
    }

    /**
     * Permite saber si el carrito tiene cuco.
     * @return "true" si el carrito tiene cuco, "false" en otro caso
     */
    public boolean tieneCuco() {
        return cuco;
    }

    /**
     * Permite saber si el carrito es apto para la venta.
     * @return "true" si el carrito es apto para la venta, "false" en otro caso
     */
    @Override
    public boolean esApto() {
        return super.esApto() && engancheCorrecto;
    }
}