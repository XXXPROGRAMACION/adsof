package es.uam.eps.ads.p5.simulador;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Esta interfaz define los métodos elementales de un agente con estado.
 * @author Alejandro Pascual y Victor Yrazusta
 */
public interface IAgentWithState extends IAgent{
    
    /**
     * Devuelve el estado asociado al nombre de estado pasado como argumento.
     * @param name Nombre asociado al estado deseado
     * @return Estado asociado al nombre de estado pasado como argumento.
     */
    IAgentState state(String name);
    
    /**
     * Añade un comportamiento al estado asociado al nombre de estado pasado 
     * como argumento.
     * @param state Nombre del estado al que se desea añadir el comportamiento
     * @param trigger Condición de ejecución del comportamiento
     * @param behaviour Comportamiento a añadir al estado
     * @return Agente sobre el que se llama a la función. Este return permite 
     * encadenar llamadas a métodos.
     */
    IAgentWithState addBehaviour(String state, Predicate<IAgent> trigger,
                                 Function<IAgent, Boolean> behaviour);

    /**
     * Añade un comportamiento al estado asociado al nombre de estado pasado 
     * como argumento.
     * @param state Nombre del estado al que se desea añadir el comportamiento
     * @param behaviour Comportamiento a añadir al estado
     * @return Agente sobre el que se llama a la función. Este return permite 
     * encadenar llamadas a métodos.
     */
    IAgentWithState addBehaviour(String state, Function<IAgent, Boolean> behaviour);

    /**
     * Establece el estado actual del agente.
     * @param state Estado actual del agente
     */
    void setCurrentState(IAgentState state);
}