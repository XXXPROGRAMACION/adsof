package es.uam.eps.ads.p5.simulador;

import es.uam.eps.ads.p5.matriz.*;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Esta interfaz define los métodos elementales de un agente.
 * @author Alejandro Pascual y Victor Yrazusta
 */
public interface IAgent extends IBasicAgent {

    /**
     * Mueve el agente a una celda adyacente.
     * @param destination Destino de la operación
     */
    void moveTo(Cell destination);

    /**
     * Ejectua el comportamiento del agente
     */
    void exec();

    /**
     * Añade un comportamiento al agente.
     * @param trigger Condición de ejecución del comportamiento
     * @param behaviour Comportamiento a añadir
     * @return Agente sobre el que se llama a la función. Este return permite 
     * encadenar llamadas a métodos.
     */
    IAgent addBehaviour(Predicate<IAgent> trigger,
                        Function<IAgent, Boolean> behaviour);

   /**
     * Añade un comportamiento al agente.
     * @param behaviour Comportamiento a añadir
     * @return Agente sobre el que se llama a la función. Este return permite 
     * encadenar llamadas a métodos.
     */
    IAgent addBehaviour(Function<IAgent, Boolean> behaviour);

    /**
     * Añade una interacción al agente.
     * @param trigger Condición de ejecución de la interacción
     * @param interaction Interacción a añadir
     * @return Agente sobre el que se llama a la función. Este return permite 
     * encadenar llamadas a métodos.
     */
    IAgent addInteraction(Predicate2D<IAgent, IAgent> trigger,
                          Function2D<IAgent, IAgent, Boolean> interaction);

    /**
     * Añade una interacción al agente.
     * @param interaction Interacción a añadir
     * @return Agente sobre el que se llama a la función. Este return permite 
     * encadenar llamadas a métodos.
     */
    IAgent addInteraction(Function2D<IAgent, IAgent, Boolean> interaction);

    /**
     * Añade o sobreescribe una propiedad del agente.
     * @param propertyName Nombre de la propiedad del agente
     * @param propertyValue Valor de la propiedad del agente
     */
    void set(String propertyName, int propertyValue);

    /**
     * Obtiene el valor de una propiedad del agente.
     * @param propertyName Nombre de la propiedad a obtener
     * @return Valor de la propiedad del agente.
     */
    Integer get(String propertyName);

    /**
     * Modifica una propiedad del agente.
     * @param propertyName Nombre de la propiedad del agente
     * @param increasement Incremento de la propiedad, puede ser negativo
     */
    void increase(String propertyName, int increasement);
}