import java.util.SortedSet;
import java.util.TreeSet;

/**
 * <h2>Práctica 1. Análisis y diseño de Software, grupo 2213.</h2>
 * 
 * <p>Implementados tanto el apartado 4 como el 5.</p>
 * 
 * <p>Esta clase permite determinar la primalidad de un entero dado,
 * así como enumerar los primos hasta ese mismo número.
 * En caso de que el número pasado no sea primo se podrán
 * calcular también sus divisores.</p>
 * 
 * @author <p>Alejandro Pascual (alejandro.pascualp@estudiante.uam.es)<br>
 *         Víctor Yrazusta (victor.yrazusta@estudiante.uam.es)</p>
 */
public class Primos {
    private int max = 1;
    private SortedSet<Integer> primos = new TreeSet<>();

    public String toString() {
        return "Primos hasta " + max + " = " + primos;
    }

    /**
     * Permite determinar la primalidad de un número.
     * @param n Número a procesar
     * @return Primalidad de n
     */
    public boolean esPrimo(int n) {
        if (n < 2) return false;
        if (n > max) actualizaPrimos(n);
        return primos.contains(n);
    }

    /**
     * Actualiza la lista de primos, añadiendo todos los que encuentre hasta
     * el número especificado como argumento.
     * @param n Número hasta el que actualizar la lista de primos
     */
    private void actualizaPrimos(int n) {
        for (int i = max+1; i <= n; i++) {
            if (compruebaPrimo(i)) primos.add(i);
        }
        max = n;
    }

    /**
     * Comprueba la primalidad del entero pasado como argumento,
     * en base a la lista de primos ya encontrados.
     * @param n Número a procesar
     * @return Primalidad de n
     */
    private Boolean compruebaPrimo(int n) {
        for (int p: primos) {
            if (n%p == 0) return false;
        }
        return true;
    }

    /**
     * Calcula los divisores de un entero pasado como argumento.
     * @param n Número cuyos divisores quieren ser calculados
     * @return Conjunto ordenado en orden creciente de los divisores de n
     */
    public SortedSet<Integer> divisoresPrimo(int n) {
        SortedSet<Integer> divisores = new TreeSet<>();
        actualizaPrimos(n);
        for (int p: primos) {
            if (n%p == 0) divisores.add(p);
        }
        return divisores;
    }

    /**
     * Acepta un parámetro como entrada. Imprime en pantalla si es un
     * número primo, así como los números primos menores o iguales a él.
     * También imprime los divisores del número en caso de que este no
     * sea primo.
     * @param args Array de strings cuyo primer elemento es 
     *             el número a procesar.
     */
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Primos primos = new Primos();
        if (primos.esPrimo(n)) System.out.println(n + " es primo.");
        else {
            System.out.println(n + " no es primo.");
            System.out.println("Sus divisores son: " 
                               + primos.divisoresPrimo(n));
        }
        System.out.println(primos);
    }
}