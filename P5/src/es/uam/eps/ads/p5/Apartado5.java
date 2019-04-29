package es.uam.eps.ads.p5;

import java.util.List;
import java.util.Random;

public class Apartado5 {

    public static void main(String[] args) {
        try {
            System.out.println("Simulador:");
            Simulator s = new Simulator(10, 10);

            IAgentWithState outer = new AgentWithState("outer", "idle", "active"); // dos estados: idle y active
            
            outer.state("idle").toState("active", agent -> agent.getCell().size() > 5);
            outer.state("active").toState("idle", agent -> agent.getCell().size() <= 5);
            
            outer.state("active").addBehaviour(agent -> {
                List<Cell> neighbours = s.getNeighboursAt(agent.getCell());
                Cell destination = neighbours.get(new Random().nextInt(neighbours.size()));
                agent.moveTo(destination);
                return true;
            });

            System.out.println(" -> Se anaden 100 agentes outer en (5, 5)");
            s.create(outer, 100, 5, 5);

            s.run(60);
        } catch (IllegalPositionException e) {
            e.printStackTrace();
        }
    }
}