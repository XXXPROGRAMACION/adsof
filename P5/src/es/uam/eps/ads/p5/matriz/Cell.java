package es.uam.eps.ads.p5.matriz;

import es.uam.eps.ads.p5.simulador.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Esta clase permite trabajar con celdas, las cuales son un elemento de matriz
 * que almacena una lista de agentes básicos.
 * @author Alejandro Pascual y Victor Yrazusta
 */
public class Cell implements IMatrixElement<List<IBasicAgent>> {
    private List<IBasicAgent> agents;
    private int i;
    private int j;

    /**
     * Instancia una celda dadas sus coordenadas.
     * @param i Coordenada i
     * @param j Coordenada j
     */
    public Cell(int i, int j) {
        this.i = i;
        this.j = j;

        agents = new LinkedList<>();
    }

    /**
     * Devuelve el elemento de la celda, es decir, su lista de agentes.
     * @return Lista de agentes de la celda.
     */
    @Override
    public List<IBasicAgent> getElement() {
        return agents();
    }
    
    /**
     * Devuelve la lista de agentes de la celda.
     * @return La lista de agentes de la celda.
     */
    public List<IBasicAgent> agents() {
        return Collections.unmodifiableList(agents);
    }
    
    /**
     * Establece el elemento de la celda. Como no queremos que se le pueda
     * cargar la lista de agentes directamente, devuelve una excepción.
     * @param agents Lista de agentes, no se cargará
     */
    @Override
    public void setElement(List<IBasicAgent> agents) {
        throw new UnsupportedOperationException();
    }

    /**
     * Añade un agente a la celda.
     * @param agent Agente a añadir a la celda
     */
    public void addAgent(IBasicAgent agent) {
        agent.setCell(this);
        agents.add(agent);
    }

    /**
     * Elimina un agente de la celda.
     * @param agent Agente a eliminar de la celda
     */
    public void removeAgent(IBasicAgent agent) {
        agents.remove(agent);
    }

    /**
     * Devuelve el número de agentes presentes en la celda.
     * @return Número de agentes presentes en la celda
     */
    public int size() {
        return agents.size();
    }

    /**
     * Devuelve la coordenada i de la celda.
     * @return Coordenada i de la celda
     */
    @Override
    public int getI() {
        return i;
    }

    /** 
     * Devuelve la coordenada j de la celda.
     * @return Coordenada j de la celda
     */
    @Override
    public int getJ() {
        return j;
    }

    /**
     * Indica si el objeto pasado como argumento es equivalente a este.
     * @param obj Objeto a comparar con el actual.
     * @return Si el objeto pasado como argumento es equivalente a este o no.
     */
    @Override
    public boolean equals(Object obj) {
       if (!(obj instanceof Cell)) return false;
       Cell c = (Cell) obj;
       return (i == c.getI()) && (j == c.getJ());
    }
}