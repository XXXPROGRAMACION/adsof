package es.uam.eps.ads.p3;

/**
 * <p>Esta enumeración define las luces que pueden existir en una posada.</p>
 * 
 * @author <p>Alejandro Pascual (alejandro.pascualp@estudiante.uam.es)<br>
 *         Víctor Yrazusta (victor.yrazusta@estudiante.uam.es)</p>
 */
public enum Luz {
    DIABOLICA(0),
    NEGRA(1),
    TENEBROSA(2),
    GRIS(3),
    CLARA(4),
    BLANCA(5),
    DIVINA(6);

    private final int valor;

    private Luz(int valor) {
        this.valor = valor;
    }

    /**
     * Devuelve el valor de la luz dentro de la enumeración.
     * @return El valor de la luz
     */
    public int getValor() {
        return valor;
    }
}