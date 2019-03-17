package es.uam.eps.ads.p3;

public class PruebasMagos {
    
    public static void main(String[] args) {
        System.out.println("Prueba magos 1:");
        prueba1();
        System.out.println("\nPrueba magos 2:");
        prueba2();
        System.out.println("\nPrueba magos 3:");
        prueba3();
        System.out.println("\nPrueba magos 4:");
        prueba4();
    }

    // El explorador es capaz de moverse a ambas posadas. Una a una.
    private static void prueba1() {
        Posada posada1 = new Posada("Posada 1", 2, Luz.CLARA); 
        Posada posada2 = new Posada("Posada 2", 10, Luz.BLANCA);
        Posada posada3 = new Posada("Posada 3", 0, Luz.DIVINA);

        posada1.addCamino(new Camino(posada1, posada2, 20));
        posada2.addCamino(new Camino(posada2, posada3, 20));      

        Explorador explorador1 = new Hada("Hada 1", 30, posada1, 8);
        System.out.println("\t" + explorador1);

        intentaRecorrer(explorador1, posada2);
        
        System.out.println("\t" + explorador1);

        intentaRecorrer(explorador1, posada3);

        System.out.println("\t" + explorador1);
    }

    // El explorador es capaz de moverse a la primera posada, pero no a la 
    // segunda. Una a una.
    private static void prueba2() {
        Posada posada1 = new Posada("Posada 1", 2, Luz.CLARA);
        Posada posada2 = new Posada("Posada 2", 10, Luz.DIABOLICA);
        Posada posada3 = new Posada("Posada 3", 0, Luz.DIVINA);

        posada1.addCamino(new Camino(posada1, posada2, 20));
        posada2.addCamino(new Camino(posada2, posada3, 20));      

        Explorador explorador1 = new Hechicero("Hechicero 1", 30, posada1, 2);
        System.out.println("\t" + explorador1);

        intentaRecorrer(explorador1, posada2);

        System.out.println("\t" + explorador1);

        intentaRecorrer(explorador1, posada3);

        System.out.println("\t" + explorador1);
    }

    // El explorador es capaz de recorrer toda la secuencia de posadas.
    private static void prueba3() {
        Posada posada1 = new Posada("Posada 1", 2, Luz.CLARA);
        Posada posada2 = new Posada("Posada 2", 10, Luz.CLARA);
        Posada posada3 = new Posada("Posada 3", 10, Luz.CLARA);
        Posada posada4 = new Posada("Posada 4", 10, Luz.CLARA);
        Posada posada5 = new Posada("Posada 5", 10, Luz.CLARA);
        Posada posada6 = new Posada("Posada 6", 0, Luz.CLARA);

        Explorador explorador1 = new Hada("Hada 1", 10, posada1, 10);

        posada1.addCamino(new Camino(posada1, posada2, 10));
        posada2.addCamino(new Camino(posada2, posada3, 10));
        posada3.addCamino(new Camino(posada3, posada4, 10));
        posada4.addCamino(new Camino(posada4, posada5, 10));
        posada5.addCamino(new Camino(posada5, posada6, 10));

        System.out.println("\t" + explorador1);

        if (explorador1.recorre(posada2, posada3, posada4, posada5, posada6)) {
            System.out.println("\tSe ha podido recorrer toda la secuencia de"
                               + " posadas");
        } else {
            System.out.println("\tNo se ha podido recorrer toda la secuencia de"
                               + " posadas");
        }

        System.out.println("\t" + explorador1);
    }

    // El explorador es capaz de recorrer parte de la secuencia de posadas.
    private static void prueba4() {
        Posada posada1 = new Posada("Posada 1", 10, Luz.GRIS);
        Posada posada2 = new Posada("Posada 2", 10, Luz.GRIS);
        Posada posada3 = new Posada("Posada 3", 10, Luz.DIVINA);
        Posada posada4 = new Posada("Posada 4", 10, Luz.GRIS);
        Posada posada5 = new Posada("Posada 5", 10, Luz.DIVINA);
        Posada posada6 = new Posada("Posada 6", 10, Luz.GRIS);

        Explorador explorador1 = new Hechicero("Hechicero 1", 10, posada1, 2);

        posada1.addCamino(new Camino(posada1, posada2, 10));
        posada2.addCamino(new Camino(posada2, posada3, 200));
        posada2.addCamino(new Camino(posada2, posada4, 10));
        posada3.addCamino(new Camino(posada3, posada4, 10));
        posada4.addCamino(new Camino(posada4, posada5, 200));
        posada5.addCamino(new Camino(posada5, posada6, 10));

        System.out.println("\t" + explorador1);

        if (explorador1.recorre(posada2, posada3, posada4, posada5, posada6)) {
            System.out.println("\tSe ha podido recorrer toda la secuencia de"
                               + " posadas");
        } else {
            System.out.println("\tNo se ha podido recorrer toda la secuencia de"
                               + " posadas");
        }

        System.out.println("\t" + explorador1);
    }

    // Función auxiliar para imprimir si se puede ir a una posada o no.
    private static void intentaRecorrer(Explorador explorador, Posada posada) {
        if (explorador.recorre(posada)) {
            System.out.println("\tPuede ir a " + posada.getNombre());
        } else {
            System.out.println("\tNo puede ir a " + posada.getNombre());
        }
    }
}