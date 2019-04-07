package es.uam.eps.ads.p4;

import java.util.Set;

/**
 * Esta interfaz especifica las funciones elementales de un recomendador.
 */
public interface Recomendador {
    public Recomendacion recomienda(long u, int longitudRecomendacion)
    throws RecomendacionInvalida;

    public void crearFicheroRecomendaciones(String ruta, Set<Long> usuarios, 
                                            int longitudRecomendacion);
}