package es.uam.eps.ads.p5.matriz;

import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Esta clase permite trabajar con matrices que reservan memoria para sus
 * elementos según la van necesitando.
 * @author Alejandro Pascual y Victor Yrazusta
 */
public class Matrix<T extends IMatrixElement<?>> implements IMatrix<T> {
    private final int columns;
    private final int rows;
    private Map<Integer, Map<Integer, T>> rowsMap;

    /**
     * Instancia una matriz dadas sus dimensiones.
     * @param columns Número de columnas de la matriz
     * @param rows Número de filas de la matriz
     */
    public Matrix(int columns, int rows) {
        this.columns = columns;
        this.rows = rows;
        rowsMap = new TreeMap<>();
    }

    /**
     * Devuelve el número de columnas de la matriz.
     * @return Número de columnas de la matriz.
     */
    @Override
    public int getCols() {
        return columns;
    }

    /**
     * Devuelve el número de filas de la matriz.
     * @return Número de filas de la matriz.
     */
    @Override
    public int getRows() {
        return rows;
    }

    /**
     * Indica si las coordenadas se encuentran en el rango de la matriz.
     * @param i Coordenada i
     * @param j Coordenada j
     * @return Si las coordenadas se encuentran en el rango de la matriz o no.
     */
    @Override
    public boolean isLegalPosition(int i, int j) {
        return i < rows && i >= 0 &&
               j < columns && j >= 0;
    }

    /**
     * Añade un elemento a la matriz, en las coordenadas que este tenga
     * indicadas.
     * @param element Elemento a añadir a la matriz
     * @throws IllegalPositionException Si las coordenadas están fuera de rango.
     */
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

    /**
     * Devuelve el elemento situado en las coordenadas indicadas.
     * @param i Coordenada i
     * @param j Coordenada j
     * @return Elemento situado en las coordenadas indicadas o null si no hay un
     * elemento en dichas coordenadas.
     * @throws IllegalPositionException Si las coordenadas están fuera de rango.
     */
    @Override
    public T getElementAt(int i, int j) throws IllegalPositionException {
        if (!isLegalPosition(i, j)) throw new IllegalPositionException();

        Map<Integer, T> row = rowsMap.get(i);
        if (row == null) return null;

        return row.get(j);
    }

    /**
     * Comprueba si hay un elemento en las coordenadas indicadas.
     * @param i Coordenada i
     * @param j Coordenada j
     * @return Si hay un elemento en las coordenadas indicadas o no.
     * @throws IllegalPositionException Si las coordenadas están fuera de rango.
     */
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

    /**
     * Devuelve una lista con todos los elementos de las casillas vecinas a las
     * coordenadas pasadas como argumento.
     * @param i Coordenada i
     * @param j Coordenada j
     * @return List con todos los elementos de las casillas vecinas a las
     * coordenadas pasadas como argumento.
     * @throws IllegalPositionException Si las coordenadas están fuera de rango.
     */
    @Override
    public List<T> getNeighboursAt(int i, int j)
    throws IllegalPositionException {
        if (!isLegalPosition(i, j)) {
            throw new IllegalPositionException();
        }

        List<T> list = new ArrayList<>();
        
        for (int iB = -1; iB <= 1; iB++) {
            for (int jB = -1; jB <= 1; jB++) {
                try {
                    if (iB == 0 && jB == 0) continue;

                    int newI = i+iB;
                    int newJ = j+jB;

                    if (!checkElementAt(newI, newJ)) continue;

                    list.add(getElementAt(newI, newJ));
                } catch(IllegalPositionException e) {
                    continue;
                }
            }
        }

        return list;
    }

    /**
     * Devuelve una lista con todos los elementos de la matriz.
     * @return Lista con todos los elementos de la matriz.
     */
    public List<T> asList() {
        List<T> list = new ArrayList<>();

        for (Map<Integer, T> row: rowsMap.values()) {
            list.addAll(row.values());
        }
        
        return list;
    }
    
    /**
     * Devuelve una lista con todos los elementos de la matriz ordenados en base
     * al comparador pasado como argumento.
     * @param c Comparador a utilizar
     * @return Lista con todos los elementos de la matriz ordenados en base al
     * comparador pasado como argumento.
     */
    public List<T> asListSortedBy(Comparator<T> c) {
        List<T> list = asList();
        list.sort(c);
        return list;
    }

    /**
     * Indica si el objeto pasado como argumento es equivalente a este.
     * @param obj Objeto a comprobar
     * @return Si el objeto pasado como argumento es equivalente a este o no.
     */    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof IMatrix)) return false;
        return asList().equals(((IMatrix<?>) obj).asList());
    }

    /**
     * Calcula y devueve el código hash de la matriz. Cálculo basado en la
     * función N^2 a N de Cantor y en el libro "Effective Java" de Joshua Bloch.
     * https://en.wikipedia.org/wiki/Pairing_function#Cantor_pairing_function
     * @return Código hash de la matriz.
     */
    @Override
    public int hashCode() {
        int hash = (columns*columns
                    +3*columns
                    +2*columns*rows
                    +rows
                    +rows*rows)/2;
        
        for (int i : rowsMap.keySet()) {
            hash += i*31;
        }

        return hash;
    }
}