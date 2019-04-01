package es.uam.eps.ads.p4;

import java.util.List;
import java.util.ArrayList;

public class Recomendacion {
    private long usuario;
    private List<Tupla> recomendaciones;

    public Recomendacion(long usuario, List<Tupla> recomendaciones) {
        this.usuario = usuario;
        this.recomendaciones = recomendaciones;
    }

    public long getUsuario() {
        return usuario;
    }

    public List<Tupla> getRecomendaciones() {
        return recomendaciones;
    }

    @Override 
    public String toString() {
        return "Recomendacion [usuario=" + usuario + ", recomendaciones="
               + recomendaciones + "]";
    }
}