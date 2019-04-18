package es.uam.eps.ads.p5;

public class BasicSimulator {
    IMatrix<Cell> enviroment;

    public BasicSimulator(int columns, int rows) {
        enviroment = new Matrix<>(columns, rows);
    }

    public void create(IBasicAgent agent, int number, int x, int y)
    throws IllegalPositionException {
        if (!enviroment.checkElementAt(x, y)) {
            IMatrixElement<Cell> matrixElement = new MatrixElement<>(x, y, new Cell());
            enviroment.addElement(matrixElement);
        }

        Cell cell = enviroment.getElementAt(x, y).getElement();
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
                    IMatrixElement<Cell> element = enviroment.getElementAt(x, y);
                    if (element == null) {
                        System.out.print("  0|");
                    } else {
                        int n = element.getElement().getAgentsNumber();
                        System.out.format(" %2d|", n);
                    }
                }
                System.out.print("\n");
            }
        } catch (IllegalPositionException e) {
            e.printStackTrace();
        }        
    }
}