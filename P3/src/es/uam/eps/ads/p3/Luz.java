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
     * @return Valor de la luz
     */
    public int getValor() {
        return valor;
    }

    /**
     * Devuelve el elemento correspondiente de la enumeración dado su valor.
     * @return Elemento correspondiente de la enumeración dado su valor
     */
    public static Luz getLuz(int nivelLuz) {
        for (Luz luz : Luz.values()) {
            if (nivelLuz == luz.getValor()) return luz;
        }
        return null;
    }
}