package es.uam.eps.ads.p2.apartado5;

/**
 * <p>Esta clase permite trabajar con cunas.</p>
 * 
 * @author <p>Alejandro Pascual (alejandro.pascualp@estudiante.uam.es)<br>
 *         Víctor Yrazusta (victor.yrazusta@estudiante.uam.es)</p>
 */
public abstract class ArticuloReparable extends Articulo{
    protected String marca;
    protected String modelo;
    protected String color;
    protected boolean tieneTodasLasPiezas;
    protected boolean anclajesCorrectos;
    protected boolean acholchadoCorrecto;
    protected String registroTareas;

    /**
     * Permite instanciar un artículo reparable dadas sus características.
     * @param codigoDeBarras Código de barras del artículo
     * @param marca Marca del artículo
     * @param modelo Modelo del artículo
     * @param color Color del artículo
     */
    public ArticuloReparable(String codigoDeBarras, String marca, String modelo,
                            String color) {
        super(codigoDeBarras);
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
    }

    /**
     * Permite recoger la información de la clase en una cadena de carácteres.
     * @return Cadena de caracteres con la información de la clase
     */
    public String toString() {
        return "[Artículo reparable " + codigoDeBarras + ", marca " + marca
        + ", modelo " + modelo + ", color " + color + "]";
    }

    /**
     * Permite saber la marca de un artículo reparable.
     * @return La marca del artículo
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Permite saber el modelo de un artículo reparable.
     * @return El modelo del artículo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Permite saber el color de un artículo reparable.
     * @return El color del artículo
     */
    public String getColor() {
        return color;
    }

    /**
     * Permite cambiar la información de si un artículo tiene todas las piezas.
     * @param tieneTodasLasPiezas Marca si el artículo posee todas sus piezas
     */
    public void setTieneTodasLasPiezas(boolean tieneTodasLasPiezas) {
        this.tieneTodasLasPiezas = tieneTodasLasPiezas;
    }

    /**
     * Permite saber si un artículo reparable contiene todas las piezas.
     * @return "true" si el artículo tiene todas las piezas, "false" en caso
     * contrario
     */
    public boolean getTieneTodasLasPiezas() {
        return tieneTodasLasPiezas;
    }

    /**
     * Permite cambiar la información de si un artículo tiene los anclajes
     * correctos.
     * @param anclajesCorrectos Marca si el artículo tiene los anclajes 
     * correctos
     */
    public void setAnclajesCorrectos(boolean anclajesCorrectos) {
        this.anclajesCorrectos = anclajesCorrectos;
    }

    /**
     * Permite saber si un artículo reparable tiene los anclajes correctos.
     * @return "true" en caso de que el artículo tenga los anclajes correctos, 
     * "false" en caso contrario
     */
    public boolean getAnclajesCorrectos() {
        return anclajesCorrectos;
    }

    /**
     * Permite modificar la información de si el acolchado de un artículo 
     * reparable es correcto.
     * @param acolchadoCorrecto Marca si el acolchado del artículo es correcto
     * o, si por el contrario presenta defectos
     */
    public void setAcolchadoCorrecto(boolean acholchadoCorrecto) {
        this.acholchadoCorrecto = acholchadoCorrecto;
    }

    /**
     * Permite saber si el acolchado de un artículo reparable es correcto.
     * @return "true" en caso de que el acolchado del artículo sea correcto, 
     * "false" en caso contrario
     */
    public boolean getAcolchadoCorrecto() {
        return acholchadoCorrecto;
    }

    /**
     * Permite modificar la información del registro de tareas de un artículo
     * reparable.
     * @param registroTareas Registro de las tareas del artículo
     */
    public void setRegistroTareas(String registroTareas) {
        this.registroTareas = registroTareas;
    }

    /**
     * Permite obtener el registro de tareas de un artículo reparable.
     * @return Registro de tareas del artículo
     */
    public String getRegistroTareas() {
        return registroTareas;
    }

    /**
     * Permite saber si un artículo reparable es apto para la venta.
     * @return "true" si el artículo es apto para la venta, "false" en caso 
     * contrario
     */
    @Override
    public boolean esApto() {
        return tieneTodasLasPiezas && anclajesCorrectos;
    }
}