package es.uam.eps.ads.p4;

import java.util.Set;

public interface Recomendador {
    public Recomendacion recomienda(long u, int longitudRecomendacion)
    throws RecomendacionInvalida;

    public void crearFicheroRecomendaciones(String ruta, Set<Long> usuarios, 
                                            int longitudRecomendacion);
}