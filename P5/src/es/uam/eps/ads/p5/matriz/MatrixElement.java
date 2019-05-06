package es.uam.eps.ads.p5.matriz;

/**
 * Esta clase permite manejar elementos de matriz de un tipo genérico.
 * @author Alejandro Pascual y Victor Yrazusta
 */
public class MatrixElement<T> implements IMatrixElement<T> {
    private int i;
    private int j;
    private T element;

    /**
     * Instancia un elemento de matriz dadas su coordenadas.
     * @param i Coordenada i del elemento de matriz
     * @param j Coordenada j del elemento de matriz
     */
    public MatrixElement(int i, int j) {
        this.i = i;
        this.j = j;
        element = null;
    }

    /**
     * Instancia un elemento de matriz dadas sus coordenadas y su elemento.
     * @param i Coordenada i del elemento de matriz
     * @param j Coordenada j del elemento de matriz
     * @param element Elemento del elemento de la matriz
     */
    public MatrixElement(int i, int j, T element) {
        this.i = i;
        this.j = j;
        this.element = element;
    }

    /**
     * Devuelve la coordenada i del elemento de matriz.
     * @return Coordenada i del elemento de matriz.
     */
    @Override
    public int getI() {
        return i;
    }

    /**
     * Devuelve la coordenada j del elemento de matriz.
     * @return Coordenada j del elemento de matriz.
     */
    @Override
    public int getJ() {
        return j;
    }

    /**
     * Devuelve el elemento del elemento de matriz.
     * @return Elemento del elemento de matriz.
     */
    @Override
    public T getElement() {
        return element;
    }

    /**
     * Establece el elemento del elemento de matriz.
     * @param element Nuevo elemento del elemento de matriz
     */
    @Override
    public void setElement(T element) {
        this.element = element;
    }

    /**
     * Convierte las coordenadas y elemento en una cadena.
     * @return Cadena que representa la información del elemento de matriz.
     */
    @Override
    public String toString() {
        if (element != null) {
            return "(" + i + ", " + j + ") -> " + element;
        } else {
            return "(" + i + ", " + j + ") -> empty";
        }
    }

    /**
     * Indica si el objeto pasado como argumento es equivalente a este.
     * @param obj Objeto a comprobar
     * @return Si el objeto pasado como argumento es equivalente a este o no.
     */
    @Override
    public boolean equals(Object obj) {
       if (!(obj instanceof MatrixElement)) return false;
       MatrixElement<?> e = (MatrixElement<?>) obj;
       return (i == e.i) && (j == e.j) && (element.equals(e.element));
    }
}