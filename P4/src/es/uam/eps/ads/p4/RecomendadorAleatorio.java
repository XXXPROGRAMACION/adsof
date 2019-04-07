package es.uam.eps.ads.p4;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Esta clase extiende la clase recomendador serializable. Define el
 * funcionamiento de un recomendador aleatorio.
 */
public class RecomendadorAleatorio extends RecomendadorSerializable {
    private ModeloDatos modeloDatos;
    private Random random;

    /**
     * Instancia un recomendador aleatorio dado su modelo de datos.
     * @param modeloDatos Modelo de datos del recomendador
     */
    public RecomendadorAleatorio(ModeloDatos modeloDatos) {
        this.modeloDatos = modeloDatos;
        random = new Random(System.currentTimeMillis());
    }

    /**
     * Recomienda items para el usuario indicado hasta el máximo especificado.
     * Sus recomendaciones son completamente aleatorias y no se basan en el 
     * modelo de datos.
     * @param u Usuario para el que se debe realizar la recomendación
     * @param longitudRecomendacion Tamaño máximo de la recomendación
     * @return Recomendación generada para el usuario indicado.
     */
    @Override
    public Recomendacion recomienda(long u, int longitudRecomendacion) {
        Map<Long, Double> preferenciasU = modeloDatos.getPreferenciasUsuario(u);

        List<Tupla> items = new ArrayList<>(modeloDatos.getItemsUnicos().size());
        for (long i : modeloDatos.getItemsUnicos()) {
            if (preferenciasU.containsKey(i)) continue;
            items.add(new Tupla(i,1+4*random.nextDouble()));
        }

        Collections.sort(items);
        return new Recomendacion(u, items.stream()
        .limit(longitudRecomendacion).collect(Collectors.toList()));
    }
}