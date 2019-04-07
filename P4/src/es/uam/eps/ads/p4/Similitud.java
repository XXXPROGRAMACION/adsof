package es.uam.eps.ads.p4;

/**
 * Esta interfaz especifica la función elemental de un calculador de similitud.
 */
public interface Similitud {

    /**
     * Determina el grado de similitud entre dos usuarios, para poder encontrar 
     * a los "vecinos" de cada usuario.
     * @param u1 Primer usuario para el que calcular la similitud
     * @param u2 Segundo usuario para el que calcular la similitud
     * @return Grado de similitud entre los dos usuarios.
     */
    public double sim(long u1, long u2);
}