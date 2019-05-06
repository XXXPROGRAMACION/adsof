package es.uam.eps.ads.p5.simulador;

import es.uam.eps.ads.p5.matriz.*;

import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Esta clase permite trabajar con agentes que poseen comportamientos,
 * interacciones y propiedades. Heredan la funcionalidad de los agentes básicos.
 * @author Alejandro Pascual y Victor Yrazusta
 */
public class Agent extends BasicAgent implements IAgent {
    protected List<Behaviour> behaviours;
    protected List<Interaction> interactions;
    protected Map<String, Integer> properties;

    /**
     * Instancia un agente dado su nombre.
     * @param name Nombre del agente
     */
    public Agent(String name) {
        super(name);

        behaviours = new LinkedList<>();
        interactions = new LinkedList<>();
        properties = new HashMap<>();
    }

    /**
     * Instancia una agente dadas todas sus características.
     * @param name Nombre del agente
     * @param cell Celda actual del agente
     * @param behaviours Comportamientos del agente
     * @param interactions Interacciones del agente
     * @param properties Propiedades del agente
     */
    public Agent(String name, Cell cell, List<Behaviour> behaviours,
              List<Interaction> interactions, Map<String, Integer> properties) {
        super(name);

        this.cell = cell;
        this.behaviours = behaviours;
        this.interactions = interactions;
        this.properties = properties;
    }

    /**
     * Mueve el agente a una celda adyacente.
     * @param destination Destino de la operación
     */
    @Override
    public void moveTo(Cell destination) {
        if (cell != null) cell.removeAgent(this);
        cell = destination;
        destination.addAgent(this);
    }

    /**
     * Añade un comportamiento al agente.
     * @param trigger Condición de ejecución del comportamiento
     * @param behaviour Comportamiento a añadir
     * @return Agente sobre el que se llama a la función. Este return permite 
     * encadenar llamadas a métodos.
     */
    @Override
    public IAgent addBehaviour(Predicate<IAgent> trigger, Function<IAgent, Boolean> behaviour) {
        behaviours.add(new Behaviour(trigger, behaviour));
        return this;
    }

    /**
     * Añade un comportamiento al agente.
     * @param behaviour Comportamiento a añadir
     * @return Agente sobre el que se llama a la función. Este return permite 
     * encadenar llamadas a métodos.
     */
    @Override
    public IAgent addBehaviour(Function<IAgent, Boolean> behaviour) {
        behaviours.add(new Behaviour(agent -> true, behaviour));
        return this;
    }

    /**
     * Añade una interacción al agente.
     * @param trigger Condición de ejecución de la interacción
     * @param interaction Interacción a añadir
     * @return Agente sobre el que se llama a la función. Este return permite 
     * encadenar llamadas a métodos.
     */
    @Override
    public IAgent addInteraction(Predicate2D<IAgent, IAgent> trigger, 
                              Function2D<IAgent, IAgent, Boolean> interaction) {
        interactions.add(new Interaction(trigger, interaction));
        return this;
    }

    /**
     * Añade una interacción al agente.
     * @param interaction Interacción a añadir
     * @return Agente sobre el que se llama a la función. Este return permite 
     * encadenar llamadas a métodos.
     */
    @Override
    public IAgent addInteraction(
                              Function2D<IAgent, IAgent, Boolean> interaction) {
        interactions.add(new Interaction((self, agent) -> true, interaction));
        return this;
    }

    /**
     * Añade o sobreescribe una propiedad del agente.
     * @param propertyName Nombre de la propiedad del agente
     * @param propertyValue Valor de la propiedad del agente
     */
    @Override
    public void set(String propertyName, int propertyValue) {
        properties.put(propertyName, propertyValue);
    }

    /**
    * Obtiene el valor de una propiedad del agente.
    * @param propertyName Nombre de la propiedad a obtener
    * @return Valor de la propiedad del agente.
    */
    @Override
    public Integer get(String propertyName) {
        return properties.get(propertyName);
    }

    /**
     * Modifica una propiedad del agente.
     * @param propertyName Nombre de la propiedad del agente
     * @param increasement Incremento de la propiedad, puede ser negativo
     */
    @Override
    public void increase(String propertyName, int increasement) {
        Integer propertyValue = properties.get(propertyName);
        if (propertyValue == null) return;

        propertyValue += increasement;
        properties.put(propertyName, propertyValue);
    }
    
    /**
     * Ejecuta los comportamientos e interacciones del agente.
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

            if (a.equals(this)) continue;

            for (Interaction i : interactions) {
                if (i.trigger.test(this, a) && i.interaction.apply(this, a)) { 
                    continue;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * Realiza una copia del agente.
     * @return Copia del agente.
     */
    @Override
    public IBasicAgent copy() {
        Map<String, Integer> newProperties = new HashMap<>(properties);
        return new Agent(name, cell, behaviours, interactions, newProperties); 
    }
}