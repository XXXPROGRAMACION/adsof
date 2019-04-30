package es.uam.eps.ads.p5;

@FunctionalInterface
interface Function2D<T1, T2, T3> {

    public T3 apply(T1 t1, T2 t2);
}