package es.uam.eps.ads.p5.matriz;

import java.util.Comparator;

/**
 * Este comparador permite comparar elementos de matriz en base a su columna. 
 * @author Alejandro Pascual y Victor Yrazusta
 */
public class ColComparator implements Comparator<IMatrixElement<Integer>> {

    /**
     * Permite comparar elementos de matriz en base a su columna.
     * @param a Elemento de matriz a
     * @param b Elemento de matriz b
     * @return La columna de a menos la columna de b.
     */
    @Override
    public int compare(IMatrixElement<Integer> a, IMatrixElement<Integer> b) {
        if (a.getJ() != b.getJ()) return a.getJ()-b.getJ();
        return a.getI()-b.getI();
    }
}