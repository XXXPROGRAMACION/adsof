package es.uam.eps.ads.p5.simulador;

import es.uam.eps.ads.p5.matriz.*;

import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

/**
 * Esta clase permite realiza una simulación para los agentes. Extiende la
 * funcionalidad del simulador básico.
 * @author Alejandro Pascual y Victor Yrazusta
 */
public class Simulator extends BasicSimulator {

    /**
     * Instancia un simulador dadas el número de columnas y filas con las que va
     * a trabajar.
     * @param columns Número de columnas
     * @param rows Número de filas
     */
    public Simulator(int columns, int rows) {
        super(columns, rows);
    }

    /**
     * Ejecuta un número dado de iteraciones de la simulación, imprimendo el
     * estado de la matriz tras cada iteración. Ejecuta los comportamientos e
     * interacciones de los agentes en cada iteración.
     * @param steps Número de iteraciones a ejecutar
     */
    @Override
    public void run(int steps) {
        for (int i = 0; i < steps; i++) {
            System.out.println("+++++++++++++++++++++++++++" + 
                               "+++++++++++++++++++++++++++");
            System.out.println("Time = " + i);

            List<IBasicAgent> agents = new LinkedList<>();
            for (Cell c : enviroment.asList()) {
                agents.addAll(c.agents());
            }

            Collections.shuffle(agents);

            for (IBasicAgent a : agents) {
                ((IAgent) a).exec();
            }
            
            printEnviroment();
        }

        System.out.println("+++++++++++++++++++++++++++" + 
                           "+++++++++++++++++++++++++++");
    }

    /**
     * Devuelve una lista con todas las celdas vecinas de la pasada como
     * argumento, asegurándose de crear todas las que pudiesen faltar.
     * @param cell Celda para la que se obtendrán sus celdas vecinas
     * @return Lista con todas las celdas vecinas de la pasada como argumento.
     * @throws IllegalPositionException Si las coordenadas de la celda están
     * fuera del rango de la matriz.
     */
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