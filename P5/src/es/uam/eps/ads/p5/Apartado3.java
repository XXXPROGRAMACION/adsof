package es.uam.eps.ads.p5;

public class Apartado3 {

    public static void main(String[] args) {
        try {
            System.out.println("Simulador básico:");
            BasicSimulator s = new BasicSimulator(10, 10);

            IBasicAgent random = new BasicAgent("random");
            IBasicAgent outer = new BasicAgent("outer");

            System.out.println(" -> Se anaden 10 agentes en (5, 5)");
            s.create(random, 10, 5, 5);
            System.out.println(" -> Se anaden 10 agentes en (7, 7)");
            s.create(outer, 10, 7, 7);

            s.run(2);
        } catch (IllegalPositionException e) {
            e.printStackTrace();
        }
    }
}