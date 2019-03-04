package es.uam.eps.ads.p3;

import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class Simulacion {

    List<Posada> posadas = new ArrayList<>();

    public Simulacion(String archivoPosadas, String archivoCaminos, 
                      String archivoExplorador) throws IOException {
        cargarPosadas(archivoPosadas);
    }

    private void cargarPosadas(String archivoPosadas) throws IOException {
        FileInputStream stream = new FileInputStream(archivoPosadas);
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader buffer = new BufferedReader(reader);

        String linea;
        while ((linea = buffer.readLine()) != null) {
            String[] palabras = linea.split("\\s+");
            if (palabras.length == 2) {
                posadas.add(new Posada(palabras[0],
                                       Integer.parseInt(palabras[1])));
            } else {
                buffer.close();
                throw new IOException();
            }
        }

        buffer.close();
    }
}