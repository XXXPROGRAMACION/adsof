package es.uam.eps.ads.p5.simulador;

import es.uam.eps.ads.p5.matriz.*;

/**
 * Esta clase recoge la funcionalidad de un agente básico.
 * @author Alejandro Pascual y Victor Yrazusta
 */
public class BasicAgent implements IBasicAgent {
    protected String name;
    protected Cell cell;

    /**
     * Instancia un agente básico dado su nombre.
     * @param name Nombre del agente básico
     */
    public BasicAgent(String name) {
        this.name = name;
        cell = null;
    }

    /**
     * Devuelve el nombre del agente.
     * @return Nombre del agente
     */
    @Override
    public String name() {
        return name;
    }

    /**
     * Devuelve la celda en la que se encuentra el agente.
     * @return Celda en la que se encuentra el agente
     */
    @Override
    public Cell cell() {
        return cell;
    }

    /**
     * Establece la celda en la que se encuentra el agente.
     * @param cell Nueva celda en la que se encuentra el agente
     */
    @Override
    public void setCell(Cell cell) {
        this.cell = cell;
    }

    /**
     * Copia la celda.
     * @return Nueva celda con el mismo nombre
     */
    @Override
    public IBasicAgent copy() {
        return new BasicAgent(name);
    }
}