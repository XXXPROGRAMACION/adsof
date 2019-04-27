package es.uam.eps.ads.p5;

import java.util.List;
import java.util.Random;

public class Apartado4 {

    public static void main(String[] args) {
        try {
            System.out.println("Simulador:");
            Simulator s = new Simulator(10, 10);

            Agent random = new Agent("random");
            Agent outer = new Agent("outer");

            System.out.println(" -> Se añaden los comportamientos...");
            random.addBehaviour(agent -> { 
                List<Cell> neighbours = agent.cell().neighbours();
                Cell destination = neighbours.get(new Random().nextInt(neighbours.size()));
                agent.moveTo(destination);
                return true;
            });

            outer.addBehaviour(agent -> agent.cell().getElement().size() > 5,
                agent -> {
                    List<Cell> neighbours = agent.cell().neighbours();
                    Integer minAgents = neighbours.stream().
                                        mapToInt( c -> c.agents().size() ).
                                        min( ).getAsInt();
                    List<Cell> destinations = neighbours.stream().
                                        filter( c -> c.agents().size() == minAgents ).
                                        collect(Collectors.toList());                    
                    Cell destination = destinations.get(new Random().nextInt(destinations.size()));
                    agent.moveTo(destination);
                    return true;
                }
            );

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