package es.uam.eps.ads.p4;

import java.util.Set;

public interface Metrica {
    public double evalua(Recomendacion rec, int n) throws UsuarioNoRelevante;
    public Set<Long> getItemsRelevantes(long u);
    public double evaluaFicheroRecomendaciones(String ruta, int n);
}