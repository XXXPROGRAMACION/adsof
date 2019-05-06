package es.uam.eps.ads.p5.pruebas;

import es.uam.eps.ads.p5.matriz.*;
import es.uam.eps.ads.p5.simulador.*;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Esta clase permite probar las clases desarrolladas en el apartado 4 de la
 * práctica.
 * @author Alejandro Pascual y Victor Yrazusta
 */
public class Apartado4 {

    /**
     * Realiza una simulación para probar la funcionalidad de las clases 
     * desarrolladas en el cuarto apartado de la práctica.
     * @param args No usado
     */
    public static void main(String[] args) {
        try {
            Random r = new Random();

            System.out.println("Simulador:");
            Simulator s = new Simulator(10, 10);

            IAgent random = new Agent("random");
            IAgent outer = new Agent("outer");

            System.out.println(" -> Se anaden los comportamientos");
            random.addBehaviour(agent -> {
                try {                   
                    List<Cell> neighbours = s.getNeighboursAt(agent.cell());
                    Cell destination = neighbours.get(r.nextInt(
                                                      neighbours.size()));
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
                                    filter(c -> c.size() == minAgents).
                                    collect(Collectors.toList());
                    Cell destination = destinations.get(r.nextInt(
                                                        destinations.size()));
                    agent.moveTo(destination);
                    return true;
                } catch (IllegalPositionException e) {
                    e.printStackTrace();
                    return false;
                }
            });

            System.out.println(" -> Se anaden 100 agentes random en (5, 5)");
            s.create(random, 100, 5, 5);
            System.out.println(" -> Se anaden 100 agentes outer en (7, 7)");
            s.create(outer, 100, 7, 7);

            s.run(60);
        } catch (IllegalPositionException e) {
            e.printStackTrace();
        }
    }
}