package es.uam.eps.ads.p4;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class RecomendadorPopularidad implements Recomendador {
    private List<Tupla> items;

    public RecomendadorPopularidad(ModeloDatos modeloDatos) {
        items = new ArrayList<>(modeloDatos.getItemsUnicos().size());
        for (long item : modeloDatos.getItemsUnicos()) {
            Map<Long, Double> preferenciasItem = 
                modeloDatos.getPreferenciasItem(item);
            items.add(new Tupla(item, preferenciasItem.size()));
        }
        Collections.sort(items);
    }

    @Override
    public Recomendacion recomienda(long u, int longitudRecomendacion)
    throws RecomendacionInvalida {
        List<Tupla> recomendaciones = items.stream()
            .limit(longitudRecomendacion).collect(Collectors.toList());
        return new Recomendacion(u, recomendaciones);
    }
}