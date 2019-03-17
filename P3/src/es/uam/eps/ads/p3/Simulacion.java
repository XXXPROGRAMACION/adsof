package es.uam.eps.ads.p3;

import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.util.Objects;

/**
 * <p>Esta clase permite trabajar con simulaciones.</p>
 * 
 * @author <p>Alejandro Pascual (alejandro.pascualp@estudiante.uam.es)<br>
 *         Víctor Yrazusta (victor.yrazusta@estudiante.uam.es)</p>
 */
public class Simulacion {

    List<Posada> posadas = new ArrayList<>();
    List<Explorador> exploradores = new ArrayList<>();
    Explorador exploradorActual;

    /**
     * Inicializa una simulación con los nombres de sus ficheros.
     * @param archivoPosadas El nombre del fichero con la información de posadas
     * @param archivoCaminos El nombre del fichero con la información de caminos
     * @param archivoExplorador El nombre del fichero con la información del
     *                          explorador, así como las posadas a recorrer
     * @throws IOException En caso de que alguna de sus funciones lo lance
     */
    public Simulacion(String archivoPosadas, String archivoCaminos, 
                      String archivoExplorador) throws IOException {
        cargarPosadas(archivoPosadas);
        cargarCaminos(archivoCaminos);
        ejecutarSimulacion(archivoExplorador);
    }

    /**
     * Carga todas las posadas descritas en el archivo indicado.
     * @param archivoPosadas Nombre del fichero con la información de posadas
     * @throws IOException En caso de no existir el fichero que define las
     *                     posadas, estar este mal definido o producirse un 
     *                     error en su lectura
     */
    private void cargarPosadas(String archivoPosadas) throws IOException {
        FileInputStream stream = new FileInputStream(archivoPosadas);
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader buffer = new BufferedReader(reader);

        String linea;
        while ((linea = buffer.readLine()) != null) {
            String[] palabras = linea.split("\\s+");

            if (palabras.length != 2 && palabras.length != 3) {
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

            if (palabras.length == 2) {
                posadas.add(new Posada(palabras[0], energia));
            } else {
                int nivelLuz = -1;
                try {
                    energia = Integer.parseInt(palabras[2]);
                } catch (NumberFormatException e) {
                    buffer.close();
                    throw new IOException();
                }
                Luz luz = Luz.getLuz(nivelLuz);
                if (luz == null) {
                    buffer.close();
                    throw new IOException();
                }

                posadas.add(new Posada(palabras[0], energia, luz));
            }            
        }

        buffer.close();
    }

    /**
     * Devuelve una posada presente en la simulación dado su nombre.
     * @param nombrePosada El nombre de la posada que se busca obtener
     * @return La posada presente en la simulación con el nombre indicado o 
     *         "null" en caso de no encontrarse
     */
    private Posada buscarPosada(String nombrePosada) {
        for (Posada posada : posadas) {
            if (Objects.equals(posada.getNombre(), nombrePosada)) {
                return posada;
            }
        }
        return null;
    }

    /**
     * Carga todos los caminos descritos en el archivo indicado.
     * @param archivoCaminos Nombre del fichero con la información de caminos
     * @throws IOException En caso de no existir el fichero que define los
     *                     caminos, estar este mal definido o producirse un 
     *                     error en su lectura
     */
    private void cargarCaminos(String archivoCaminos) throws IOException {
        FileInputStream stream = new FileInputStream(archivoCaminos);
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader buffer = new BufferedReader(reader);

        String linea;
        while ((linea = buffer.readLine()) != null) {
            String[] palabras = linea.split("\\s+");

            if (palabras.length != 3 && palabras.length != 5) {
                buffer.close();
                throw new IOException();
            }

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

            if (palabras.length == 3) {
                origen.addCamino(new Camino(origen, destino, coste));
            } else {
                float costeExtra;
                try {
                    costeExtra = Float.parseFloat(palabras[3]);
                } catch (NumberFormatException e) {
                    buffer.close();
                    throw new IOException();
                }

                float probabilidadRetorno;
                try {
                    probabilidadRetorno = Float.parseFloat(palabras[4]);
                } catch (NumberFormatException e) {
                    buffer.close();
                    throw new IOException();
                }

                origen.addCamino(new Trampa(origen, destino, coste,
                                    costeExtra, probabilidadRetorno));
            }
        }

        buffer.close();
    }

    /**
     * Carga el explorador descrito en el fichero indicado y recorrer las
     * posadas en el orden especificado.
     * @param archivoExplorador Nombre del fichero con la información del
     *                          explorador, así como las posadas a recorrer
     * @throws IOException En caso de no existir el fichero que define al
     *                     explorador y el recorrido, estar este mal definido o 
     *                     producirse un error en su lectura
     */
    private void ejecutarSimulacion(String archivoExplorador) 
    throws IOException {
        FileInputStream stream = new FileInputStream(archivoExplorador);
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader buffer = new BufferedReader(reader);

        String linea;
        while ((linea = buffer.readLine()) != null) {
            String[] palabras = linea.split("\\s+");

            if (palabras.length == 3 || palabras.length == 5) {
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

                if (palabras.length == 3) {
                    exploradorActual = new Explorador(palabras[0], energia,
                                                posadaActual);
                } else {
                    int tipoMago;
                    try {
                        tipoMago = Integer.parseInt(palabras[3]);
                    } catch (NumberFormatException e) {
                        buffer.close();
                        throw new IOException();
                    }
                    if (tipoMago < 1 || tipoMago > 2) {
                        buffer.close();
                        throw new IOException();
                    }

                    int poder;
                    try {
                        poder = Integer.parseInt(palabras[4]);
                    } catch (NumberFormatException e) {
                        buffer.close();
                        throw new IOException();
                    }

                    if (tipoMago == 1) {
                        exploradorActual = new Hada(palabras[0], energia, 
                                            posadaActual, poder);
                    } else {
                        exploradorActual = new Hechicero(palabras[0], energia, 
                                            posadaActual, poder);
                    }
                }
                exploradores.add(exploradorActual);
            } else if (palabras.length == 2) {
                if (!Objects.equals(palabras[0], "E")) {
                    buffer.close();
                    throw new IOException();
                }

                int indice;
                try {
                    indice = Integer.parseInt(palabras[1]);
                } catch (NumberFormatException e) {
                    buffer.close();
                    throw new IOException();
                }

                if (indice < 1 || indice > exploradores.size()) {
                    buffer.close();
                    throw new IOException();
                }

                exploradorActual = exploradores.get(indice-1);
            } else if (palabras.length == 1) {
                Posada siguientePosada = buscarPosada(palabras[0]);
                if (siguientePosada == null) {
                    buffer.close();
                    throw new IOException();
                }

                exploradorActual.recorre(siguientePosada);

                System.out.println(exploradorActual);
            } else {
                buffer.close();
                throw new IOException();
            }
        }

        buffer.close();
    }
}