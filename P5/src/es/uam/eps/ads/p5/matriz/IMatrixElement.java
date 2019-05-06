package es.uam.eps.ads.p5.matriz;

/**
 * Esta interfaz define los métodos elementales de un elemento de matriz.
 * @author Alejandro Pascual y Victor Yrazusta
 */
public interface IMatrixElement<T> {

    /**
     * Devuelve la coordenada i del elemento de matriz.
     * @return Coordenada i del elemento de matriz.
     */
    public int getI();

    /**
     * Devuelve la coordenada j del elemento de matriz.
     * @return Coordenada j del elemento de matriz.
     */
    public int getJ();

    /**
     * Devuelve el elemento del elemento de matriz.
     * @return Elemento del elemento de matriz.
     */
    public T getElement();

    /**
     * Establece el elemento del elemento de matriz.
     * @param element Nuevo elemento del elemento de matriz
     */
    public void setElement(T element);

    /**
     * Convierte las coordenadas y elemento en una cadena.
     * @return Cadena que representa la información del elemento de matriz.
     */
    @Override
    public String toString();

    /**
     * Indica si el objeto pasado como argumento es equivalente a este.
     * @param obj Objeto a comprobar
     * @return Si el objeto pasado como argumento es equivalente a este o no.
     */
    @Override
    public boolean equals(Object obj);
}