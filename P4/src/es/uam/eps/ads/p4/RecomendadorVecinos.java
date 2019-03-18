package es.uam.eps.ads.p4;

import java.util.HashMap;
import java.util.Map;

public class RecomendadorVecinos implements Recomendador, Similitud {
    ModeloDatos modeloDatos = new ModeloDatosHash();

    @Override
    public Recomendacion recomienda(Long u, int longitudRecomendacion)
    throws RecomendacionInvalida {

    }

    @Override
    public double sim(long u1, long u2) {
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