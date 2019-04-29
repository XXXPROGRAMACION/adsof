package es.uam.eps.ads.p5;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Agent extends BasicAgent implements IAgent {
    private List<Behaviour> behaviours = new LinkedList<>();

    public Agent(String name) {
        super(name);
    }

    public Agent(String name, Cell cell, List<Behaviour> behaviours) {
        super(name);
        this.cell = cell;
        this.behaviours = behaviours;
    }

    /**
     * Mueve el agente a una celda adyacente
     * @param destination Destino de la operación
     */
    @Override
    public void moveTo(Cell destination) {
        if (cell != null) cell.removeAgent(this);
        cell = destination;
        destination.addAgent(this);
    }

    /**
     * Añade un comportamiento al agente
     * @param trigger Expresión que indica cuándo se tiene que ejecutar el comportamiento
     * @param behaviour Comportamiento a añadir
     * @return Agente sobre el que se llama a la función. Este return permite 
     * encadenar llamadas a métodos
     */
    @Override
    public IAgent addBehaviour(Predicate<IAgent> trigger, Function<IAgent, Boolean> behaviour) {
        behaviours.add(new Behaviour(trigger, behaviour));
        return this;
    }

    /**
     * Añade un comportamiento al agente
     * @param behaviour Comportamiento a añadir
     * @return Agente sobre el que se llama a la función. Este return permite 
     * encadenar llamadas a métodos
     */
    @Override
    public IAgent addBehaviour(Function<IAgent, Boolean> behaviour) {
        behaviours.add(new Behaviour(agent -> true, behaviour));
        return this;
    }

    /**
     * Realiza una copia del agente
     * @return Copia del agente
     */
    @Override
    public IBasicAgent copy() {
        return new Agent(name, cell, behaviours); 
    }

    /**
     * Ejectua el comportamiento del agente
     */
    @Override
    public void exec() {
        for (Behaviour b : behaviours) {
            if (b.trigger.test(this) && b.behaviour.apply(this)) continue;
            else break;
        }
    }
}