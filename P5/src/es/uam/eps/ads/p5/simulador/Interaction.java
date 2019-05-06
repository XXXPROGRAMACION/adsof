package es.uam.eps.ads.p5.simulador;

/**
 * Esta clase permite almacenar una interacción junto a la condición necesaria
 * para que esta se ejecute.
 * @author Alejandro Pascual y Victor Yrazusta
 */
public class Interaction {
    public Predicate2D<IAgent, IAgent> trigger;
    public Function2D<IAgent, IAgent, Boolean> interaction;

    /**
     * Instancia una interacción dadas su condición y su acción.
     * @param trigger Condición para que se ejecute la interaccion
     * @param interaction Interacción a ejecutar si se cumple la condición
     */
    public Interaction(Predicate2D<IAgent, IAgent> trigger,
                       Function2D<IAgent, IAgent, Boolean> interaction) {
        this.trigger = trigger;
        this.interaction = interaction;
    }
}