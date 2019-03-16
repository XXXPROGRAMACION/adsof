package es.uam.eps.ads.p3;


/**
 * <p>Esta clase permite trabajar con magos.</p>
 * 
 * @author <p>Alejandro Pascual (alejandro.pascualp@estudiante.uam.es)<br>
 *         Víctor Yrazusta (victor.yrazusta@estudiante.uam.es)</p>
 */
public abstract class Mago extends Explorador {
    int poder;

    /**
     * Inicializa un mago dado su nombre, energía, posada actual y poder.
     * @param nombre Nombre del mago
     * @param energia Energia del mago
     * @param posadaActual Posada actual del mago
     * @param poder Poder del mago
     */
    public Mago(String nombre, int energia, Posada posadaActual, 
                int poder) {
        super(nombre, energia, posadaActual);
        this.poder = poder;
    }

    /**
     * Indica si el mago puede recorrer el camino pasado como argumento,
     * basándose en el coste del camino, la energía del mago y las
     * condiciones del camino.
     * @param camino Camino para el que hacer la comprobación
     * @return "true" si puede recorrer el camino, "false" en caso contrario
     */
    public boolean puedeRecorrerCamino(Camino camino) {
        return camino.getCoste() <= getEnergia() && !camino.esTrampa();
    }

    public boolean puedeAlojarseEn(Posada posada) {
        return true;
    }
    
    /**
     * Devuelve el poder del mago.
     * @return Poder del mago
     */
    public int getPoder() {
        return poder;
    }

    /**
     * Recoge la información de la instancia en una cadena de caracteres.
     * @return String con el nombre, la energía, el poder y la posada actual del 
     *         mago
     */
    @Override
    public String toString() {
        return nombre + " (e:" + energia + ")(p: " + poder + ") en " +
                                                    posadaActual.getNombre();
    }
}