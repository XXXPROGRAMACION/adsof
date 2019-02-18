package es.uam.eps.ads.p2.figuras;

/**
 * <p>Esta clase permite trabajar con círculos como figuras geométricas.</p>
 * 
 * @author <p>Alejandro Pascual (alejandro.pascualp@estudiante.uam.es)<br>
 *         Víctor Yrazusta (victor.yrazusta@estudiante.uam.es)</p>
 */
public class Circulo extends Figura {
    double radio;

    /**
     * Permite instanciar un círculo con un radio 
     * dado.
     * @param radioTemp Radio del círculo a instanciar
     */
    public Circulo(double radioTemp) {
        radio = radioTemp;
    }

    /**
     * Permite convertir la información de un círculo 
     * en una cadena de caracteres.
     * @return Cadena de caracteres que recoge la información de la instancia
     */
    public String toString() {
        return "Circulo [area=" + getArea() 
                                + ", perimetro=" + getPerimetro() + "]";
    }

    /**
     * Permite hallar directamente el radio de un círculo.
     * @return El valor del radio del círculo.
     */
    public double getRadio() {
        return radio;
    }

    /**
     * Permite calcular el perímetro de un círculo.
     * @return El valor del perímetro del círculo.
     */
    @Override
    public double getPerimetro() {
        return 2*Math.PI*radio;
    }

    /**
     * Permite calcular el área de un círculo.
     * @return El valor del área del círculo.
     */
    @Override
    public double getArea() {
        return Math.PI*Math.pow(radio, 2);
    }    
}