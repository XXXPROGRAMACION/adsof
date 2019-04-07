package es.uam.eps.ads.p4;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;

public class MetricaPrecision implements Metrica {
    ModeloDatos modeloDatos;
    double notaMinima;

    public MetricaPrecision(ModeloDatos modeloDatos, double notaMinima) {
        this.modeloDatos = modeloDatos;
        this.notaMinima = notaMinima;
    }

    @Override 
    public double evalua(Recomendacion rec, int n) throws UsuarioNoRelevante {
        Set<Long> itemsRecomendados = new HashSet<>();
        List<Tupla> recomendaciones = rec.getRecomendaciones();
        for (int i = 0; i < n; i++) {
            itemsRecomendados.add(recomendaciones.get(i).id);
        }

        Set<Long> itemsRelevantes = getItemsRelevantes(rec.getUsuario());

        if (itemsRelevantes == null) {
            throw new UsuarioNoRelevante();
        }

        int comunes = 0;

        for (long i : itemsRecomendados) {
            if (itemsRelevantes.contains(i)) {
                comunes++;
            }
        }

        return (double) comunes/n;
    }

    @Override
    public Set<Long> getItemsRelevantes(long u) {
        Set<Long> itemsRelevantes = new HashSet<>();

        Map<Long, Double> preferencias = modeloDatos.getPreferenciasUsuario(u);
        for (long i : preferencias.keySet()) {
            if (preferencias.get(i) >= notaMinima) {
                itemsRelevantes.add(i);
            }
        }

        return itemsRelevantes;
    }
}