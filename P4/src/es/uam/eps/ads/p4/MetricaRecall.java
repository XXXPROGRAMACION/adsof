package es.uam.eps.ads.p4;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;

/**
 * Permite trabajar con métricas que contrastan los items recomendados con los
 * relevantes para cada usuario.
 */
public class MetricaRecall extends MetricaDeFichero {
    ModeloDatos modeloDatos;
    double notaMinima;

    /**
     * Instancia una métrica Recall dados su modelo de datos y nota mínima.
     * @param modeloDatos Modelo de datos a usar por la métrica
     * @param notaMinima Nota mínima a considerar por la métrica
     */
    public MetricaRecall(ModeloDatos modeloDatos, double notaMinima) {
        this.modeloDatos = modeloDatos;
        this.notaMinima = notaMinima;
    }

    /**
     * Evalua cuán buena es una recomendación basada en los items relevantes 
     * para el usuario.
     * @param rec Recomendación a evaluar
     * @param n Número de items recomendados a tener en cuenta a la hora de
     *          evaluar la recomendación
     * @return Número del 0 al 1, siendo el 0 la peor calificación de la 
     *         recomendación (no es para nada acertada) y 1 la mejor (es 
     *         totalmente acertada)
     * @throws UsuarioNoRelevante En caso de que no pueda evaluar la 
     *                            recomendación porque no tiene datos 
     *                            del usuario
     */
    @Override 
    public double evalua(Recomendacion rec, int n) throws UsuarioNoRelevante {
        Set<Long> itemsRecomendados = new HashSet<>();
        List<Tupla> recomendaciones = rec.getRecomendaciones();
        for (int i = 0; i < n; i++) {
            itemsRecomendados.add(recomendaciones.get(i).id);
        }

        Set<Long> itemsRelevantes = getItemsRelevantes(rec.getUsuario());
        if (itemsRelevantes.size() == 0) throw new UsuarioNoRelevante();

        int comunes = 0;

        for (long i : itemsRecomendados) {
            if (itemsRelevantes.contains(i)) comunes++;
        }

        return (double) comunes/itemsRelevantes.size();
    }

    /**
     * Devuelve los items relevantes para un usuario.
     * @param u Usuario a buscar
     * @return Set con los items relevantes para el usuario
     */
    @Override
    public Set<Long> getItemsRelevantes(long u) {
        Set<Long> itemsRelevantes = new HashSet<>();

        Map<Long, Double> preferencias = modeloDatos.getPreferenciasUsuario(u);
        //System.out.println(u + " - " + preferencias.size());
        for (long i : preferencias.keySet()) {
            if (preferencias.get(i) >= notaMinima) {
                itemsRelevantes.add(i);
            }
        }

        return itemsRelevantes;
    }
}