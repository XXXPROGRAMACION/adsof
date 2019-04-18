package es.uam.eps.ads.p5;

import java.util.List;
import java.util.Comparator;

public interface IMatrix<T> {
    int getCols();
    int getRows();
    boolean isLegalPosition(int i, int j);
    void addElement(IMatrixElement<T> element) 
        throws IllegalPositionException;
    IMatrixElement<T> getElementAt(int i, int j) 
        throws IllegalPositionException;
    boolean checkElementAt(int i, int j)
        throws IllegalPositionException;
    List<IMatrixElement<T>> getNeighboursAt(int i, int j)
        throws IllegalPositionException;
    List<IMatrixElement<T>> asList();
    List<IMatrixElement<T>> asListSortedBy(Comparator<IMatrixElement<T>> c);
}