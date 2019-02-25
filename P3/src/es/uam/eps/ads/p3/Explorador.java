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

    public boolean recorre(Camino camino) {
        if (!posadaActual.existeCamino(camino)
            || !puedeRecorrerCamino(camino)
            || !puedeAlojarseEn(camino.getDestino())) return false;
               
        posadaActual = camino.getDestino();
        energia = energia-camino.getCoste()+posadaActual.getEnergiaRecuperada(); 

        return true;
    }

    private boolean puedeRecorrerCamino(Camino camino) {
        return camino.getCoste() <= energia;
    }

    private boolean puedeAlojarseEn(Posada posada) {
        return true;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEnergia() {
        return energia;
    }

    public Posada getPosadaActual() {
        return posadaActual;
    }

    public String toString() {
        return nombre + " (e:" + energia + ") en " + posadaActual.getNombre();
    }
}