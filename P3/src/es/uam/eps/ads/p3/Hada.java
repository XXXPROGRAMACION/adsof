package es.uam.eps.ads.p3;


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

    @Override
    public boolean puedeAlojarseEn(Posada posada) {
        if (posada.getLuz().getValor() > Luz.GRIS.getValor()) {
            return true;
        } else {
            return false;
        }
    }
}