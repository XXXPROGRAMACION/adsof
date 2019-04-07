package es.uam.eps.ads.p4;

/**
 * Permite comprobar el correcto funcionamiento del modelo de datos y el
 * recomendador de vecinos.
 */
public class Prueba {

    public static void main(String[] args) {
        ModeloDatos modeloDatos = new ModeloDatosHash();
        modeloDatos.leeFicheroPreferencias("PruebaTraining.txt");
        RecomendadorVecinos recomendadorVecinos = 
                        new RecomendadorVecinos(modeloDatos, 2);

        System.out.println("175 y 190: " + recomendadorVecinos.sim(175, 190));
        System.out.println("175 y 267: " + recomendadorVecinos.sim(175, 267));
        System.out.println("190 y 267: " + recomendadorVecinos.sim(190, 267));

        try {
            Recomendacion r = recomendadorVecinos.recomienda(190, 3);
            System.out.println(r);
        } catch (RecomendacionInvalida e) {
            System.out.println("Recomendación inválida");
        }        
    }
}