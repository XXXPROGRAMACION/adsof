package es.uam.eps.ads.p5;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Apartado4 {

    public static void main(String[] args) {
        try {
            System.out.println("Simulador:");
            Simulator s = new Simulator(10, 10);

            IAgent random = new Agent("random");
            IAgent outer = new Agent("outer");

            System.out.println(" -> Se anaden los comportamientos");
            random.addBehaviour(agent -> {
                try {                   
                    List<Cell> neighbours = s.getNeighboursAt(agent.cell());
                    Cell destination = neighbours.get(new Random().nextInt(neighbours.size()));
                    agent.moveTo(destination);
                    return true;
                } catch (IllegalPositionException e) {
                    e.printStackTrace();
                    return false;
                }
            });

            outer.addBehaviour(agent -> agent.cell().size() > 5, agent -> {
                try {
                    List<Cell> neighbours = s.getNeighboursAt(agent.cell());
                    Integer minAgents = neighbours.stream().
                                    mapToInt(c -> c.size()).
                                    min().getAsInt();
                    List<Cell> destinations = neighbours.stream().
                                    filter(c -> c.agents().size() == minAgents).
                                    collect(Collectors.toList());
                    Cell destination = destinations.get(new Random().nextInt(destinations.size()));
                    agent.moveTo(destination);
                    return true;
                } catch (IllegalPositionException e) {
                    e.printStackTrace();
                    return false;
                }
            });

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