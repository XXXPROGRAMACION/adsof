package es.uam.eps.ads.p5.simulador;

/**
 * Esta interfaz funcional tiene el mismo uso que Predicate, pero recibe dos
 * argumentos.
 * @author Alejandro Pascual y Victor Yrazusta
 */
@FunctionalInterface
public interface Predicate2D<T1, T2> {

    /**
     * Define la función de la interfaz funcional.
     * @param t1 Argumento de tipo T1
     * @param t2 Argumento de tipo T2
     * @return Retorno de tipo boolean
     */
    public boolean test(T1 t1, T2 t2);
}