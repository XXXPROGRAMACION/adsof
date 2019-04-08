package es.uam.eps.ads.p5;

public interface IMatrix<T> {
    int getCols();
    int getRows();
    boolean isLegalPosition(int i, int j);
    void addElement(IMatrizElement<T> element) throws IllegalPositionException;
    IMatrixElement<T> get
}