package es.uam.eps.ads.p5.simulador;

import es.uam.eps.ads.p5.matriz.*;

/**
 * Esta clase permite realizar una simulación para los agentes básicos.
 * @author Alejandro Pascual y Victor Yrazusta
 */
public class BasicSimulator {
    protected Matrix<Cell> enviroment;

    /**
     * Instancia un simulador dadas el número de columnas y filas con las que va
     * a trabajar.
     * @param columns Número de columnas
     * @param rows Número de filas
     */
    public BasicSimulator(int columns, int rows) {
        enviroment = new Matrix<>(columns, rows);
    }

    /**
     * Crea una determinada cantidad de agentes básicos en una posición 
     * determinada.
     * @param agent Agente básico que se quiere crear
     * @param number Número de agentes a crear
     * @param x Posición horizontal de los agentes a crear
     * @param y Posición vertical de los agentes a crear
     * @throws IllegalPositionException Cuando la posición indicada no se 
     * encuentra dentro de la matriz
     */
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

    /**
     * Ejecuta un número dado de iteraciones de la simulación, imprimendo el
     * estado de la matriz tras cada iteración.
     * @param steps Número de iteraciones a ejecutar
     */
    public void run(int steps) {
        for (int i = 0; i < steps; i++) {
            System.out.println("+++++++++++++++++++++++++++" + 
                               "+++++++++++++++++++++++++++");
            System.out.println("Time = " + i);
            printEnviroment();
        }

        System.out.println("+++++++++++++++++++++++++++" + 
                           "+++++++++++++++++++++++++++");
    }

    /**
     * Imprime el estado del ambiente del simulador, indicando en cada celda
     * la cantidad de agentes que se encuentran en ella.
     */
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