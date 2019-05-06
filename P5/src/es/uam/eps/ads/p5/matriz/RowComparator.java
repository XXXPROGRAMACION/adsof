package es.uam.eps.ads.p5.matriz;

import java.util.Comparator;

/**
 * Este comparador permite comparar elementos de matriz en base a su fila. 
 * @author Alejandro Pascual y Victor Yrazusta
 */
public class RowComparator implements Comparator<IMatrixElement<Integer>> {

    /**
     * Permite comparar elementos de matriz en base a su fila.
     * @param a Elemento de matriz a
     * @param b Elemento de matriz b
     * @return La fila de a menos la fila de b.
     */
    @Override
    public int compare(IMatrixElement<Integer> a, IMatrixElement<Integer> b) {
        if (a.getI() != b.getI()) return a.getI()-b.getI();
        return a.getJ()-b.getJ();
    }
}