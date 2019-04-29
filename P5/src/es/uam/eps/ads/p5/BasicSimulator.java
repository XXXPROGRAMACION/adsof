package es.uam.eps.ads.p5;

public class BasicSimulator {
    protected Matrix<Cell> enviroment;

    public BasicSimulator(int columns, int rows) {
        enviroment = new Matrix<>(columns, rows);
    }

    public void create(IBasicAgent agent, int number, int x, int y)
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
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Time = " + i);
            printEnviroment();
        }

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    protected void printEnviroment() {        
        try {
            for (int y = 0; y < enviroment.getRows(); y++) {
                for (int x = 0; x < enviroment.getCols(); x++) {
                    Cell cell = enviroment.getElementAt(x, y);
                    
                    if (cell == null) {
                        System.out.print("   0|");
                    } else {
                        System.out.format(" %3d|", cell.size());
                    }
                }

                System.out.print("\n");
            }
        } catch (IllegalPositionException e) {
            e.printStackTrace();
        }        
    }
}