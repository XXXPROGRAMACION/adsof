package es.uam.eps.ads.p5;

import java.util.List;

public class Apartado1 {

    public static void main(String[] args) {
        try {
            IMatrix<Integer> intMatrix = new SparseMatrix<>(4, 8);

            System.out.println("Matriz de enteros:");

            System.out.println(" -> Filas de la matriz: "
                                + intMatrix.getRows());
            System.out.println(" -> Columnas de la matriz: "
                                + intMatrix.getCols());

            if (intMatrix.isLegalPosition(0, 0)) {
                System.out.println(" -> ¿Posición interna accesible? Sí");
            } else {
                System.out.println(" -> ¿Posición interna accesible? No");
            }

            if (intMatrix.isLegalPosition(100, 100)) {
                System.out.println(" -> ¿Posición externa accesible? Sí");
            } else {
                System.out.println(" -> ¿Posición externa accesible? No");
            }

            System.out.println(" -> Se añade '1' a la posición (1, 1)");
            intMatrix.addElement(new IMatrixElementC<>(1, 1, 1));
            System.out.println(" -> Se añade '2' a la posición (0, 1)");
            intMatrix.addElement(new IMatrixElementC<>(0, 1, 2));
            System.out.println(" -> Se añade '3' a la posición (1, 0)");
            intMatrix.addElement(new IMatrixElementC<>(1, 0, 3));
            System.out.println(" -> Se añade '4' a la posición (1, 2)");
            intMatrix.addElement(new IMatrixElementC<>(1, 2, 4));
            
            int v = intMatrix.getElementAt(1, 1).getElement();
            System.out.println(" -> El valor encontrado en (1, 1) es " + v);

            List<IMatrixElement<Integer>> n = intMatrix.getNeighboursAt(1, 1);
            System.out.println(" -> Los vecinos de (1, 1) son:");
            for (IMatrixElement<Integer> e : n) {
                v = e.getElement();
                System.out.println(" ---> " + v);
            }

            n = intMatrix.asList();
            System.out.println(" -> Los elementos de la matriz son:");
            for (IMatrixElement<Integer> e : n) {
                v = e.getElement();
                System.out.println(" ---> " + v);
            }
        } catch (IllegalPositionException e) {
            System.out.println("Error en el acceso a posición");
        }        
    }
}