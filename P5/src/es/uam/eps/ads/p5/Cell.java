package es.uam.eps.ads.p5;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Cell implements IMatrixElement<List<IBasicAgent>> {
    private List<IBasicAgent> agents;
    private int i;
    private int j;

    public Cell(int i, int j) {
        this.i = i;
        this.j = j;

        agents = new LinkedList<>();
    }

    @Override
    public List<IBasicAgent> getElement() {
        return agents();
    }
    
    public List<IBasicAgent> agents() {
        return Collections.unmodifiableList(agents);
    }
    
    @Override
    public void setElement(List<IBasicAgent> list) {
        throw new UnsupportedOperationException();
    }

    public void addAgent(IBasicAgent agent) {
        agent.setCell(this);
        agents.add(agent);
    }

    public void removeAgent(IBasicAgent agent) {
        agents.remove(agent);
    }

    public int size() {
        return agents.size();
    }

    @Override
    public int getI() {
        return i;
    }

    @Override
    public int getJ() {
        return j;
    }

    @Override
    public boolean equals(Object obj) {
       if (!(obj instanceof Cell)) return false;
       Cell c = (Cell) obj;
       return (i == c.getI()) && (j == c.getJ());
    }
}