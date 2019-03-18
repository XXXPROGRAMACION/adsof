package es.uam.eps.ads.p4;

public class Tupla implements Comparable<Tupla> {
    public long id;
    public double puntuacion;
    
    @Override
    public int compareTo(Tupla tupla) {
        if (puntuacion < tupla.puntuacion) {
            return -1;
        } else if (puntuacion > tupla.puntuacion) {
            return 1;
        } else {
            return 0;
        }
    }
}