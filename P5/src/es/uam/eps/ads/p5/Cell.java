package es.uam.eps.ads.p5;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Cell {
    private List<IAgent> agents;

    public Cell() {
        agents = new LinkedList<>();
    }

    public void addAgent(IAgent agent) {
        agent.moveTo(this);
        agents.add(agent);
    }

    public void removeAgent(IAgent agent) {
        agents.remove(agent);
    }

    public int getAgentsNumber() {
        return agents.size();
    }

    public List<IAgent> getAgents() {
        return Collections.unmodifiableList(agents);
    }
}