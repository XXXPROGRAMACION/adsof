package es.uam.eps.ads.p5;

public class BasicAgent implements IBasicAgent {
    protected String name;
    private BasicCell cell;

    public BasicAgent(String name) {
        this.name = name;
        cell = null;
    }

    @Override
    public BasicCell getCell() {
        return cell;
    }

    @Override
    public void setCell(BasicCell cell) {
        this.cell = cell;
    }

    @Override
    public IBasicAgent copy() {
        return new BasicAgent(name);
    }
}