package es.uam.eps.ads.p5;

public class Interaction {
    public Predicate2D<IAgent, IAgent> trigger;
    public Function2D<IAgent, IAgent, Boolean> behaviour;

    public Interaction(Predicate2D<IAgent, IAgent> trigger, Function2D<IAgent, IAgent, Boolean> behaviour) {
        this.trigger = trigger;
        this.behaviour = behaviour;
    }
}