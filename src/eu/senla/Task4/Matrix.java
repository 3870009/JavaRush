package eu.senla.Task4;

import java.util.Random;

public class Matrix {
    public String[][] matr = new String[10][10];

    public String[][] makeMatrix() {
       // String[][] matr = new String[10][10];
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[i].length; j++) {
                if (j == 0 || j == 3 || j == 6 || j == 9) {
                    matr[i][j] =MatrixCalc.makeRandomStringDouble(1,3);
                } else {
                    matr[i][j] = MatrixCalc.makeRandomString();
                }
            }
        }
        return matr;
    }

    public void printMatrix() {
        System.out.println("");
        System.out.println("Первоначальная матрица:");
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[i].length; j++) {
                System.out.print(matr[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
    public String[] calcDiagonals() {
        String[] arrayDiag = new String[matr.length * 2];
        System.out.println("Главная диагональ:");
        for (int i = 0; i < matr.length; i++) {
            arrayDiag[i] = matr[i][i];
            System.out.print(matr[i][i] + " ");
        }
        System.out.println("");
        System.out.println("Побочная диагональ:");
        for (int i = 0, j = matr.length; i < matr.length; i++, j++) {
            arrayDiag[j] = matr[i][matr.length - 1 - i];
            System.out.print(matr[i][matr.length - 1 - i] + " ");
        }
        int ravenstvoDiagon = 0;
        for (int i = 0; i < matr.length; i++) {
            if (matr[i][i].equals(matr[i][matr.length - 1 - i]))
                ravenstvoDiagon++;
        }
        System.out.println("");
        if (ravenstvoDiagon == 10) {
            System.out.println("Диагонали равны");
        } else System.out.println("Диагонали не равны");

        return arrayDiag;
    }
}

