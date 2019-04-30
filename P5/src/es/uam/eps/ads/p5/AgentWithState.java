package es.uam.eps.ads.p5;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.HashMap;

public class AgentWithState extends Agent implements IAgentWithState {
    private Map<String, IAgentState> states;
    private IAgentState currentState;

    public AgentWithState(String name, String initialStateName, String ... statesNames) {
        super(name);

        states = new HashMap<>();

        currentState = new AgentState(initialStateName, this);
        states.put(initialStateName, currentState);
        
        for (String stateName : statesNames) {
            if (states.containsKey(stateName)) continue;
            states.put(stateName, new AgentState(stateName, this));
        }
    }

    public AgentWithState(String name, Cell cell, List<Behaviour> behaviours, List<Interaction> interactions, Map<String, Integer> properties, Map<String, IAgentState> states) {
        super(name, cell, behaviours, interactions, properties);

        this.states = states;
    }

    @Override
    public IAgentState state(String name) {
        return states.get(name);
    }

    @Override
    public IAgentWithState addBehaviour(String state, Predicate<IAgent> trigger, Function<IAgent, Boolean> behaviour) {
        IAgentState target = states.get(name);
        if (target == null) return null;

        target.addBehaviour(trigger, behaviour);
        return this;
    }

    @Override
    public IAgentWithState addBehaviour(String state, Function<IAgent, Boolean> behaviour) {
        IAgentState target = states.get(name);
        if (target == null) return null;

        target.addBehaviour(behaviour);
        return this;
    }

    @Override
    public void setCurrentState(IAgentState state) {
        this.currentState = state;
    }

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

    @Override
    public IBasicAgent copy() {
        Map<String, Integer> newProperties = new HashMap<>(properties);

        IAgentWithState agent = new AgentWithState(name, cell, behaviours, interactions, newProperties, states);
        
        IAgentState state = currentState.copy();
        state.setOwner(agent);
        agent.setCurrentState(state);

        return agent;
    }
}