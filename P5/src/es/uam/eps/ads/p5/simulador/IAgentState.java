package es.uam.eps.ads.p5.simulador;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Esta interfaz define los métodos elementales de un estado de agente.
 * @author Alejandro Pascual y Victor Yrazusta
 */
public interface IAgentState {

    /**
     * Devuelve el nombre del agente.
     * @return Nombre del agente.
     */
    String name();
    
    /**
     * Añade una condición de cambio de estado. Si no existe un estado asociado
     * al nombre indicado, aborta el proceso.
     * @param target Nombre del estado al que se deberá cambiar
     * @param trigger Condición para realizar el cambio de estado
     */
    void toState(String target, Predicate<IAgent> trigger);
    
    /**
     * Comprueba todas las condiciones de cambio de estado y, cuando una se
     * cumple, devuelve el estado asociado a ella. Si no se cumple ninguna
     * devuelve el estado actual.
     * @return Nuevo estado del agente.
     */
    IAgentState changeState();
    
    /**
     * Añade un comportamiento al estado.
     * @param trigger Condición de ejecución del comportamiento
     * @param behaviour Comportamiento a añadir
     * @return Estado sobre el que se llama a la función. Este return permite 
     * encadenar llamadas a métodos.
     */
    IAgentWithState addBehaviour(Predicate<IAgent> trigger,
                                 Function<IAgent, Boolean> behaviour);
    
    /**
     * Añade un comportamiento al estado.
     * @param behaviour Comportamiento a añadir
     * @return Estado sobre el que se llama a la función. Este return permite 
     * encadenar llamadas a métodos.
     */
    IAgentWithState addBehaviour(Function<IAgent, Boolean> behaviour);
    
    /**
     * Ejecuta los comportamientos del estado.
     */
    void exec();
    
    /**
     * Establece el nuevo agente al que pertenece el estado.
     * @param aws Nuevo agente al que pertenece el estado
     */
    void setOwner(IAgentWithState aws);
    
    /**
     * Realiza una copia del estado.
     * @return Copia del estado.
     */
    IAgentState copy();
}