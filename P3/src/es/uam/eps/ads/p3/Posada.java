package es.uam.eps.ads.p3;

import java.util.Objects;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>Esta clase permite trabajar con posadas.</p>
 * 
 * @author <p>Alejandro Pascual (alejandro.pascualp@estudiante.uam.es)<br>
 *         Víctor Yrazusta (victor.yrazusta@estudiante.uam.es)</p>
 */
public class Posada {    
    private String nombre;
    private int energiaRecuperada;
    private List<Camino> caminos = new ArrayList<>();
    private List<Explorador> exploradores = new ArrayList<>();
    private Luz luz;

    /**
     * Inicializa una posada dado su nombre. Su energía recuperada en la posada
     * es por defecto 2.
     * @param nombre Nombre de la posada
     */
    public Posada(String nombre) {
        this.nombre = nombre;
        energiaRecuperada = 2;
        luz = Luz.BLANCA;
    }

    /**
     * Inicializa una posada dados su nombre y energía recuperada.
     * @param nombre Nombre de la posada
     * @param energiaRecuperada Energía recuperada en la posada
     */
    public Posada(String nombre, int energiaRecuperada) {
        this(nombre);
        this.energiaRecuperada = energiaRecuperada;
    }

    /**
     * Inicializa una posada dados su nombre, energía recuperada y luz.
     * @param nombre Nombre de la posada
     * @param energiaRecuperada Energía recuperada en la posada
     * @param luz Luz de la posada
     */
    public Posada(String nombre, int energiaRecuperada, Luz luz) {
        this(nombre, energiaRecuperada);
        this.luz = luz;
    }

    /**
     * Añade un camino a la lista de caminos de la posada.
     * @param camino Camino a añadir
     * @return "true" en caso de que se haya añadido el camino correctamente, o
     *         "false", en caso de que no se haya añadido, ya sea porque el 
     *         origen del camino no es la posada, o porque el origen y el
     *         destino de la posada sea el mismo
     */
    public boolean addCamino(Camino camino) {
        if (!Objects.equals(this, camino.getOrigen()) || 
            Objects.equals(this, camino.getDestino())) {
            return false;
        }
        caminos.add(camino);
        return true;
    }

    /**
     * Indica si el camino dado está presente en los caminos de la posada.
     * @param camino Camino a comprobar si está presente
     * @return "true" en caso de que algún camino presente en Caminos sea 
     *         equivalente al camino pasado o "false" en caso contrario
     */
    public boolean existeCamino(Camino camino) {
        for (Camino caminoAux : caminos) {
            if (Objects.equals(caminoAux, camino) == true) return true;
        }
        return false;
    }

    /**
     * Establece la nueva categoría de luz de la posada.
     * @param luz Nueva categoría de luz
     */
    public void cambiarLuz(Luz luz) {
        this.luz = luz;
    }

    /**
     * Devuelve el nombre de la posada.
     * @return Nombre de la posada
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve la energía recuperada en la posada
     * @return Energía recuperada en la posada
     */
    public int getEnergiaRecuperada() {
        return energiaRecuperada;
    }

    /**
     * Devuelve el camino i-ésimo en orden de agregación.
     * @param posicion Posición del camino en orden de agregación
     * @return Camino en la posición especificada
     */
    public Camino getCamino(int posicion) {
        return caminos.get(posicion);
    }
    
    /**
     * Devuelve el camino mínimo que llega a la posada pasada por argumento.
     * @param posada Posada destino del camino a buscar
     * @return El camino con menor coste real que conecta las dos posadas, o 
     *         "null" en caso de que no exista un camino que conecte las dos 
     *         posadas de esta manera
     */
    public Camino getCamino(Posada posada) {
        Camino caminoMin = null;
        for (Camino camino : caminos) {
            if (Objects.equals(camino.getDestino(), posada)) {
                if (caminoMin == null 
                    || camino.getCosteReal() < caminoMin.getCosteReal()) {
                    caminoMin = camino;
                }
            }
        }
        return caminoMin;
    }

    /**
     * Devuelve el numero de caminos que parten de la posada.
     * @return El numero de caminos que parten de la posada
     */
    public int getNumCaminos() {
        return caminos.size();
    }

    /**
     * Devuelve la categoría de luz de la posada.
     * @return Categoría de luz de la posada
     */
    public Luz getLuz() {
        return luz;
    }

    /** 
     * Añade el explorador pasado como argumento a la lista de exploradores 
     * alojados en la posada.
     * @param explorador Explorador a añadir
     */
    public void anadirExplorador(Explorador explorador) {
        if (explorador instanceof Hada) {
            luz = Luz.aumentar(luz);
        } else if (explorador instanceof Hechicero) {
            luz = Luz.reducir(luz);
        }

        exploradores.add(explorador);
    }

    /**
     * Elimina el explorador pasado como argumento de la lista de exploradores
     * alojados en la posada.
     * @param explorador Explorador a eliminar.
     */
    public void eliminarExplorador(Explorador explorador) {
        exploradores.remove(explorador);
    }

    /** 
     * Comprueba si hay algún hada alojada en la posada.
     * @return "true" si hay algún hada alojada en la posada. "false" en caso
     * contrario
     */
    public boolean hayHada() {
        for (Explorador explorador : exploradores) {
            if (explorador instanceof Hada) return true;
        }
        return false;
    }

    /** 
     * Comprueba si hay algún hechicero alojado en la posada.
     * @return "true" si hay algún hechicero alojado en la posada. "false" en 
     * caso contrario
     */
    public boolean hayHechicero() {
        for (Explorador explorador : exploradores) {
            if (explorador instanceof Hechicero) return true;
        }
        return false;
    }

    /**
     * Recoge la información de la instancia en una cadena de caracteres.
     * @return String con el nombre, la energía recuperada y los caminos que 
     *         parten de ella
     */
    @Override
    public String toString() {
        return nombre + "(" + energiaRecuperada + ") (" + luz + ")" + caminos;
    }
    
    /**
     * Compara dos posadas
     * @param posada Posada con la que comparar la instacia
     * @return "true" en caso de que las posadas sean iguales, o "false" en 
     *         caso contrario
     */
    public boolean equals(Posada posada) {
        return Objects.equals(nombre, posada.getNombre());
    }
}