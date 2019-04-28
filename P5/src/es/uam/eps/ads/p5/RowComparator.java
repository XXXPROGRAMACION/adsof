package es.uam.eps.ads.p5;

import java.util.Comparator;

public class RowComparator implements Comparator<IMatrixElement<Integer>> {

    @Override
    public int compare(IMatrixElement<Integer> a, IMatrixElement<Integer> b) {
        if (a.getI() != b.getI()) return a.getI()-b.getI();
        return a.getJ()-b.getJ();
    }
}