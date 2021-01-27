package eu.senla.Task4;

public class Main4 {
    public static void main(String[] args) {
        Matrix mt = new Matrix();
        String[][] matrixNach = mt.makeMatrix();
        mt.zapolnenieMassiva(mt.calcDiagonals(matrixNach));
        mt.printMatrix(matrixNach);
    }
}
