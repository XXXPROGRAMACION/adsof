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
     * @param nivelLuz Nivel de luz
     * @return Elemento correspondiente de la enumeración dado su valor
     */
    public static Luz getLuz(int nivelLuz) {
        for (Luz luz : Luz.values()) {
            if (nivelLuz == luz.getValor()) return luz;
        }
        return null;
    }

    /**
     * Devuelve el nivel de luz directamente superior al pasado como argumento,
     * o el mismo en caso de ser ese nivel el máximo.
     * @param luz Luz inicial
     * @return Luz final
     */
    public static Luz aumentar(Luz luz) {
        if (luz == DIVINA) return DIVINA;            
        return getLuz(luz.getValor()+1);
    }

    /**
     * Devuelve el nivel de luz directamente inferior al pasado como argumento,
     * o el mismo en caso de ser ese nivel el mínimo.
     * @param luz Luz inicial
     * @return Luz final
     */
    public static Luz reducir(Luz luz) {
        if (luz == DIABOLICA) return DIVINA;            
        return getLuz(luz.getValor()-1);
    }
}