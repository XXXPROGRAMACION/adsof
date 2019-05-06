package es.uam.eps.ads.p5.simulador;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Esta clase permite almacenar un comportamiento junto a la condición necesaria
 * para que este se ejecute.
 * @author Alejandro Pascual y Victor Yrazusta
 */
public class Behaviour {
    public Predicate<IAgent> trigger;
    public Function<IAgent, Boolean> behaviour;

    /**
     * Instancia un comportamiento dados su condición y su acción.
     * @param trigger Condición para que se ejecute el comportamiento
     * @param behaviour Comportamiento a ejecutar si se cumple la condición
     */
    public Behaviour(Predicate<IAgent> trigger, 
                     Function<IAgent, Boolean> behaviour) {
        this.trigger = trigger;
        this.behaviour = behaviour;
    }
}