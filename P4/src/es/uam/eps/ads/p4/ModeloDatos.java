package es.uam.eps.ads.p4;

import java.util.Map;
import java.util.Set;

/**
 * Permite trabajar con modelos de datos que almacenan información sobre los
 * usuarios y sus items
 */
public interface ModeloDatos {
    /**
     * Lee un fichero de preferencias, almacenando los datos de este.
     * @param ruta Ruta del fichero de preferencias
     */
    public void leeFicheroPreferencias(String ruta);

    /**
     * Devuelve las notas que un usuario le ha dado a los diferentes items
     * que ha puntuado.
     * @param usuario Usuario del que se obtendrán sus preferencias
     * @return Mapa de pares item-rating
     */
    public Map<Long, Double> getPreferenciasUsuario(Long usuario);

    /**
     * Devuelve las notas que le han dado diferentes usuarios a un item.
     * @param item Items del que se obtendrán sus preferencias
     * @return Mapa de pares usuario-rating
     */
    public Map<Long, Double> getPreferenciasItem(Long item);

    /**
     * Devuelve los usuarios del modelo de datos.
     * @return Usuarios del modelo de datos
     */
    public Set<Long> getUsuariosUnicos();

    /**
     * Devuelve los items del modelo de datos.
     * @return Items del modelo de datos
     */
    public Set<Long> getItemsUnicos();

    /**
     * Permite saber si el modelo de datos es correcto o tiene algún problema
     * @return "true" en caso de que sea correcto
     *         "false" en caso de que sea incorrecto
     */
    public boolean getCorrecto();
}