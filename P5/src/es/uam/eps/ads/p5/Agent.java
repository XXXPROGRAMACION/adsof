package es.uam.eps.ads.p5;

import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class Agent extends BasicAgent implements IAgent {
    protected List<Behaviour> behaviours;
    protected List<Interaction> interactions;
    protected Map<String, Integer> properties;

    public Agent(String name) {
        super(name);

        behaviours = new LinkedList<>();
        interactions = new LinkedList<>();
        properties = new HashMap<>();
    }

    public Agent(String name, Cell cell, List<Behaviour> behaviours, List<Interaction> interactions, Map<String, Integer> properties) {
        super(name);

        this.cell = cell;
        this.behaviours = behaviours;
        this.interactions = interactions;
        this.properties = properties;
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

    @Override
    public IAgent addInteraction(Predicate2D<IAgent, IAgent> trigger, Function2D<IAgent, IAgent, Boolean> behaviour) {
        interactions.add(new Interaction(trigger, behaviour));
        return this;
    }

    @Override
    public IAgent addInteraction(Function2D<IAgent, IAgent, Boolean> behaviour) {
        interactions.add(new Interaction((self, agent) -> true, behaviour));
        return this;
    }

    @Override
    public void set(String propertyName, int propertyValue) {
        properties.put(propertyName, propertyValue);
    }

    @Override
    public Integer get(String propertyName) {
        return properties.get(propertyName);
    }

    @Override
    public void increase(String propertyName, int increasement) {
        Integer propertyValue = properties.get(propertyName);
        if (propertyValue == null) return;

        propertyValue += increasement;
        properties.put(propertyName, propertyValue);
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

        if (interactions.isEmpty()) return;

        for (IBasicAgent basicA : cell.agents()) {
            IAgent a = (IAgent) basicA;
            for (Interaction i : interactions) {
                if (i.trigger.test(this, a) && i.behaviour.apply(this, a)) continue;
                else break;
            }
        }
    }

    /**
     * Realiza una copia del agente
     * @return Copia del agente
     */
    @Override
    public IBasicAgent copy() {
        Map<String, Integer> newProperties = new HashMap<>(properties);
        return new Agent(name, cell, behaviours, interactions, newProperties); 
    }
}