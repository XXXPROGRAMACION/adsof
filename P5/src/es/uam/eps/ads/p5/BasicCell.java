package es.uam.eps.ads.p5;

import java.util.LinkedList;

public class BasicCell {
    private LinkedList<IBasicAgent> agents;

    public BasicCell() {
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