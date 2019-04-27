package es.uam.eps.ads.p5;

public interface IBasicAgent {

    BasicCell getCell();
    void setCell(BasicCell cell);
    IBasicAgent copy();
}