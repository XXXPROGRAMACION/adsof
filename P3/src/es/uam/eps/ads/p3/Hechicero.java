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