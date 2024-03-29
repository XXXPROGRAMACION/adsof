package es.uam.eps.ads.p5.pruebas;

import es.uam.eps.ads.p5.matriz.*;
import es.uam.eps.ads.p5.simulador.*;

import java.util.List;
import java.util.Random;

/**
 * Esta clase permite probar parte las clases desarrolladas en el apartado 6 de 
 * la práctica, probando la funcionalidad mediante una simulación.
 * @author Alejandro Pascual y Victor Yrazusta
 */
public class Apartado6B {

    /**
     * Realiza una simulación para probar la funcionalidad de las clases 
     * desarrolladas en el sexto apartado de la práctica.
     * @param args No usado
     */
    public static void main(String[] args) {
        try {
            Random r = new Random();

            System.out.println("Simulador:");
            Simulator s = new Simulator(3, 3);

            IAgent ant = new Agent("ant");
            IAgent food = new Agent("food");
            
            ant.set("energy", 0);
            ant.set("food", 0);

            ant.addBehaviour(agent -> {
                try {                   
                    List<Cell> neighbours = s.getNeighboursAt(agent.cell());
                    Cell destination = neighbours.get(
                                            r.nextInt(neighbours.size()));
                    agent.moveTo(destination);
                    return true;
                } catch (IllegalPositionException e) {
                    e.printStackTrace();
                    return false;
                }
            });

            ant.addInteraction(
                (self, agent) -> agent.name().equals("food") &&
                                 agent.get("amount") > 0,
                (self, agent) -> {
                    System.out.println("Comiendo (encuentra " + 
                                       agent.get("amount")+")");

                    self.increase("energy", 10);
                    self.increase("food", 1);
                    agent.increase("amount", -1);

                    if (agent.get("amount") == 0) {
                        System.out.println("Alimento agotado");
                    }

                    return true;
                }
            );

            food.set("amount", 10);

            System.out.println(" -> Se anaden 10 hormigas en (0, 0)");
            s.create(ant, 10, 0, 0);

            System.out.println(" -> Se anade 1 comida de tamano 10 en (2, 2)");
            s.create(food, 1, 2, 2);

            s.run(20);
        } catch (IllegalPositionException e) {
            e.printStackTrace();
        }
    }
}