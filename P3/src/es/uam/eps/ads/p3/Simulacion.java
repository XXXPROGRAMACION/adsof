package es.uam.eps.ads.p3;

import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.util.Objects;

public class Simulacion {

    List<Posada> posadas = new ArrayList<>();

    public Simulacion(String archivoPosadas, String archivoCaminos, 
                      String archivoExplorador) throws IOException {
                          
        cargarPosadas(archivoPosadas);
        cargarCaminos(archivoCaminos);
        ejecutarSimulacion(archivoExplorador);
    }

    private void cargarPosadas(String archivoPosadas) throws IOException {
        FileInputStream stream = new FileInputStream(archivoPosadas);
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader buffer = new BufferedReader(reader);

        String linea;
        while ((linea = buffer.readLine()) != null) {
            String[] palabras = linea.split("\\s+");
            if (palabras.length == 2) {
                int energia;
                try {
                    energia = Integer.parseInt(palabras[1]);
                } catch (NumberFormatException e) {
                    buffer.close();
                    throw new IOException();
                }
                posadas.add(new Posada(palabras[0], energia));
            } else {
                buffer.close();
                throw new IOException();
            }
        }

        buffer.close();
    }

    private Posada buscarPosada(String nombrePosada) {
        for (Posada posada : posadas) {
            if (Objects.equals(posada.getNombre(), nombrePosada)) {
                return posada;
            }
        }
        return null;
    }

    private void cargarCaminos(String archivoCaminos) throws IOException {
        FileInputStream stream = new FileInputStream(archivoCaminos);
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader buffer = new BufferedReader(reader);

        String linea;
        while ((linea = buffer.readLine()) != null) {
            String[] palabras = linea.split("\\s+");

            if (palabras.length == 3) {
                Posada origen = buscarPosada(palabras[0]);
                if (origen == null) {
                    buffer.close();
                    throw new IOException();
                }

                Posada destino = buscarPosada(palabras[1]);
                if (destino == null) {
                    buffer.close();
                    throw new IOException();
                }

                int coste;
                try {
                    coste = Integer.parseInt(palabras[2]);
                } catch (NumberFormatException e) {
                    buffer.close();
                    throw new IOException();
                }
                origen.addCamino(new Camino(origen, destino, coste));
            } else {
                buffer.close();
                throw new IOException();
            }
        }

        buffer.close();
    }

    private void ejecutarSimulacion(String archivoExplorador) 
    throws IOException {
        FileInputStream stream = new FileInputStream(archivoExplorador);
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader buffer = new BufferedReader(reader);

        String linea = buffer.readLine();
        if (linea == null) {
            buffer.close();
            throw new IOException();
        }

        String[] palabras = linea.split("\\s+");
        if (palabras.length != 3) {
            buffer.close();
            throw new IOException();
        }

        int energia;
        try {
            energia = Integer.parseInt(palabras[1]);
        } catch (NumberFormatException e) {
            buffer.close();
            throw new IOException();
        }
        
        Posada posadaActual = buscarPosada(palabras[2]);
        if (posadaActual == null) {
            buffer.close();
            throw new IOException();
        }

        Explorador explorador = new Explorador(palabras[0], energia, 
                                               posadaActual);

        String nombrePosada;
        while ((nombrePosada = buffer.readLine()) != null) {
            Posada siguientePosada = buscarPosada(nombrePosada);
            if (siguientePosada == null) {
                buffer.close();
                throw new IOException();
            }

            explorador.recorre(siguientePosada);

            System.out.println(explorador);
        }

        buffer.close();
    }
}