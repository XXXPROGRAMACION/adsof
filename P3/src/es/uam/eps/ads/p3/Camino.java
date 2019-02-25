package es.uam.eps.ads.p3;

import java.util.Objects;

/**
 * <p>Esta clase permite trabajar con caminos.</p>
 * 
 * @author <p>Alejandro Pascual (alejandro.pascualp@estudiante.uam.es)<br>
 *         Víctor Yrazusta (victor.yrazusta@estudiante.uam.es)</p>
 */
public class Camino {
    private static int costeAcumulado;

    private Posada origen;
    private Posada destino;
    private int coste;

    /**
     * Inicializa un camino dadas sus características.
     * @param origen Posada de la que parte el camino
     * @param destino Posada a la que llega el camino
     * @param coste Coste energético de recorrer el camino
     */
    public Camino(Posada origen, Posada destino, int coste) {
        this.origen = origen;
        this.destino = destino;
        if (coste >= 1) {
            this.coste = coste;
        } else {
            this.coste = 1;
        }
        costeAcumulado += this.coste;
    }
    
    /**
     * Modifica el destino y el coste del camino
     * @param destino Nueva posada a la que llega el camino
     * @param coste Nuevo coste enérgetico de recorrer el camino
     */
    public void cambiarDestino(Posada destino, int coste) {
        this.destino = destino;
        costeAcumulado -= this.coste;
        if (coste >= 1) {
            this.coste = coste;
        } else {
            this.coste = 1;
        }
        costeAcumulado += this.coste;
    }

    /**
     * Devuelve el coste acumulado.
     * @return Coste acumulado de todas las instancias del camino
     */
    public static int getCosteAcumulado() {
        return costeAcumulado;
    }

    /**
     * Devuelve el origen.
     * @return Posada de la que parte el camino
     */
    public Posada getOrigen() {
        return origen;
    }

    /**
     * Devuelve el destino.
     * @return Posada a la que llega el camino
     */
    public Posada getDestino() {
        return destino;
    }

    /**
     * Devuelve el coste.
     * @return Coste energético de recorrer el camino
     */
    public int getCoste() {
        return coste;
    }

    /**
     * Devuelve el coste especial.
     * @return Coste especial de recorrer el camino, 0 en este caso
     */
    public int getCosteEspecial() {
        return 0;
    }

    /**
     * Devuelve el coste real.
     * @return Coste real de recorrer el camino, suma del coste y el coste 
     *         especial
     */
    public int getCosteReal() {
        return coste+getCosteEspecial();
    }

    /**
     * Devuelve en un String la información de la clase.
     * @return String indicando el origen, el coste y el destino
     */
    public String toString() {
        return "(" + origen + "--" + coste + "-->" + destino + ")";
    }

    public boolean equals(Camino camino) {
        return Objects.equals(camino.origen, origen)
               && Objects.equals(camino.destino, destino) 
               && camino.coste == coste;
    } 
}