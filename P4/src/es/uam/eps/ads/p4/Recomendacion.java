package es.uam.eps.ads.p4;

import java.util.List;

/**
 * Encapsula la información de una recomendación.
 */
public class Recomendacion {
    private long usuario;
    private List<Tupla> recomendaciones;

    /**
     * Instacia una recomendación dado el usuario y las recomendaciones que 
     * se le realizan.
     * @param usuario Usuario al que se dirige la recomendación
     * @param recomendaciones Lista de recomendaciones que se realizan al
     *                        usuario
     */
    public Recomendacion(long usuario, List<Tupla> recomendaciones) {
        this.usuario = usuario;
        this.recomendaciones = recomendaciones;
    }

    /**
     * Devuelve el usuario al que se dirige la recomendación.
     * @return Usuario al que se dirige la recomendación
     */
    public long getUsuario() {
        return usuario;
    }

    /**
     * Devuelve las recomendaciones almacenadas en la recomendación.
     * @return Lista de tuplas con las recomendaciones realizadas al usuario
     */
    public List<Tupla> getRecomendaciones() {
        return recomendaciones;
    }

    /**
     * Recoge la información de la instancia en un String
     * @return String con la información de la instancia
     */
    @Override 
    public String toString() {
        return "Recomendacion [usuario=" + usuario + ", recomendaciones="
               + recomendaciones + "]";
    }
}