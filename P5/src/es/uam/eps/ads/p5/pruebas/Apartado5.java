package es.uam.eps.ads.p5.pruebas;

import es.uam.eps.ads.p5.matriz.*;
import es.uam.eps.ads.p5.simulador.*;

import java.util.List;
import java.util.Random;

/**
 * Esta clase permite probar las clases desarrolladas en el apartado 5 de la
 * práctica.
 * @author Alejandro Pascual y Victor Yrazusta
 */
public class Apartado5 {

    /**
     * Realiza una simulación para probar la funcionalidad de las clases 
     * desarrolladas en el quinto apartado de la práctica.
     * @param args No usado
     */
    public static void main(String[] args) {
        try {
            Random r = new Random();

            System.out.println("Simulador:");
            Simulator s = new Simulator(10, 10);

            IAgentWithState outer = new AgentWithState("outer",
                                "idle", "active"); // dos estados: idle y active
            
            outer.state("idle").toState("active", agent ->
                                        agent.cell().size() > 5);
            outer.state("active").toState("idle", agent ->
                                          agent.cell().size() <= 5);
            
            outer.state("active").addBehaviour(agent -> {
                try {
                    List<Cell> neighbours = s.getNeighboursAt(agent.cell());
                    Cell destination = neighbours.get(
                                                r.nextInt(neighbours.size()));
                    agent.moveTo(destination);
                    return true;
                } catch (IllegalPositionException e) {
                    e.printStackTrace();;
                    return false;
                }
            });

            System.out.println(" -> Se anaden 100 agentes outer en (5, 5)");
            s.create(outer, 100, 5, 5);

            s.run(60);
        } catch (IllegalPositionException e) {
            e.printStackTrace();
        }
    }
}