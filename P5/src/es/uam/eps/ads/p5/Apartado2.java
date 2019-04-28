package es.uam.eps.ads.p5;

import java.util.Random;
public class Apartado2 {

    public static void main(String[] args) {
        Test1();
        Test2();
        Test3();

        IMatrix<IMatrixElement<Integer>> matrix1 = new Matrix<>(10, 10);
        Random r = new Random();
        try {
            for (int i = 0; i < 10; i++) {
                matrix1.addElement(new MatrixElement<>(r.nextInt(9)+1, r.nextInt(9)+1, r.nextInt(100)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        

        Test4(matrix1);
        Test5(matrix1);
    }

    public static void Test1() {
        try {
            IMatrix<IMatrixElement<Integer>> matrix1 = new Matrix<>(10, 10);
            IMatrix<IMatrixElement<Integer>> matrix2 = new Matrix<>(10, 10);

            IMatrixElement<Integer> e1 = new MatrixElement<>(1, 1, 5);
            IMatrixElement<Integer> e2 = new MatrixElement<>(1, 2, 5);
            IMatrixElement<Integer> e3 = new MatrixElement<>(1, 3, 7);
            IMatrixElement<Integer> e4 = new MatrixElement<>(3, 4, 10);
            IMatrixElement<Integer> e5 = new MatrixElement<>(4, 5, 14);

            matrix1.addElement(e1);
            matrix1.addElement(e2);
            matrix1.addElement(e3);
            matrix1.addElement(e4);
            matrix1.addElement(e5);
            
            matrix2.addElement(e1);
            matrix2.addElement(e2);
            matrix2.addElement(e3);
            matrix2.addElement(e4);

            if (matrix1.equals(matrix2)) {
                System.out.println("Test 1 fallido, las matrices deberian de ser" + 
                                " diferentes\n" + matrix1 + "\n" + matrix2);
            } else {
                System.out.println("Test 1 correcto, las matrices son diferentes");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Test2() {
        try {
            IMatrix<IMatrixElement<Integer>> matrix1 = new Matrix<>(10, 10);
            IMatrix<IMatrixElement<Integer>> matrix2 = new Matrix<>(10, 10);

            IMatrixElement<Integer> e1 = new MatrixElement<>(1, 1, 5);
            IMatrixElement<Integer> e2 = new MatrixElement<>(1, 2, 5);
            IMatrixElement<Integer> e3 = new MatrixElement<>(1, 3, 7);
            IMatrixElement<Integer> e4 = new MatrixElement<>(3, 4, 10);
            IMatrixElement<Integer> e5 = new MatrixElement<>(4, 5, 14);

            matrix1.addElement(e1);
            matrix1.addElement(e2);
            matrix1.addElement(e3);
            matrix1.addElement(e4);
            matrix1.addElement(e5);
            
            matrix2.addElement(e1);
            matrix2.addElement(e2);
            matrix2.addElement(e3);
            matrix2.addElement(e4);
            matrix2.addElement(e5);

            if (!matrix1.equals(matrix2)) {
                System.out.println("Test 2 fallido, las matrices deberian de ser" + 
                                " iguales\n" + matrix1 + "\n" + matrix2);
            } else {
                System.out.println("Test 2 correcto, las matrices son iguales");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Test3() {
        try {
            IMatrix<IMatrixElement<Integer>> matrix1 = new Matrix<>(10, 10);
            IMatrix<IMatrixElement<Integer>> matrix2 = new Matrix<>(10, 10);

            IMatrixElement<Integer> e1 = new MatrixElement<>(1, 1, 5);
            IMatrixElement<Integer> e2 = new MatrixElement<>(1, 2, 5);
            IMatrixElement<Integer> e3 = new MatrixElement<>(1, 3, 7);
            IMatrixElement<Integer> e4 = new MatrixElement<>(3, 4, 10);
            IMatrixElement<Integer> e5 = new MatrixElement<>(4, 5, 14);

            matrix1.addElement(e1);
            matrix1.addElement(e3);
            matrix1.addElement(e4);
            matrix1.addElement(e5);
            
            matrix2.addElement(e2);
            matrix2.addElement(e3);
            matrix2.addElement(e4);
            matrix2.addElement(e5);

            if (matrix1.equals(matrix2)) {
                System.out.println("Test 3 fallido, las matrices deberian de ser" + 
                                " diferentes\n" + matrix1 + "\n" + matrix2);
            } else {
                System.out.println("Test 3 correcto, las matrices son diferentes");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Test4(IMatrix<IMatrixElement<Integer>> matrix1) {
        try {
            System.out.println("Lista de la matriz ordenada por fila: \n" + 
                        matrix1.asListSortedBy(new RowComparator()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Test5(IMatrix<IMatrixElement<Integer>> matrix1) {
        try {
            System.out.println("Lista de la matriz ordenada por columna: \n" + 
                        matrix1.asListSortedBy(new ColComparator()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}