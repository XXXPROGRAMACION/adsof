package es.uam.eps.ads.p3;

public class Explorador {
    private String nombre;
    private int energia;
    private Posada posadaActual;

    public Explorador(String nombre, int energia, Posada posadaActual) {
        this.nombre = nombre;
        this.energia = energia;
        this.posadaActual = posadaActual;
    }
}