package es.uam.eps.ads.p5;

import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

public class Simulator extends BasicSimulator {

    public Simulator(int columns, int rows) {
        super(columns, rows);
    }

    @Override
    public void run(int steps) {
        for (int i = 0; i < steps; i++) {
            List<IBasicAgent> agents = new LinkedList<>();
            for (Cell c : enviroment.asList()) {
                agents.addAll(c.agents());
            }

            Collections.shuffle(agents);

            for (IBasicAgent a : agents) {
                ((IAgent) a).exec();
            }

            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Time = " + i);
            printEnviroment();
        }

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    public List<Cell> getNeighboursAt(Cell cell)
    throws IllegalPositionException {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                try {
                    int newI = cell.getI()+i;
                    int newJ = cell.getJ()+j;

                    if (enviroment.checkElementAt(newI, newJ)) continue;

                    enviroment.addElement(new Cell(newI, newJ));
                } catch(IllegalPositionException e) {
                    continue;
                }
            }
        }

        return enviroment.getNeighboursAt(cell.getI(), cell.getJ());        
    }
} 