package es.uam.eps.ads.p5;

public interface IBasicAgent {

    String name();

    Cell cell();

    void setCell(Cell cell);
    
    IBasicAgent copy();
}