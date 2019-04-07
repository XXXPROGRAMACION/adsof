package es.uam.eps.ads.p4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.List;

public class RecomendadorVecinos extends RecomendadorSerializable 
                                 implements Similitud {
    private ModeloDatos modeloDatos;
    private final int k;
    private Map<Long, List<Tupla>> relaciones = new HashMap<>();

    public RecomendadorVecinos(ModeloDatos modeloDatos, int k) {
        this.modeloDatos = modeloDatos;
        if (k > 0) this.k = k;
        else this.k = 5;
    }

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