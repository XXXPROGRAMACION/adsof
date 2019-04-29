package es.uam.eps.ads.p5;

public interface IBasicAgent {

    Cell getCell();

    void setCell(Cell cell);
    
    IBasicAgent copy();
}