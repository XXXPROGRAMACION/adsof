package es.uam.eps.ads.p4;

import java.util.Set;
import java.io.*;

public abstract class RecomendadorSerializable implements Recomendador {

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