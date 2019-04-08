package es.uam.eps.ads.p5;

import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;

public class SparseMatrix<T> implements IMatrix<T> {
    private final int numberOfColumns;
    private final int numberOfRows;
    private Map<Integer, Map<Integer, IMatrixElement<T>>> rows;

    public SparseMatrix(int numberOfColumns, int numberOfRows) {
        this.numberOfColumns = numberOfColumns;
        this.numberOfRows = numberOfRows;
        rows = new TreeMap<>();
    }

    @Override
    public int getCols() {
        return numberOfColumns;
    }

    @Override
    public int  getRows() {
        return numberOfRows;
    }

    @Override
    public boolean isLegalPosition(int i, int j) {
        return i < numberOfRows && i >= 0 &&
               j < numberOfColumns && j >= 0;
    }

    @Override
    public void addElement(IMatrixElement<T> element) 
        throws IllegalPositionException {
        if (!isLegalPosition(element.getI(), element.getJ())) {
            throw new IllegalPositionException();
        }

        Map<Integer,IMatrixElement<T>> row = rows.get(element.getI());

        if (row == null) {
            row = new TreeMap<>();
        }

        IMatrixElement<T> e = row.get(element.getJ());
        if (e != null) {
            e.setElement(element.getElement());
        } else {
            e = new IMatrixElementC<>(element.getI(), element.getJ());
            row.put(element.getJ(), e);
        }
    }

    @Override
    public IMatrixElement<T> getElementAt(int i, int j) 
        throws IllegalPositionException {
        if (!isLegalPosition(i, j)) {
            throw new IllegalPositionException();
        }

        Map<Integer, IMatrixElement<T>> row = rows.get(i);
        if (row == null) return null;

        return row.get(j);
    }

    @Override
    public List<IMatrixElement<T>> getNeighboursAt(int i, int j)
        throws IllegalPositionException {
        if (!isLegalPosition(i, j)) {
            throw new IllegalPositionException();
        }

        List<IMatrixElement<T>> list = new ArrayList<>();
        Map<Integer, IMatrixElement<T>> row;
        IMatrixElement<T> e;

        // Obtenemos el vecino superior
        if (isLegalPosition(i-1, j)) {
            row = rows.get(i-1);
            if (row != null) {
                e = row.get(j);
                if (e != null) {
                    list.add(e);
                }
            }
        }

        // Obtenemos los vecinos de la misma fila
        row = rows.get(i);
        if (row != null) {
            if (isLegalPosition(i, j-1)) {
                e = row.get(j-1);
                if (e != null) {
                    list.add(e);
                }
            }
            if (isLegalPosition(i, j+1)) {
                e = row.get(j+1);
                if (e != null) {
                    list.add(e);
                }
            }
        }

        // Obtenemos el vecino inferior
        if (isLegalPosition(i+1, j)) {
            row = rows.get(i+1);
            if (row != null) {
                e = row.get(j);
                if (e != null) {
                    list.add(e);
                }
            }
        }

        return list;
    }

    public List<IMatrixElement<T>> asList() {
        List<IMatrixElement<T>> list = new ArrayList<>();

        for (Map<Integer, IMatrixElement<T>> row: rows.values()) {
            list.addAll(row.values());
        }
        
        return list;
    }
}