package es.uam.eps.ads.p5;

public class BasicAgent implements IBasicAgent {
    protected String name;
    protected Cell cell;

    public BasicAgent(String name) {
        this.name = name;
        cell = null;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Cell cell() {
        return cell;
    }

    @Override
    public void setCell(Cell cell) {
        this.cell = cell;
    }

    @Override
    public IBasicAgent copy() {
        return new BasicAgent(name);
    }
}