package es.uam.eps.ads.p4;

import java.util.List;
import java.util.ArrayList;

public class Recomendacion {
    private Long usuario;
    private List<Tupla> recomendaciones;

    public Recomendacion(long usuario, List<Tupla> recomendaciones) {
        this.usuario = usuario;
        this.recomendaciones = recomendaciones;
    }
}