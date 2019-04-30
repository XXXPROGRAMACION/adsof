package es.uam.eps.ads.p5;

import java.util.List;
import java.util.LinkedList;
import java.util.function.Function;
import java.util.function.Predicate;

public class AgentState implements IAgentState {
    private String name;
    private List<Behaviour> behaviours = new LinkedList<>();
    private List<StateChanger> stateChangers = new LinkedList<>();
    private IAgentWithState owner;

    public AgentState(String name, IAgentWithState owner) {
        this.name = name;
        this.owner = owner;
    }
    
    public AgentState(String name, List<Behaviour> behaviours, List<StateChanger> stateChangers, IAgentWithState owner) {
        this.name = name;
        this.behaviours = behaviours;
        this.stateChangers = stateChangers;
        this.owner = owner;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void toState(String target, Predicate<IAgent> trigger) {
        IAgentState state = owner.state(target);
        if (state == null) return;

        stateChangers.add(new StateChanger(trigger, state));
    }

    @Override
    public IAgentState changeState() {
        for (StateChanger stateChanger : stateChangers) {
            if (stateChanger.trigger.test(owner)) {
                return stateChanger.state;
            }
        }

        return this;
    }
    
    @Override
    public IAgentWithState addBehaviour(Predicate<IAgent> trigger, Function<IAgent, Boolean> behaviour) {
        behaviours.add(new Behaviour(trigger, behaviour));
        return owner;
    }
    
    @Override
    public IAgentWithState addBehaviour(Function<IAgent, Boolean> behaviour) {
        behaviours.add(new Behaviour(agent -> true, behaviour));
        return owner;
    }

    @Override
    public void exec() {
        for (Behaviour b : behaviours) {
            if (b.trigger.test(owner) && b.behaviour.apply(owner)) continue;
            else break;
        }
    }

    @Override
    public void setOwner(IAgentWithState aws) {
        owner = aws;
    }

    @Override
    public IAgentState copy() {
        return new AgentState(name, behaviours, stateChangers, owner);
    }

    private static class StateChanger {
        public Predicate<IAgent> trigger;
        public IAgentState state;

        public StateChanger(Predicate<IAgent> trigger, IAgentState state) {
            this.trigger = trigger;
            this.state = state;
        }
    }
}