package es.uam.eps.ads.p5;

import java.util.function.Function;
import java.util.function.Predicate;

public interface IAgent extends IBasicAgent {    

    /**
     * Mueve el agente a una celda adyacente
     * @param destination Destino de la operación
     */
    void moveTo(Cell destination);

    /**
     * Ejectua el comportamiento del agente
     */
    void exec();

    /**
     * Añade un comportamiento al agente
     * @param trigger Expresión que indica cuándo se tiene que ejecutar el comportamiento
     * @param behaviour Comportamiento a añadir
     * @return Agente sobre el que se llama a la función. Este return permite 
     * encadenar llamadas a métodos
     */
    IAgent addBehaviour(Predicate<IAgent> trigger, Function<IAgent, Boolean> behaviour);

    /**
     * Añade un comportamiento al agente
     * @param behaviour Comportamiento a añadir
     * @return Agente sobre el que se llama a la función. Este return permite 
     * encadenar llamadas a métodos
     */
    IAgent addBehaviour(Function<IAgent, Boolean> behaviour);

    /**
     * Devuelve la célula del agente
     * @return Célula del agente
     */
    Cell cell();

    /**
     * Realiza una copia del agente
     * @return Copia del agente
     */
    IAgent copy();
}