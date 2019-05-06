package es.uam.eps.ads.p5.simulador;

import es.uam.eps.ads.p5.matriz.*;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.HashMap;

/**
 * Esta clase permite trabajar con agentes con estado. Heredan la funcionalidad
 * de los agentes.
 * @author Alejandro Pascual y Victor Yrazusta
 */
public class AgentWithState extends Agent implements IAgentWithState {
    private Map<String, IAgentState> states;
    private IAgentState currentState;

    /**
     * Instancia una agente con estado dados su nombre y sus estados.
     * @param name Nombre del agente
     * @param initialStateName Nombre del estado inicial
     * @param statesNames Nombre del resto de estados
     */
    public AgentWithState(String name, String initialStateName,
                          String ... statesNames) {
        super(name);

        states = new HashMap<>();

        currentState = new AgentState(initialStateName, this);
        states.put(initialStateName, currentState);
        
        for (String stateName : statesNames) {
            if (states.containsKey(stateName)) continue;
            states.put(stateName, new AgentState(stateName, this));
        }
    }

    /**
     * Instancia un agente con estado dadas todas sus características.
     * @param name Nombre del agente
     * @param cell Celda actual del agente
     * @param behaviours Comportamientos del agente
     * @param interactions Interacciones del agente
     * @param properties Propiedades del agente
     * @param states Estados del agente
     */
    public AgentWithState(String name, Cell cell, List<Behaviour> behaviours, 
                List<Interaction> interactions, Map<String, Integer> properties,
                Map<String, IAgentState> states) {
        super(name, cell, behaviours, interactions, properties);

        this.states = states;
    }

    /**
     * Devuelve el estado asociado al nombre de estado pasado como argumento.
     * @param name Nombre asociado al estado deseado
     * @return Estado asociado al nombre de estado pasado como argumento.
     */
    @Override
    public IAgentState state(String name) {
        return states.get(name);
    }

    /**
     * Añade un comportamiento al estado asociado al nombre de estado pasado 
     * como argumento.
     * @param state Nombre del estado al que se desea añadir el comportamiento
     * @param trigger Condición de ejecución del comportamiento
     * @param behaviour Comportamiento a añadir al estado
     * @return Agente sobre el que se llama a la función. Este return permite 
     * encadenar llamadas a métodos.
     */
    @Override
    public IAgentWithState addBehaviour(String state, Predicate<IAgent> trigger,
                                        Function<IAgent, Boolean> behaviour) {
        IAgentState target = states.get(name);
        if (target == null) return null;

        target.addBehaviour(trigger, behaviour);
        return this;
    }

    /**
     * Añade un comportamiento al estado asociado al nombre de estado pasado 
     * como argumento.
     * @param state Nombre del estado al que se desea añadir el comportamiento
     * @param behaviour Comportamiento a añadir al estado
     * @return Agente sobre el que se llama a la función. Este return permite 
     * encadenar llamadas a métodos.
     */
    @Override
    public IAgentWithState addBehaviour(String state, 
                                        Function<IAgent,Boolean> behaviour) {
        IAgentState target = states.get(name);
        if (target == null) return null;

        target.addBehaviour(behaviour);
        return this;
    }

    /**
     * Establece el estado actual del agente.
     * @param state Estado actual del agente
     */
    @Override
    public void setCurrentState(IAgentState state) {
        this.currentState = state;
    }

    /**
     * Ejecuta los comportamientos del agente y de su estado actual. Después
     * obtiene el nuevo estado del agente y, si es distinto al actual, hace una
     * copia de este y se establece el agente al que el estado pertenece.
     */
    @Override
    public void exec() {
        super.exec();

        currentState.exec();
        
        IAgentState nextState = currentState.changeState();
        if (nextState != currentState) {
            currentState = nextState.copy();
            currentState.setOwner(this);
        }
    }

    /**
     * Realiza una copia del agente.
     * @return Copia del agente.
     */
    @Override
    public IBasicAgent copy() {
        Map<String, Integer> newProperties = new HashMap<>(properties);

        IAgentWithState agent = new AgentWithState(name, cell, behaviours,
                                           interactions, newProperties, states);
        
        IAgentState state = currentState.copy();
        state.setOwner(agent);
        agent.setCurrentState(state);

        return agent;
    }
}