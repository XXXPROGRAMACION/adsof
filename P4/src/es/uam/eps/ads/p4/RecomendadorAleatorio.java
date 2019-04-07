package es.uam.eps.ads.p4;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RecomendadorAleatorio implements Recomendador {
    ModeloDatos modeloDatos;
    Random random;

    public RecomendadorAleatorio(ModeloDatos modeloDatos) {
        this.modeloDatos = modeloDatos;
        random = new Random(System.currentTimeMillis());
    }

    @Override
    public Recomendacion recomienda(long u, int longitudRecomendacion) {
        List<Tupla> items = new ArrayList<>(modeloDatos.getItemsUnicos().size());
        for (long i : modeloDatos.getItemsUnicos()) {
            items.add(new Tupla(i,1+4*random.nextDouble()));
        }
        Collections.sort(items);
        return new Recomendacion(u, items.stream()
        .limit(longitudRecomendacion).collect(Collectors.toList()));
    }
}