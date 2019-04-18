package es.uam.eps.ads.p5;

import java.util.List;

public class Apartado1 {

    public static void main(String[] args) {
        try {
            IMatrix<Integer> intMatrix = new Matrix<>(6, 7);

            System.out.println("Matriz de enteros:");

            System.out.println(" -> Filas de la matriz: "
                                + intMatrix.getRows());
            System.out.println(" -> Columnas de la matriz: "
                                + intMatrix.getCols());

            if (intMatrix.isLegalPosition(0, 0)) {
                System.out.println(" -> Posicion interna accesible? Si");
            } else {
                System.out.println(" -> Posicion interna accesible? No");
            }

            if (intMatrix.isLegalPosition(100, 100)) {
                System.out.println(" -> Posicion externa accesible? Si");
            } else {
                System.out.println(" -> Posicion externa accesible? No");
            }

            System.out.println(" -> Se anade '1' a la posicion (1, 1)");
            intMatrix.addElement(new MatrixElement<>(1, 1, 1));
            System.out.println(" -> Se anade '2' a la posicion (0, 1)");
            intMatrix.addElement(new MatrixElement<>(0, 1, 2));
            System.out.println(" -> Se anade '3' a la posicion (1, 0)");
            intMatrix.addElement(new MatrixElement<>(1, 0, 3));
            System.out.println(" -> Se anade '4' a la posicion (1, 2)");
            intMatrix.addElement(new MatrixElement<>(1, 2, 4));
            
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

            IMatrix<String> strMatrix = new Matrix<>(4, 8);

            System.out.println("\nMatriz de strings:");

            System.out.println(" -> Filas de la matriz: "
                                + strMatrix.getRows());
            System.out.println(" -> Columnas de la matriz: "
                                + strMatrix.getCols());

            if (strMatrix.isLegalPosition(0, 0)) {
                System.out.println(" -> Posicion interna accesible? Si");
            } else {
                System.out.println(" -> Posicion interna accesible? No");
            }

            if (strMatrix.isLegalPosition(100, 100)) {
                System.out.println(" -> Posicion externa accesible? Si");
            } else {
                System.out.println(" -> Posicion externa accesible? No");
            }

            System.out.println(" -> Se anade 'String 1' a la posicion (1, 1)");
            strMatrix.addElement(new MatrixElement<>(1, 1, "String 1"));
            System.out.println(" -> Se anade 'String 2' a la posicion (0, 1)");
            strMatrix.addElement(new MatrixElement<>(0, 1, "String 2"));
            System.out.println(" -> Se anade 'String 3' a la posicion (1, 0)");
            strMatrix.addElement(new MatrixElement<>(1, 0, "String 3"));
            System.out.println(" -> Se anade 'String 4' a la posicion (1, 2)");
            strMatrix.addElement(new MatrixElement<>(1, 2, "String 4"));
            
            String s = strMatrix.getElementAt(1, 1).getElement();
            System.out.println(" -> El valor encontrado en (1, 1) es " + s);

            List<IMatrixElement<String>> nS = strMatrix.getNeighboursAt(1, 1);
            System.out.println(" -> Los vecinos de (1, 1) son:");
            for (IMatrixElement<String> e : nS) {
                s = e.getElement();
                System.out.println(" ---> " + s);
            }

            nS = strMatrix.asList();
            System.out.println(" -> Los elementos de la matriz son:");
            for (IMatrixElement<String> e : nS) {
                s = e.getElement();
                System.out.println(" ---> " + s);
            }
        } catch (IllegalPositionException e) {
            System.out.println("Error en el acceso a posición");
        }        
    }
}