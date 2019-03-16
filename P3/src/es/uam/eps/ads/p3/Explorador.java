package es.uam.eps.ads.p3;

/**
 * <p>Esta clase permite trabajar con exploradores.</p>
 * 
 * @author <p>Alejandro Pascual (alejandro.pascualp@estudiante.uam.es)<br>
 *         Víctor Yrazusta (victor.yrazusta@estudiante.uam.es)</p>
 */
public class Explorador {
    protected String nombre;
    protected int energia;
    protected Posada posadaActual;

     /**
     * Inicializa un explorador dadas sus características.
     * @param nombre Nombre del explorador
     * @param energia Energia del explorador
     * @param posadaActual Posada actual del explorador
     */
    public Explorador(String nombre, int energia, Posada posadaActual) {
        this.nombre = nombre;
        this.energia = energia;
        this.posadaActual = posadaActual;
    }

    /**
     * Hace recorrer al explorador el camino pasado como argumento, haciendo los
     * cambios necesarios en su energía y localización. El retorno indica si se
     * ha podido realizar el proceso o no.
     * @param camino Camino a recorrer por el explorador
     * @return "true" si el camino pasado es un camino válido presente en la 
     *         posada actual y el explorador puede recorrerlo y alojarse en la 
     *         posada destino. "false" en caso contrario.
     */
    public boolean recorre(Camino camino) {        
        Posada destino = camino.getDestino();
        
        if (!posadaActual.existeCamino(camino) || !puedeRecorrerCamino(camino)
            || !puedeAlojarseEn(destino)) return false;
               
        posadaActual = destino;
        energia = energia-camino.getCoste()+destino.getEnergiaRecuperada(); 

        return true;
    }

    /** 
     * Dado un número variable de posadas se intenta una a una ir desde la
     * posada actual hasta ella, haciendo los cambios necesarios en su energía y
     * localización. El retorno indica si se ha podido realizar el proceso o no.
     * @param posadas Número variable de posadas a visitar.
     * @return "true" si en todos los casos existía un camino que pudiese llevar
     *         al viajero a la posada correspondiente y si este podía siempre 
     *         recorrerlo y alojarse en esta. "false" en caso contrario.
     */
    public boolean recorre(Posada ... posadas) {
        boolean flag = true;        
        for (Posada posada : posadas) {
            Camino caminoAux = posadaActual.getCamino(posada);
            if (caminoAux == null || recorre(caminoAux) == false) flag = false;
        }
        return flag;
    }

    /**
     * Indica si el explorador puede recorrer el camino pasado como argumento,
     * basándose en el coste del camino y la energía del explorador.
     * @param camino Camino para el que hacer la comprobación
     * @return "true" si tiene suficiente energía. "false" en caso contrario
     */
    private boolean puedeRecorrerCamino(Camino camino) {
        return camino.getCoste() <= energia;
    }

    /**
     * Indica si el explorador puede alojarse en la posada pasada como
     * argumento, lo cual es posible de manera predeterminada.
     * @param posada Posada para la que hacer la comprobación
     * @return "true" como valor predeterminado.
     */
    private boolean puedeAlojarseEn(Posada posada) {
        return true;
    }

    /** 
     * Devuelve el nombre del explorador.
     * @return Nombre del explorador
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve la energía del explorador.
     * @return Energía del explorador
     */
    public int getEnergia() {
        return energia;
    }

    /**
     * Devuelve la posada actual del explorador.
     * @return Posada actual del explorador
     */
    public Posada getPosadaActual() {
        return posadaActual;
    }

    /**
     * Recoge la información de la instancia en una cadena de caracteres.
     * @return String con el nombre, la energía y la posada actual del 
     *         explorador
     */
    @Override
    public String toString() {
        return nombre + " (e:" + energia + ") en " + posadaActual.getNombre();
    }
}