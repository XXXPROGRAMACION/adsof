package es.uam.eps.ads.p3;

/**
 * <p>Esta clase permite trabajar con hechiceros.</p>
 * 
 * @author <p>Alejandro Pascual (alejandro.pascualp@estudiante.uam.es)<br>
 *         Víctor Yrazusta (victor.yrazusta@estudiante.uam.es)</p>
 */
public class Hechicero extends Mago {

    /**
     * Inicializa un hechicero dado su nombre, energía, posada actual y poder.
     * @param nombre Nombre del hechicero
     * @param energia Energia del hechicero
     * @param posadaActual Posada actual del hechicero
     * @param poder Poder del hechicero
     */
    public Hechicero(String nombre, int energia, Posada posadaActual, 
                int poder) {
        super(nombre, energia, posadaActual, poder);
    }

    /**
     * Comprueba si el hechicero se puede alojar en la posada indicada.
     * @return "true" si el nivel de luz de la posada es inferior o igual al 
     * nivel de luz TENEBROSA más el poder del hechicero y no hay hadas alojadas
     * en la posada. "false" en caso contrario
     */
    @Override
    public boolean puedeAlojarseEn(Posada posada) {
        if (posada.hayHada() == true) return false;

        if (posada.getLuz().getValor() <= Luz.TENEBROSA.getValor()+poder) {
            return true;
        } else {
            return false;
        }
    }
}