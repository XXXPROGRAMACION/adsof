package es.uam.eps.ads.p4;

import java.util.Set;

/**
 * Permite trabajar con métricas que evaluan el desempeño de los recomendadores
 * en sus recomendaciones.
 */
public interface Metrica {
    /**
     * Evalua cuán buena es una recomendación.
     * @param rec Recomendación a evaluar
     * @param n Número de items recomendados a tener en cuenta a la hora de
     *          evaluar la recomendación
     * @return Número del 0 al 1, siendo el 0 la peor calificación de la 
     *         recomendación (no es para nada acertada) y 1 la mejor (es 
     *         totalmente acertada)
     * @throws UsuarioNoRelevante En caso de que no pueda evaluar la 
     *                            recomendación porque no tiene datos 
     *                            del usuario
     */
    public double evalua(Recomendacion rec, int n) throws UsuarioNoRelevante;

    /**
     * Devuelve los items relevantes para un usuario.
     * @param u Usuario a buscar
     * @return Set con los items relevantes para el usuario
     */
    public Set<Long> getItemsRelevantes(long u);

    /**
     * Evalua un fichero de recomendaciones, calificando cada una de ellas.
     * @param ruta Ruta del fichero de recomendaciones a evaluar
     * @param n Número de items recomendados a tener en cuenta a la hora de
     *          evaluar la recomendación
     * @return Número del 0 al 1, siendo el 0 la peor calificación del fichero 
     *         de recomendaciones (no es para nada acertado) y 1 la mejor (es 
     *         totalmente acertado)
     */
    public double evaluaFicheroRecomendaciones(String ruta, int n);
}