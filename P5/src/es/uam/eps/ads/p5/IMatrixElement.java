package es.uam.eps.ads.p5;

public interface IMatrixElement<T> {

    public int getI();

    public int getJ();

    public T getElement();

    public void setElement(T element);

    @Override
    public String toString();

    @Override
    public boolean equals(Object obj);
}