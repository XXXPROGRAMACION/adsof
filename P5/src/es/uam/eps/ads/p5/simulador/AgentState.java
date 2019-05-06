package es.uam.eps.ads.p5.simulador;

import java.util.List;
import java.util.LinkedList;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Esta clase permite trabajar con estados de agente, los cuales tienen 
 * comportamientos asociados y condiciones para cambiar de estado.
 * @author Alejandro Pascual y Victor Yrazusta
 */
public class AgentState implements IAgentState {
    private String name;
    private List<Behaviour> behaviours = new LinkedList<>();
    private List<StateChanger> stateChangers = new LinkedList<>();
    private IAgentWithState owner;

    /**
     * Instancia una estado dado su nombre y el agente al que pertenece.
     * @param name Nombre del estado
     * @param owner Agente al que pertenece el estado
     */
    public AgentState(String name, IAgentWithState owner) {
        this.name = name;
        this.owner = owner;
    }
    
    /**
     * Instancia un estado dadas todas sus características.
     * @param name Nombre del estado
     * @param behaviours Comportamientos del estado
     * @param stateChangers Condiciones de cambio a otros estados
     * @param owner Agente al que pertenece el estado
     */
    public AgentState(String name, List<Behaviour> behaviours,
                      List<StateChanger> stateChangers, IAgentWithState owner) {
        this.name = name;
        this.behaviours = behaviours;
        this.stateChangers = stateChangers;
        this.owner = owner;
    }

    /**
     * Devuelve el nombre del agente.
     * @return Nombre del agente.
     */
    @Override
    public String name() {
        return name;
    }

    /**
     * Añade una condición de cambio de estado. Si no existe un estado asociado
     * al nombre indicado, aborta el proceso.
     * @param target Nombre del estado al que se deberá cambiar
     * @param trigger Condición para realizar el cambio de estado
     */
    @Override
    public void toState(String target, Predicate<IAgent> trigger) {
        IAgentState state = owner.state(target);
        if (state == null) return;

        stateChangers.add(new StateChanger(trigger, state));
    }

    /**
     * Comprueba todas las condiciones de cambio de estado y, cuando una se
     * cumple, devuelve el estado asociado a ella. Si no se cumple ninguna
     * devuelve el estado actual.
     * @return Nuevo estado del agente.
     */
    @Override
    public IAgentState changeState() {
        for (StateChanger stateChanger : stateChangers) {
            if (stateChanger.trigger.test(owner)) {
                return stateChanger.state;
            }
        }

        return this;
    }
    
    /**
     * Añade un comportamiento al estado.
     * @param trigger Condición de ejecución del comportamiento
     * @param behaviour Comportamiento a añadir
     * @return Estado sobre el que se llama a la función. Este return permite 
     * encadenar llamadas a métodos.
     */
    @Override
    public IAgentWithState addBehaviour(Predicate<IAgent> trigger,
                                        Function<IAgent, Boolean> behaviour) {
        behaviours.add(new Behaviour(trigger, behaviour));
        return owner;
    }
    
    /**
     * Añade un comportamiento al estado.
     * @param behaviour Comportamiento a añadir
     * @return Estado sobre el que se llama a la función. Este return permite 
     * encadenar llamadas a métodos.
     */
    @Override
    public IAgentWithState addBehaviour(Function<IAgent, Boolean> behaviour) {
        behaviours.add(new Behaviour(agent -> true, behaviour));
        return owner;
    }

    /**
     * Ejecuta los comportamientos del estado.
     */
    @Override
    public void exec() {
        for (Behaviour b : behaviours) {
            if (b.trigger.test(owner) && b.behaviour.apply(owner)) continue;
            else break;
        }
    }

    /**
     * Establece el nuevo agente al que pertenece el estado.
     * @param aws Nuevo agente al que pertenece el estado
     */
    @Override
    public void setOwner(IAgentWithState aws) {
        owner = aws;
    }

    /**
     * Realiza una copia del estado.
     * @return Copia del estado.
     */
    @Override
    public IAgentState copy() {
        return new AgentState(name, behaviours, stateChangers, owner);
    }

    /**
     * Esta clase privada estática permite almacenar una condición de cambio
     * de estado junto al estado al que debería cambiar. Solo se usa en
     * AgentState.
     */
    private static class StateChanger {
        public Predicate<IAgent> trigger;
        public IAgentState state;

        /**
         * Instancia una condición de cambio de estado dados su condición y el
         * estado al que debería cambiar.
         * @param trigger Condición para cambiar al estado objetivo
         * @param state Estado al que cambiar si se cumple la condición
         */
        public StateChanger(Predicate<IAgent> trigger, IAgentState state) {
            this.trigger = trigger;
            this.state = state;
        }
    }
}