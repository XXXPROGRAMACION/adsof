package es.uam.eps.ads.p5.simulador;

import es.uam.eps.ads.p5.matriz.*;

/**
 * Esta interfaz define los métodos elementales de un agente básico.
 * @author Alejandro Pascual y Victor Yrazusta
 */
public interface IBasicAgent {

    /**
     * Devuelve el nombre del agente.
     * @return Nombre del agente
     */
    String name();

    /**
     * Devuelve la celda en la que se encuentra el agente.
     * @return Celda en la que se encuentra el agente
     */
    Cell cell();

    /**
     * Establece la celda en la que se encuentra el agente.
     * @param cell Nueva celda en la que se encuentra el agente
     */
    void setCell(Cell cell);
    
    /**
     * Copia la celda.
     * @return Nueva celda con el mismo nombre
     */
    IBasicAgent copy();
}