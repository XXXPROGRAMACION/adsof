package es.uam.eps.ads.p4;

import java.util.Objects;

/**
 * Implementación del apartado opcional.
 */
public class ApartadoOpcional {
    public static final int notaMinima = 2;
    public static final int k = 5;
    public static final int numVecinos = 100;
    public static final int tamRecomendacion = 5;
    public static final String ruta = "recomendacionesVecinos.txt";

    /**
     * Ejecución del programa de prueba del apartado opcional.
     * @param args Argumentos con las rutas de los ficheros a utilizar
     */
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Número de argumentos inválido.");
            System.out.println("Utilización: ApartadoOpcional"
                               + "training.txt test.txt s/n");
            return;
        }

        if (Objects.equals(args[2], "s")) {
            ModeloDatos modeloDatosTraining = new ModeloDatosHash();
            modeloDatosTraining.leeFicheroPreferencias(args[0]);
            if (!modeloDatosTraining.getCorrecto()) {
                System.out.println("Error leyendo el fichero de " + 
                                   "entrenamiento.");
            }
            Recomendador recomendadorVecinos = 
                       new RecomendadorVecinos(modeloDatosTraining, numVecinos);

            // Calculo de recomendaciones
            recomendadorVecinos.crearFicheroRecomendaciones(ruta, 
                                    modeloDatosTraining.getUsuariosUnicos(), 
                                    tamRecomendacion);
        }

        ModeloDatos modeloDatosTest = new ModeloDatosHash();
        modeloDatosTest.leeFicheroPreferencias(args[1]);
        if (!modeloDatosTest.getCorrecto()) {
            System.out.println("Error leyendo el fichero de testeo.");
        }
        Metrica metricaPrecision = new MetricaPrecision(modeloDatosTest,
                                                        notaMinima);
        Metrica metricaRecall = new MetricaRecall(modeloDatosTest, notaMinima);

        // Evaluación métricas
        System.out.println("\nPrecision del recomendador de vecinos:");
        
        double precision = metricaPrecision.evaluaFicheroRecomendaciones(ruta, 
                                                              tamRecomendacion);
        System.out.println("\t-Segun la metrica de precision: " + precision);
        
        precision = metricaRecall.evaluaFicheroRecomendaciones(ruta, 
                                                              tamRecomendacion);
        System.out.println("\t-Segun la metrica Recall: " + precision + "\n");
    }
}