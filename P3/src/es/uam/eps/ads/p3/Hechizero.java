package es.uam.eps.ads.p3;

public class Hechizero extends Mago {

    /**
     * Inicializa un hechizero dado su nombre, energía, posada actual y poder.
     * @param nombre Nombre del hechizero
     * @param energia Energia del hechizero
     * @param posadaActual Posada actual del hechizero
     * @param poder Poder del hechizero
     */
    public Hechizero(String nombre, int energia, Posada posadaActual, 
                int poder) {
        super(nombre, energia, posadaActual, poder);
    }

    @Override
    public boolean puedeAlojarseEn(Posada posada) {
        System.out.println("Intenta ir a " + posada);
        System.out.println(Integer.toString(posada.getLuz().getValor()) + " <= " + Integer.toString(Luz.TENEBROSA.getValor()+poder));
        if (posada.getLuz().getValor() <= Luz.TENEBROSA.getValor()+poder) {
            return true;
        } else {
            return false;
        }
    }
}