package es.uam.eps.ads.p5;

import java.util.function.Function;
import java.util.function.Predicate;

public class Behaviour {
    public Predicate<IAgent> trigger;
    public Function<IAgent, Boolean> behaviour;

    public Behaviour(Predicate<IAgent> trigger, Function<IAgent, Boolean> behaviour) {
        this.trigger = trigger;
        this.behaviour = behaviour;
    }
}