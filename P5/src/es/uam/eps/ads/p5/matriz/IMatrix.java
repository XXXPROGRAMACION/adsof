package es.uam.eps.ads.p5.matriz;

import java.util.List;
import java.util.Comparator;

/**
 * Esta interfaz define los métodos elementales de una matriz.
 * @author Alejandro Pascual y Victor Yrazusta
 */
public interface IMatrix<T extends IMatrixElement<?>> {

    /**
     * Devuelve el número de columnas de la matriz.
     * @return Número de columnas de la matriz.
     */
    int getCols();

    /**
     * Devuelve el número de filas de la matriz.
     * @return Número de filas de la matriz.
     */
    int getRows();

    /**
     * Indica si las coordenadas se encuentran en el rango de la matriz.
     * @param i Coordenada i
     * @param j Coordenada j
     * @return Si las coordenadas se encuentran en el rango de la matriz o no.
     */
    boolean isLegalPosition(int i, int j);

    /**
     * Añade un elemento a la matriz, en las coordenadas que este tenga
     * indicadas.
     * @param element Elemento a añadir a la matriz
     * @throws IllegalPositionException Si las coordenadas están fuera de rango.
     */
    void addElement(T element) throws IllegalPositionException;

    /**
     * Devuelve el elemento situado en las coordenadas indicadas.
     * @param i Coordenada i
     * @param j Coordenada j
     * @return Elemento situado en las coordenadas indicadas o null si no hay un
     * elemento en dichas coordenadas.
     * @throws IllegalPositionException Si las coordenadas están fuera de rango.
     */
    T getElementAt(int i, int j) throws IllegalPositionException;

    /**
     * Comprueba si hay un elemento en las coordenadas indicadas.
     * @param i Coordenada i
     * @param j Coordenada j
     * @return Si hay un elemento en las coordenadas indicadas o no.
     * @throws IllegalPositionException Si las coordenadas están fuera de rango.
     */
    boolean checkElementAt(int i, int j) throws IllegalPositionException;

    /**
     * Devuelve una lista con todos los elementos de las casillas vecinas a las
     * coordenadas pasadas como argumento.
     * @param i Coordenada i
     * @param j Coordenada j
     * @return List con todos los elementos de las casillas vecinas a las
     * coordenadas pasadas como argumento.
     * @throws IllegalPositionException Si las coordenadas están fuera de rango.
     */
    List<T> getNeighboursAt(int i, int j) throws IllegalPositionException;

    /**
     * Devuelve una lista con todos los elementos de la matriz.
     * @return Lista con todos los elementos de la matriz.
     */
    List<T> asList();

    /**
     * Devuelve una lista con todos los elementos de la matriz ordenados en base
     * al comparador pasado como argumento.
     * @param c Comparador a utilizar
     * @return Lista con todos los elementos de la matriz ordenados en base al
     * comparador pasado como argumento.
     */
    List<T> asListSortedBy(Comparator<T> c);
}