package es.uam.eps.ads.p5;

public class MatrixElement<T> implements IMatrixElement<T> {
    private int i;
    private int j;
    private T element;

    public MatrixElement(int i, int j) {
        this.i = i;
        this.j = j;
        element = null;
    }

    public MatrixElement(int i, int j, T element) {
        this.i = i;
        this.j = j;
        this.element = element;
    }

    @Override
    public int getI() {
        return i;
    }

    @Override
    public int getJ() {
        return j;
    }

    @Override
    public T getElement() {
        return element;
    }

    @Override
    public void setElement(T element) {
        this.element = element;
    }

    @Override
    public String toString() {
        if (element != null) {
            return "(" + i + ", " + j + ") -> " + element;
        } else {
            return "(" + i + ", " + j + ") -> empty";
        }
    }

    @Override
    public boolean equals(Object obj) {
       if (!(obj instanceof IMatrixElement)) return false;
       MatrixElement<?> e = (MatrixElement<?>) obj;
       return (i == e.i) && (j == e.j) && (element.equals(e.element));
    }
}