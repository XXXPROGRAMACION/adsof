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

    IAgent addInteraction(Predicate2D<IAgent, IAgent> trigger, Function2D<IAgent, IAgent, Boolean> behaviour);

    IAgent addInteraction(Function2D<IAgent, IAgent, Boolean> behaviour);

    void set(String propertyName, int propertyValue);

    Integer get(String propertyName);

    void increase(String propertyName, int increasement);
}