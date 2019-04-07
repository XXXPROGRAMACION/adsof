package es.uam.eps.ads.p4;

import java.util.Set;
import java.util.Map;
import java.util.Collections;
import java.util.HashMap;
import java.io.*;

/**
 * Implementa un modelo de datos usando mapas hash.
 */
public class ModeloDatosHash implements ModeloDatos {
    private Map<Long, Map<Long, Double>> usuarios = new HashMap<>();
    private Map<Long, Map<Long, Double>> items = new HashMap<>();
    private boolean lecturaCorrecta = false;

    /**
     * Lee un fichero de preferencias, almacenando los datos de este.
     * @param ruta Ruta del fichero de preferencias
     */
    public void leeFicheroPreferencias(String ruta) {
        lecturaCorrecta = false;
        try (FileInputStream stream = new FileInputStream(ruta);
            InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader buffer = new BufferedReader(reader);) {

            String linea;
            while ((linea = buffer.readLine()) != null) {
                String[] info = linea.split("\\s+");
                if (info.length != 4) {
                    throw new IOException();
                }

                long idUsuario = Long.parseLong(info[0]);
                long idItem = Long.parseLong(info[1]);
                double puntuacion = Double.parseDouble(info[2]);  

                Map<Long, Double> preferenciasUsuario = usuarios.get(idUsuario);
                if (preferenciasUsuario == null) {
                    preferenciasUsuario = new HashMap<>();
                    usuarios.put(idUsuario, preferenciasUsuario);
                }

                preferenciasUsuario.put(idItem, puntuacion);

                Map<Long, Double> preferenciasItem = items.get(idItem);
                if (preferenciasItem == null) {
                    preferenciasItem = new HashMap<>();
                    items.put(idItem, preferenciasItem);
                }

                preferenciasItem.put(idUsuario, puntuacion);
            }

            lecturaCorrecta = true;
        } catch (NumberFormatException e) {
            System.out.println("Error en el formato de un número.");
        } catch (IOException e) {
            System.out.println("Error leyendo preferencias.");
        }
    }

    /**
     * Devuelve las notas que un usuario le ha dado a los diferentes items
     * que ha puntuado.
     * @param usuario Usuario del que se obtendrán sus preferencias
     * @return Mapa de pares item-rating
     */
    public Map<Long, Double> getPreferenciasUsuario(Long usuario) {
        if (usuarios.get(usuario) == null) return new HashMap<>();
        return Collections.unmodifiableMap(usuarios.get(usuario));
    }

    /**
     * Devuelve las notas que le han dado diferentes usuarios a un item.
     * @param item Items del que se obtendrán sus preferencias
     * @return Mapa de pares usuario-rating
     */
    public Map<Long, Double> getPreferenciasItem(Long item) {
        if (items.get(item) == null) return new HashMap<>();
        return Collections.unmodifiableMap(items.get(item));
    }

    /**
     * Devuelve los usuarios del modelo de datos.
     * @return Usuarios del modelo de datos
     */
    public Set<Long> getUsuariosUnicos() {
        return Collections.unmodifiableSet(usuarios.keySet());
    }
    

    /**
     * Devuelve los items del modelo de datos.
     * @return Items del modelo de datos
     */
    public Set<Long> getItemsUnicos() {
        return Collections.unmodifiableSet(items.keySet());
    }

    /**
     * Permite saber si el modelo de datos es correcto o tiene algún problema
     * @return "true" en caso de que sea correcto
     *         "false" en caso de que sea incorrecto
     */
    public boolean getCorrecto() {
        return lecturaCorrecta;
    }
}