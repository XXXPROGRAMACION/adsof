package es.uam.eps.ads.p4;

import java.util.List;
import java.util.ArrayList;
import java.io.*;

public abstract class MetricaDeFichero implements Metrica {

    public double evaluaFicheroRecomendaciones(String ruta, int n) {

        try (FileInputStream stream = new FileInputStream(ruta);
            InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader buffer = new BufferedReader(reader);) {

            double total = 0;
            int nUsuarios = 0;

            long uActual = -1;
            List<Tupla> tActuales = new ArrayList<>();            
            String linea;
            while ((linea = buffer.readLine()) != null) {
                String[] info = linea.split("\\s+");
                if (info.length != 3) {
                    throw new IOException();
                }

                long u = Long.parseLong(info[0]);
                long i = Long.parseLong(info[1]);
                double score = Double.parseDouble(info[2]);

                if (u != uActual) {
                    if (tActuales.size() > 0) {                        
                        try {
                            total += evalua(new Recomendacion(uActual, 
                                            tActuales), n);
                            nUsuarios++;
                        } catch (UsuarioNoRelevante e) {
                            
                        }                        
                    }
                    uActual = u;
                    tActuales.clear();
                }

                tActuales.add(new Tupla(i, score));
            }

            return total/nUsuarios;
        } catch (IOException e) {
            return -1;
        }
    }
}