package es.uam.eps.ads.p5;

public class BasicSimulator {
    private Matrix<BasicCell> enviroment;

    public BasicSimulator(int columns, int rows) {
        enviroment = new Matrix<>(columns, rows);
    }

    public void create(IBasicAgent agent, int number, int x, int y)
    throws IllegalPositionException {
        if (!enviroment.checkElementAt(x, y)) {
            BasicCell cell = new BasicCell(x, y);
            enviroment.addElement(cell);
        }

        BasicCell cell = enviroment.getElementAt(x, y);
        for (int i = 0; i < number; i++) {
            cell.addAgent(agent.copy());
        }
    }

    public void run(int steps) {
        for (int i = 0; i < steps; i++) {
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Time = " + i);
            printEnviroment();
        }

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
    }

    private void printEnviroment() {        
        try {
            for (int y = 0; y < enviroment.getRows(); y++) {
                for (int x = 0; x < enviroment.getCols(); x++) {
                    BasicCell cell = enviroment.getElementAt(x, y);
                    
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