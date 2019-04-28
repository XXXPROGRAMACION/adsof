package es.uam.eps.ads.p5;

import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

public class Simulator {
    private Matrix<Cell> enviroment;

    public Simulator(int columns, int rows) {
        enviroment = new Matrix<>(columns, rows);
    }

    public void create(IAgent agent, int number, int x, int y)
    throws IllegalPositionException {
        if (!enviroment.checkElementAt(x, y)) {
            Cell cell = new Cell(x, y);
            enviroment.addElement(cell);
        }

        Cell cell = enviroment.getElementAt(x, y);
        for (int i = 0; i < number; i++) {
            cell.addAgent(agent.copy());
        }
    }

    public void run(int steps) {
        for (int i = 0; i < steps; i++) {
            List<IAgent> agents = new LinkedList<>();
            for (Cell c : enviroment.asList()) {
                agents.addAll(c.agents());
            }

            Collections.shuffle(agents);

            for (IAgent a : agents) {
                a.exec();
            }

            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Time = " + i);
            printEnviroment();
        }

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
    }

    public List<Cell> getNeighboursAt(Cell cell)
    throws IllegalPositionException {
        return enviroment.getNeighboursAt(cell.getI(), cell.getJ());
    }

    private void printEnviroment() {        
        try {
            for (int y = 0; y < enviroment.getRows(); y++) {
                for (int x = 0; x < enviroment.getCols(); x++) {
                    Cell cell = enviroment.getElementAt(x, y);
                    
                    if (cell == null) {
                        System.out.print("  0|");
                    } else {
                        System.out.format(" %2d|", cell.size());
                    }
                }

                System.out.print("\n");
            }
        } catch (IllegalPositionException e) {
            e.printStackTrace();
        }        
    }
} 