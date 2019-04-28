package es.uam.eps.ads.p5;

import java.util.Comparator;

public class ColComparator implements Comparator<IMatrixElement<Integer>> {

    @Override
    public int compare(IMatrixElement<Integer> a, IMatrixElement<Integer> b) {
        if (a.getJ() != b.getJ()) return a.getJ()-b.getJ();
        return a.getI()-b.getI();
    }
}