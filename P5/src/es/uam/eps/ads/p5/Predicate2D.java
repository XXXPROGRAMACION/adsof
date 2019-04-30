package es.uam.eps.ads.p5;

@FunctionalInterface
interface Predicate2D<T1, T2> {

    public boolean test(T1 t1, T2 t2);
}