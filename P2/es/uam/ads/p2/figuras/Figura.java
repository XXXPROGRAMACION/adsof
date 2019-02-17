package es.uam.ads.p2.figuras;

/**
 * <p>Esta clase permite generalizar la estructura y funcionalidades comunes
 * a todas las diferentes figuras a implementar.</p>
 * 
 * @author <p>Alejandro Pascual (alejandro.pascualp@estudiante.uam.es)<br>
 *         Víctor Yrazusta (victor.yrazusta@estudiante.uam.es)</p>
 */
public abstract class Figura {

    /**
     * Permite hallar el perímetro de una figura.
     * @return El perímetro de la figura
     */
    public abstract double getPerimetro();

    /**
     * Permite calcular el área de una figura.
     * @return El área de la figura
     */
    public abstract double getArea();

    /**
     * Permite comparar el área de dos figuras.
     * @param figura Figura con la que se compara el área
     * @return Devuelve falso si el área de la figura pasada como argumento
     * es mayor a la de la instancia a la que pertenece el método, y verdadero
     * en caso contrario.
     */
    public Boolean esMayor(Figura figura) {
        return figura.getArea() <= getArea();
    }
}