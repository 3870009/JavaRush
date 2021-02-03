package eu.senla.Task4;

public class Main4 {

    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        matrix.makeMatrix();
        matrix.calcDiagonals();
        String[] array = matrix.calcDiagonals();
        DiagonalCalc.arrayFilling(array);
        matrix.printMatrix();
    }
}
