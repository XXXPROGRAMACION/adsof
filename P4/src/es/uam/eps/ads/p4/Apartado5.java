package es.uam.eps.ads.p4;

public class Apartado5 {
    public static final int notaMinima = 2;
    public static final int k = 5;
    public static final int numVecinos = 100;
    public static final int tamRecomendacion = 5;

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Número de argumentos inválido.");
            System.out.println("Utilización: Apartado5 training.txt test.txt");
            return;
        }

        ModeloDatos modeloDatosTraining = new ModeloDatosHash();
        modeloDatosTraining.leeFicheroPreferencias(args[0]);
        if (!modeloDatosTraining.getCorrecto()) {
            System.out.println("Error leyendo el fichero de entrenamiento.");
        }
        Recomendador recomendadorVecinos = new RecomendadorVecinos(modeloDatosTraining, numVecinos);
        Recomendador recomendadorAleatorio = new RecomendadorAleatorio(modeloDatosTraining);
        Recomendador recomendadorPopularidad = new RecomendadorPopularidad(modeloDatosTraining);

        ModeloDatos modeloDatosTest = new ModeloDatosHash();
        modeloDatosTest.leeFicheroPreferencias(args[1]);
        if (!modeloDatosTest.getCorrecto()) {
            System.out.println("Error leyendo el fichero de testeo.");
        }
        Metrica metricaPrecision = new MetricaPrecision(modeloDatosTest, notaMinima);
        Metrica metricaRecall = new MetricaRecall(modeloDatosTest, notaMinima);

        //Recomendador vecinos
        System.out.println("\nPrecision del recomendador de vecinos:");
        
        double numUsuarios = 0;
        double total = 0;

        for (long u : modeloDatosTraining.getUsuariosUnicos()) {
            try {
                total += metricaPrecision.evalua(recomendadorVecinos.recomienda(u, tamRecomendacion), tamRecomendacion);
                numUsuarios++;
            } catch (Exception e) {
                continue;
            }
        }
        double precision = total/numUsuarios;

        System.out.println("\t-Segun la metrica de precision: " + precision);

        numUsuarios = 0;
        total = 0;

        for (long u : modeloDatosTraining.getUsuariosUnicos()) {
            try {
                total += metricaRecall.evalua(recomendadorVecinos.recomienda(u, tamRecomendacion), tamRecomendacion);
                numUsuarios++;
            } catch (Exception e) {
                continue;
            }
        }
        precision = total/numUsuarios;

        System.out.println("\t-Segun la metrica Recall: " + precision + "\n");
            
        //Recomendador aleatorio
        System.out.println("Precision del recomendador aleatorio:");
        numUsuarios = 0;
        total = 0;

        for (long u : modeloDatosTraining.getUsuariosUnicos()) {
            try {
                total += metricaPrecision.evalua(recomendadorAleatorio.recomienda(u, tamRecomendacion), tamRecomendacion);
                numUsuarios++;
            } catch (Exception e) {
                continue;
            }
        }
        precision = total/numUsuarios;

        System.out.println("\t-Segun la metrica de precision: " + precision);

        numUsuarios = 0;
        total = 0;

        for (long u : modeloDatosTraining.getUsuariosUnicos()) {
            try {
                total += metricaRecall.evalua(recomendadorAleatorio.recomienda(u, tamRecomendacion), tamRecomendacion);
                numUsuarios++;
            } catch (Exception e) {
                continue;
            }
        }
        precision = total/numUsuarios;

        System.out.println("\t-Segun la metrica Recall: " + precision + "\n");

        //Recomendador de popularidad
        System.out.println("Precision del recomendador de popularidad:");
        numUsuarios = 0;
        total = 0;

        for (long u : modeloDatosTraining.getUsuariosUnicos()) {
            try {
                total += metricaPrecision.evalua(recomendadorPopularidad.recomienda(u, tamRecomendacion), tamRecomendacion);
                numUsuarios++;
            } catch (Exception e) {
                continue;
            }
        }
        precision = total/numUsuarios;

        System.out.println("\t-Segun la metrica de precision: " + precision);

        numUsuarios = 0;
        total = 0;

        for (long u : modeloDatosTraining.getUsuariosUnicos()) {
            try {
                total += metricaRecall.evalua(recomendadorPopularidad.recomienda(u, tamRecomendacion), tamRecomendacion);
                numUsuarios++;
            } catch (Exception e) {
                continue;
            }
        }
        precision = total/numUsuarios;
        
        System.out.println("\t-Segun la metrica Recall: " + precision + "\n");;
    }
}