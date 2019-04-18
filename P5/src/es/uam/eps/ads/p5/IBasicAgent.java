package es.uam.eps.ads.p5;

public interface IBasicAgent {

    public Cell getCell();
    public void setCell(Cell cell);
    public IBasicAgent copy();
}