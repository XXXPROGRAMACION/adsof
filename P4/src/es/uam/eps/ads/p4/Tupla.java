package es.uam.eps.ads.p4;

/**
 * Esta clase funciona como una estructura de datos para almacenar una pareja de
 * id y puntución. Además permite comparar unas parejas con otras en base a sus
 * respectivas puntuaciones.
 */
public class Tupla implements Comparable<Tupla> {
    public long id;
    public double puntuacion;
    
    /**
     * Instancia una tupla dada la pareja id-puntuación.
     * @param id Id de la tupla
     * @param puntuacion Puntuación de la tupla
     */
    public Tupla(long id, double puntuacion) {
        this.id = id;
        this.puntuacion = puntuacion;
    }

    /**
     * Compara otra tupla con esta en base a sus respectivas puntuaciones.
     * @param tupla Tupla a comparar con esta instancia
     */
    @Override
    public int compareTo(Tupla tupla) {
        if (puntuacion < tupla.puntuacion) {
            return 1;
        } else if (puntuacion > tupla.puntuacion) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * Construye una cadena de caracteres con la información de la tupla.
     * @return Cadena de caracteres con la información de la tupla.
     */
    @Override
    public String toString() {
        return "Tupla [elemento=" + id + ", valor=" + puntuacion + "]";
    }
}