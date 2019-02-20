package es.uam.eps.ads.p2.apartado5;
import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

/**
 * <p>Esta clase permite operar un sistema para manejar artículos.</p>
 * 
 * @author <p>Alejandro Pascual (alejandro.pascualp@estudiante.uam.es)<br>
 *         Víctor Yrazusta (victor.yrazusta@estudiante.uam.es)</p>
 */
public class Sistema {
    private List<Articulo> articulos = new ArrayList<>();

    /**
     * Permite añadir artículos al sistema.
     * @param articulo Artículo a añadir en el sistema
     */
    public void anadirArticulo(Articulo articulo) {
        articulos.add(articulo);
    }

    /**
     * Permite eliminar artículos del sistema.
     * @param codigoDeBarras Código de barras del artículo a eliminar
     * @return "true" si el elemento se ha eliminado del sistema, o "false" en
     * caso contrario
     */
    public boolean eliminarArticulo(String codigoDeBarras) {
        for (Articulo articulo: articulos) {
            if (Objects.equals(codigoDeBarras, articulo.getCodigoDeBarras())) {
                articulos.remove(articulo);
                return true;
            }
        }
        return false;
    }

    /**
     * Permite encontrar un artículo en el sistema dado su código de barras.
     * @param codigoDeBarras Código de barras del elemento a encontrar
     * @return Artículo encontrado dado el código de barras. 
     */
    public Articulo encontrarArticulo(String codigoDeBarras)  {
        for (Articulo articulo: articulos) {
            if (Objects.equals(codigoDeBarras, articulo.getCodigoDeBarras())) {
                return articulo;
            }
        }
        return null;
    }

    /**
     * Permite comprobar si un código de barras está registrado en el sistema.
     * @param codigoDeBarras Código de barras a buscar
     * @return "true" en caso de que el código de barras esté registrado en el
     * sistema, "false" en caso contrario
     */
    public boolean codigoRegistrado(String codigoDeBarras) {
        for (Articulo articulo: articulos) {
            if (Objects.equals(codigoDeBarras, articulo.getCodigoDeBarras())) {
                return true;
            }
        }
        return false;
    }
}