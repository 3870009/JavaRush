package eu.senla.Task4;

public class Main4 {
    public static void main(String[] args) {
        Matrix mt = new Matrix();
        String[][] matrixStart = mt.makeMatrix();
        mt.zapolnenieMassiva(mt.calcDiagonals(matrixStart));
        mt.printMatrix(matrixStart);
    }
}
