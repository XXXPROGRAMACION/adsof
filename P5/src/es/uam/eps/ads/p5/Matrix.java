package es.uam.eps.ads.p5;

import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Matrix<T extends IMatrixElement<?>> implements IMatrix<T> {
    private final int columns;
    private final int rows;
    private Map<Integer, Map<Integer, T>> rowsMap;

    public Matrix(int columns, int rows) {
        this.columns = columns;
        this.rows = rows;
        rowsMap = new TreeMap<>();
    }

    @Override
    public int getCols() {
        return columns;
    }

    @Override
    public int getRows() {
        return rows;
    }

    @Override
    public boolean isLegalPosition(int i, int j) {
        return i < rows && i >= 0 &&
               j < columns && j >= 0;
    }

    @Override
    public void addElement(T element) throws IllegalPositionException {
        if (!isLegalPosition(element.getI(), element.getJ())) {
            throw new IllegalPositionException();
        }

        Map<Integer, T> row = rowsMap.get(element.getI());

        if (row == null) {
            row = new TreeMap<>();
            rowsMap.put(element.getI(), row);
        }

        row.put(element.getJ(), element);
    }

    @Override
    public T getElementAt(int i, int j) throws IllegalPositionException {
        if (!isLegalPosition(i, j)) {
            throw new IllegalPositionException();
        }

        Map<Integer, T> row = rowsMap.get(i);
        if (row == null) return null;

        return row.get(j);
    }

    @Override
    public boolean checkElementAt(int i, int j)
    throws IllegalPositionException {
        if (!isLegalPosition(i, j)) {
            throw new IllegalPositionException();
        }

        Map<Integer, T> row = rowsMap.get(i);
        if (row == null) return false;

        return row.containsKey(j);
    }

    @Override
    public List<T> getNeighboursAt(int i, int j)
    throws IllegalPositionException {
        if (!isLegalPosition(i, j)) {
            throw new IllegalPositionException();
        }

        List<T> list = new ArrayList<>();
        Map<Integer, T> row;
        T e;

        // Obtenemos el vecino superior
        if (isLegalPosition(i-1, j)) {
            row = rowsMap.get(i-1);
            if (row != null) {
                e = row.get(j);
                if (e != null) {
                    list.add(e);
                }
            }
        }

        // Obtenemos los vecinos de la misma fila
        row = rowsMap.get(i);
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
            row = rowsMap.get(i+1);
            if (row != null) {
                e = row.get(j);
                if (e != null) {
                    list.add(e);
                }
            }
        }

        return list;
    }

    public List<T> asList() {
        List<T> list = new ArrayList<>();

        for (Map<Integer, T> row: rowsMap.values()) {
            list.addAll(row.values());
        }
        
        return list;
    }
    
    public List<T> asListSortedBy(Comparator<T> c) {
        List<T> list = asList();
        list.sort(c);
        return list;
    }

    @Override
    public boolean equals(Object a) {
        if (!(a instanceof IMatrix)) return false;
        return asList().equals(((IMatrix<?>) a).asList());
    }

    @Override
    public int hashCode() {
    // Basado en la función de N^2->N de Cantor y en el libro "Effective Java"
    // de Joshua Bloch.
    // https://en.wikipedia.org/wiki/Pairing_function#Cantor_pairing_function
        int hash =  (columns*columns+3*columns
                    +2*columns*rows+rows
                    +rows*rows)/2;
        
        for (int i : rowsMap.keySet()) {
            hash += i*31;
        }

        return hash;
    }
}