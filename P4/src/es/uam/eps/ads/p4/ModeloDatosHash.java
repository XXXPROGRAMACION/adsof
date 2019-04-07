package es.uam.eps.ads.p4;

import java.util.Set;
import java.util.Map;
import java.util.Collections;
import java.util.HashMap;
import java.io.*;

public class ModeloDatosHash implements ModeloDatos {
    private Map<Long, Map<Long, Double>> usuarios = new HashMap<>();
    private Map<Long, Map<Long, Double>> items = new HashMap<>();
    private boolean lecturaCorrecta = false;

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

    public Map<Long, Double> getPreferenciasUsuario(Long usuario) {
        if (usuarios.get(usuario) == null) return new HashMap<>();
        return Collections.unmodifiableMap(usuarios.get(usuario));
    }

    public Map<Long, Double> getPreferenciasItem(Long item) {
        if (items.get(item) == null) return new HashMap<>();
        return Collections.unmodifiableMap(items.get(item));
    }

    public Set<Long> getUsuariosUnicos() {
        return Collections.unmodifiableSet(usuarios.keySet());
    }
    
    public Set<Long> getItemsUnicos() {
        return Collections.unmodifiableSet(items.keySet());
    }

    public boolean getCorrecto() {
        return lecturaCorrecta;
    }
}