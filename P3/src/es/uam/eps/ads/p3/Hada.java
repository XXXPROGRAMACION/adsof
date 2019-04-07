package es.uam.eps.ads.p3;

/**
 * <p>Esta clase permite trabajar con hadas.</p>
 * 
 * @author <p>Alejandro Pascual (alejandro.pascualp@estudiante.uam.es)<br>
 *         Víctor Yrazusta (victor.yrazusta@estudiante.uam.es)</p>
 */
public class Hada extends Mago {

    /**
     * Inicializa un hada dado su nombre, energía, posada actual y poder.
     * @param nombre Nombre del hada
     * @param energia Energia del hada
     * @param posadaActual Posada actual del hada
     * @param poder Poder del hada
     */
    public Hada(String nombre, int energia, Posada posadaActual, 
                int poder) {
        super(nombre, energia, posadaActual, poder);
    }

    /**
     * Comprueba si el Hada se puede alojar en la posada indicada.
     * @return "true" si el nivel de luz de la Posada es superior al nivel de
     * luz GRIS y no hay hechiceros alojados en la Posada. "false" en caso
     * contrario
     */
    @Override
    public boolean puedeAlojarseEn(Posada posada) {
        if (posada.hayHechicero() == true) return false;

        if (posada.getLuz().getValor() > Luz.GRIS.getValor()) {
            return true;
        } else {
            return false;
        }
    }
}