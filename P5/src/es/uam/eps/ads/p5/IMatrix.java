package es.uam.eps.ads.p5;

import java.util.List;
import java.util.Comparator;

public interface IMatrix<T extends IMatrixElement<?>> {

    int getCols();

    int getRows();

    boolean isLegalPosition(int i, int j);

    void addElement(T element) throws IllegalPositionException;

    T getElementAt(int i, int j) throws IllegalPositionException;

    boolean checkElementAt(int i, int j) throws IllegalPositionException;

    List<T> getNeighboursAt(int i, int j) throws IllegalPositionException;

    List<T> asList();
    
    List<T> asListSortedBy(Comparator<T> c);
}