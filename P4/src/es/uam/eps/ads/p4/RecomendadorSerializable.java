package es.uam.eps.ads.p4;

import java.util.Set;
import java.io.*;

/**
 * Esta clase implementa la interfaz recomendador. Define la implementación que
 * permite serializar las recomendaciones generadas para un conjunto de 
 * usuarios, ya que esta es común a los diferentes tipos de recomendador.
 */
public abstract class RecomendadorSerializable implements Recomendador {

    /**
     * Crea en la ruta especificada un fichero con las diferentes
     * recomendaciones, ordenadas por score, generadas para cada uno de los 
     * usuarios indicados.
     * @param ruta Ruta del fichero a generar
     * @param usuarios Conjunto de usuarios a los que recomendar
     * @param longitudRecomendacion Tamaño máximo de cualquier recomendación
     */
    @Override
    public void crearFicheroRecomendaciones(String ruta, Set<Long> usuarios, 
                                            int longitudRecomendacion) {

        try (FileOutputStream stream = new FileOutputStream(ruta);
            OutputStreamWriter writer = new OutputStreamWriter(stream);
            BufferedWriter buffer = new BufferedWriter(writer);) {

            for (long u : usuarios) {
                Recomendacion r = recomienda(u, longitudRecomendacion);

                for (Tupla t : r.getRecomendaciones()) {
                    buffer.write(u + "\t" + t.id + "\t" + t.puntuacion + "\n");
                }
            }
        } catch (IOException e) {
            return;
        } catch (RecomendacionInvalida e) {
            return;
        }
    }
}