package es.uam.eps.ads.p4;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/**
 * Esta clase extiende la clase recomendador serializable. Define el
 * funcionamiento de un recomendador por popularidad.
 */
public class RecomendadorPopularidad extends RecomendadorSerializable {
    private ModeloDatos modeloDatos;
    private List<Tupla> items;

    /**
     * Instancia un recomendador por popularidad dado su modelo de datos.
     * @param modeloDatos Modelo de datos del recomendador
     */
    public RecomendadorPopularidad(ModeloDatos modeloDatos) {
        items = new ArrayList<>(modeloDatos.getItemsUnicos().size());
        for (long item : modeloDatos.getItemsUnicos()) {
            Map<Long, Double> preferenciasItem = 
                modeloDatos.getPreferenciasItem(item);
            items.add(new Tupla(item, preferenciasItem.size()));
        }
        Collections.sort(items);
        this.modeloDatos = modeloDatos;
    }

    /**
     * Recomienda items para el usuario indicado hasta el máximo especificado.
     * Sus recomendaciones se basan en el número de veces que un elemento ha
     * sido comprado por el resto de usuarios.
     * @param u Usuario para el que se debe realizar la recomendación
     * @param longitudRecomendacion Tamaño máximo de la recomendación
     * @return Recomendación generada para el usuario indicado.
     */
    @Override
    public Recomendacion recomienda(long u, int longitudRecomendacion)
    throws RecomendacionInvalida {
        Map<Long, Double> preferenciasU = modeloDatos.getPreferenciasUsuario(u);

        List<Tupla> recomendaciones = new ArrayList<>();
        for (Tupla item : items) {
            if (preferenciasU.containsKey(item.id)) continue;
            recomendaciones.add(item);
            if (recomendaciones.size() == longitudRecomendacion) break;
        }
        return new Recomendacion(u, recomendaciones);
    }
}