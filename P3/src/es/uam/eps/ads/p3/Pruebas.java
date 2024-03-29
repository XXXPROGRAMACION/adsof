package es.uam.eps.ads.p3;

public class Pruebas {
    
    public static void main(String[] args) {
        System.out.println("Prueba 1:");
        prueba1();
        System.out.println("\nPrueba 2:");
        prueba2();
        System.out.println("\nPrueba 3:");
        prueba3();
        System.out.println("\nPrueba 4:");
        prueba4();
    }

    // El explorador es capaz de moverse a ambas posadas. Una a una.
    private static void prueba1() {
        Posada posada1 = new Posada("Posada 1");
        Posada posada2 = new Posada("Posada 2", 10);
        Posada posada3 = new Posada("Posada 3", 0);

        posada1.addCamino(new Camino(posada1, posada2, 20));
        posada2.addCamino(new Camino(posada2, posada3, 20));      

        Explorador explorador1 = new Explorador("Explorador 1", 30, posada1);
        System.out.println("\t" + explorador1);

        intentaRecorrer(explorador1, posada2);
        
        System.out.println("\t" + explorador1);

        intentaRecorrer(explorador1, posada3);

        System.out.println("\t" + explorador1);
    }

    // El explorador es capaz de moverse a la primera posada, pero no a la 
    // segunda. Una a una.
    private static void prueba2() {
        Posada posada1 = new Posada("Posada 1");
        Posada posada2 = new Posada("Posada 2", 10);
        Posada posada3 = new Posada("Posada 3", 0);

        posada1.addCamino(new Camino(posada1, posada2, 20));
        posada2.addCamino(new Camino(posada2, posada3, 21));      

        Explorador explorador1 = new Explorador("Explorador 1", 30, posada1);
        System.out.println("\t" + explorador1);

        intentaRecorrer(explorador1, posada2);

        System.out.println("\t" + explorador1);

        intentaRecorrer(explorador1, posada3);

        System.out.println("\t" + explorador1);
    }

    // El explorador es capaz de recorrer toda la secuencia de posadas.
    private static void prueba3() {
        Posada posada1 = new Posada("Posada 1");
        Posada posada2 = new Posada("Posada 2", 10);
        Posada posada3 = new Posada("Posada 3", 10);
        Posada posada4 = new Posada("Posada 4", 10);
        Posada posada5 = new Posada("Posada 5", 10);
        Posada posada6 = new Posada("Posada 6", 0);

        Explorador explorador1 = new Explorador("Explorador 1", 10, posada1);

        posada1.addCamino(new Camino(posada1, posada2, 10));
        posada2.addCamino(new Camino(posada2, posada3, 10));
        posada3.addCamino(new Camino(posada3, posada4, 10));
        posada4.addCamino(new Camino(posada4, posada5, 10));
        posada5.addCamino(new Camino(posada5, posada6, 10));

        System.out.println("\t" + explorador1);

        intentaRecorrer(explorador1, posada2, posada3, posada4, posada5, 
                        posada6);

        System.out.println("\t" + explorador1);
    }

    // El explorador es capaz de recorrer parte de la secuencia de posadas.
    private static void prueba4() {
        Posada posada1 = new Posada("Posada 1", 10);
        Posada posada2 = new Posada("Posada 2", 10);
        Posada posada3 = new Posada("Posada 3", 10);
        Posada posada4 = new Posada("Posada 4", 10);
        Posada posada5 = new Posada("Posada 5", 10);
        Posada posada6 = new Posada("Posada 6", 10);

        Explorador explorador1 = new Explorador("Explorador 1", 10, posada1);

        posada1.addCamino(new Camino(posada1, posada2, 10));
        posada2.addCamino(new Camino(posada2, posada3, 200));
        posada2.addCamino(new Camino(posada2, posada4, 10));
        posada3.addCamino(new Camino(posada3, posada4, 10));
        posada4.addCamino(new Camino(posada4, posada5, 200));
        posada5.addCamino(new Camino(posada5, posada6, 10));

        System.out.println("\t" + explorador1);

        intentaRecorrer(explorador1, posada2, posada3, posada4, posada5, 
                        posada6);

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

    // Función auxiliar para imprimir si se puede recorrer una serie de posadas
    private static void intentaRecorrer(Explorador explorador, 
                                         Posada ... posadas) {
        if (explorador.recorre(posadas)) {
            System.out.println("\tSe ha podido recorrer toda la secuencia de"
                                + " posadas");
        } else {
            System.out.println("\tNo se ha podido recorrer toda la secuencia de"
                                + " posadas");
        }
    }
}