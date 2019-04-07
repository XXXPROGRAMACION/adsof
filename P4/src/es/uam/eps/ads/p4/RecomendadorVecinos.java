package es.uam.eps.ads.p4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.List;

/**
 * Esta clase extiende la clase recomendador serializable. Define el
 * funcionamiento de un recomendador por sistema de vecinos.
 */
public class RecomendadorVecinos extends RecomendadorSerializable 
                                 implements Similitud {
    private ModeloDatos modeloDatos;
    private final int k;
    private Map<Long, List<Tupla>> relaciones = new HashMap<>();

    /**
     * Instacia un recomendador por vecinos dadas sus características.
     * @param modeloDatos Modelo de datos del recomendador
     * @param k Número de usuarios que se utilizaran como vecinos para el 
     *          cálculo de la recomendación del usuario
     */
    public RecomendadorVecinos(ModeloDatos modeloDatos, int k) {
        this.modeloDatos = modeloDatos;
        if (k > 0) this.k = k;
        else this.k = 5;
    }

    /**
     * Recomienda items para el usuario indicado hasta el máximo especificado.
     * Sus recomendaciones se basan en los usuarios que se consideran sus
     * "vecinos". Por lo tanto el proceso se divide en dos partes: calcular los
     * vecinos del usuario y generar la recomendación del tamaño indicado.
     * La primera parte de este proceso, al ser constante, la calculamos solo
     * la primera vez que se pide una recomendación de dicho usuario.
     * @param u Usuario para el que se debe realizar la recomendación
     * @param longitudRecomendacion Tamaño máximo de la recomendación
     * @return Recomendación generada para el usuario indicado.
     */
    @Override
    public Recomendacion recomienda(long u, int longitudRecomendacion)
    throws RecomendacionInvalida {
        if (!modeloDatos.getCorrecto() ||
            !modeloDatos.getUsuariosUnicos().contains(u) || 
            longitudRecomendacion <= 0) throw new RecomendacionInvalida();

        if (!relaciones.containsKey(u)) {
            List<Tupla> similitudes = new ArrayList<>();
            for (long v : modeloDatos.getUsuariosUnicos()) {
                if (u == v) continue;
                similitudes.add(new Tupla(v, sim(u, v)));
            }
            Collections.sort(similitudes);
            relaciones.put(u, 
                similitudes.stream().limit(k).collect(Collectors.toList()));
        }
        
        List<Tupla> items = new ArrayList<>();
        List<Tupla> similitudes = relaciones.get(u);

        Map<Long, Double> preferenciasU = 
                          modeloDatos.getPreferenciasUsuario(u);
        for (long o : modeloDatos.getItemsUnicos()) {
            if (preferenciasU.containsKey(o)) continue;
            double puntuacionTotal = 0;
            for (Tupla t : similitudes) {
                Map<Long, Double> preferenciasV =
                        modeloDatos.getPreferenciasUsuario(t.id);
                Double valoracion = preferenciasV.get(o);
                if (valoracion != null) {
                    puntuacionTotal += valoracion*t.puntuacion;
                }
            }
            items.add(new Tupla(o, puntuacionTotal));
        }

        Collections.sort(items);
        items = items.stream().limit(longitudRecomendacion)
                .collect(Collectors.toList());
        return new Recomendacion(u, items);        
    }

    /**
     * Determina el grado de similitud entre dos usuarios, para poder encontrar 
     * a los "vecinos" de cada usuario. Este valor se calcula en base a la 
     * similitud de sus respectivas preferencias, creciendo cuando ambos valoran
     * un mismo objeto con calificaciones cercanas.
     * @param u1 Primer usuario para el que calcular la similitud
     * @param u2 Segundo usuario para el que calcular la similitud
     * @return Grado de similitud entre los dos usuarios.
     */
    @Override
    public double sim(long u1, long u2) {
        if (!modeloDatos.getCorrecto()) return -1;

        Map<Long, Double> prefU1 = modeloDatos.getPreferenciasUsuario(u1);
        Map<Long, Double> prefU2 = modeloDatos.getPreferenciasUsuario(u2);

        double numerador = 0;
        for (Map.Entry<Long, Double> pU1 : prefU1.entrySet()) {
            Double puntuacionPU2 = prefU2.get(pU1.getKey());
            if (puntuacionPU2 != null) {
                numerador += pU1.getValue()*puntuacionPU2;
            }
        }

        double cuadradosU1 = 0;
        for (Map.Entry<Long, Double> pU1 : prefU1.entrySet()) {
            cuadradosU1 += pU1.getValue()*pU1.getValue();
        }

        double cuadradosU2 = 0;
        for (Map.Entry<Long, Double> pU2 : prefU2.entrySet()) {
            cuadradosU2 += pU2.getValue()*pU2.getValue();
        }

        return numerador/Math.sqrt(cuadradosU1*cuadradosU2);
    }
}