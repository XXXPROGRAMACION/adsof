package es.uam.eps.ads.p4;

public class Tupla implements Comparable<Tupla> {
    public long id;
    public double puntuacion;
    
    public Tupla(long id, double puntuacion) {
        this.id = id;
        this.puntuacion = puntuacion;
    }

    @Override
    public int compareTo(Tupla tupla) {
        if (puntuacion < tupla.puntuacion) {
            return 1;
        } else if (puntuacion > tupla.puntuacion) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Tupla [elemento=" + id + ", valor=" + puntuacion + "]";
    }
}