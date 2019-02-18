package es.uam.eps.ads.p2.figuras;

/**
 * <p>Esta clase permite trabajar con rectángulo como figuras geométricas.</p>
 * 
 * @author <p>Alejandro Pascual (alejandro.pascualp@estudiante.uam.es)<br>
 *         Víctor Yrazusta (victor.yrazusta@estudiante.uam.es)</p>
 */
public class Rectangulo extends Figura {
    double base;
    double altura;

    /**
     * Permite instanciar un rectángulo con una base y una altura dada
     * @param baseTemp Longitud de la base del rectángulo a instanciar
     * @param alturaTemp Longitud de la base del rectángulo a instanciar
     */
    public Rectangulo(double baseTemp, double alturaTemp) {
        base = baseTemp;
        altura = alturaTemp;
    }

    /**
     * Permite convertir la información de un rectángulo 
     * en una cadena de caracteres.
     * @return Cadena de caracteres que recoge la información de la instancia
     */
    public String toString() {
        return "Rectangulo [area=" + getArea() 
                                   + ", perimetro=" + getPerimetro() + "]";
    }

    /**
     * Permite acceder directamente al valor de la base de un rectángulo.
     * @return Longitud de la base del rectángulo
     */
    public double getBase() {
        return base;
    }

    /**
     * Permite acceder directamente al valor de la altura de un rectángulo.
     * @return Valor de la altura del rectángulo
     */
    public double getAltura() {
        return altura;
    }

    /**
     * Permite calcular el perímetro de un rectángulo.
     * @return La longitud del perímetro del rectángulo
     */
    @Override
    public double getPerimetro() {
        return 2*base+2*altura;
    }

    /**
     * Permite calcular el área de un rectángulo.
     * @return El área de rectángulo
     */
    @Override
    public double getArea() {
        return base*altura;
    }

    /**
     * Permite saber si la instancia es un cuadrado (si su base es igual a 
     * su altura).
     * @return Verdadero si la instancia es un cuadrado, y falso en otro lugar.
     */
    public Boolean isCuadrado() {
        return base == altura;
    }
}