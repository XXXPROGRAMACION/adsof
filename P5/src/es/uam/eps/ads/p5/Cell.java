package es.uam.eps.ads.p5;

import java.util.LinkedList;

public class Cell {
    private LinkedList<IBasicAgent> agents;

    public Cell() {
        agents = new LinkedList<>();
    }

    public void addAgent(IBasicAgent agent) {
        agent.setCell(this);
        agents.addFirst(agent);
    }

    public void removeAgent(IBasicAgent agent) {
        agents.remove(agent);
    }

    public int getAgentsNumber() {
        return agents.size();
    }
}