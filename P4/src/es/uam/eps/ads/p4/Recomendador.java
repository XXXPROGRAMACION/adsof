package es.uam.eps.ads.p4;

public interface Recomendador {
    public Recomendacion recomienda(Long u, int longitudRecomendacion)
    throws RecomendacionInvalida;
}