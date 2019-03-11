package es.uam.eps.ads.p3;

/**
 * <p>Esta clase permite trabajar con trampas, que heredan de Camino.</p>
 * 
 * @author <p>Alejandro Pascual (alejandro.pascualp@estudiante.uam.es)<br>
 *         Víctor Yrazusta (victor.yrazusta@estudiante.uam.es)</p>
 */
public class Trampa extends Camino {
    private float costeExtra;
    private float probabilidadRetorno;

    public Trampa(Posada origen, Posada destino, int coste, float costeExtra,
                  float probabilidadRetorno) {
        super(origen, destino, coste);
        this.costeExtra = costeExtra;
        this.probabilidadRetorno = probabilidadRetorno;
    }

    /**
     * Indica que el camino es una trampa
     * @return "true"
     */
    @Override 
    public boolean esTrampa() {
        return true;
    }

    /**
     * Devuelve el destino o el origen, en base a la probabilidad establecida.
     * @return El destino o el origen, en base a la probabilidad establecida
     */
    public Posada getDestino() {
        if (Math.random() < probabilidadRetorno) {
            return getOrigen();
        } else {
            return getDestino();
        }
    }

    /**
     * Devuelve el coste especial, producto del coste y el coste extra,
     * redondeado a un entero.
     * @return Coste especial
     */
    @Override    
    public int getCosteEspecial() {
        return Math.round(getCoste()*costeExtra);
    }
}