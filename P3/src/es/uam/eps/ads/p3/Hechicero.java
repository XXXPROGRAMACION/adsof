package es.uam.eps.ads.p3;

public class Hechicero extends Mago {

    /**
     * Inicializa un Hechicero dado su nombre, energía, posada actual y poder.
     * @param nombre Nombre del Hechicero
     * @param energia Energia del Hechicero
     * @param posadaActual Posada actual del Hechicero
     * @param poder Poder del Hechicero
     */
    public Hechicero(String nombre, int energia, Posada posadaActual, 
                int poder) {
        super(nombre, energia, posadaActual, poder);
    }

    /**
     * Comprueba si el Hechicero se puede alojar en la posada indicada.
     * @return "true" si el nivel de luz de la Posada es inferior o igual al 
     * nivel de luz TENEBROSA más el poder del Hechicero y no hay hadas alojadas
     * en la Posada. "false" en caso contrario
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