package eu.senla.Task4;

import java.util.Random;

public class Matrix {

    public String makeRandomString() {
        String symbols = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(symbols.charAt(random.nextInt(symbols.length() - 1)));
        }
        return sb.toString();
    }

    public String makeRandomStringDouble(int min, int max) {
        Random random = new Random();
        String stringDouble;
        stringDouble = String.valueOf((random.nextDouble() * (max-min)) + 1);
        return stringDouble.substring(0, 6);
    }

    public String[][] makeMatrix() {
        String[][] matr = new String[10][10];
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[i].length; j++) {
                if (j == 0 || j == 3 || j == 6 || j == 9) {
                    matr[i][j] = makeRandomStringDouble(1,3);
                } else {
                    matr[i][j] = makeRandomString();
                }
            }
        }
        return matr;
    }

    public void printMatrix(String[][] matr) {
        System.out.println("");
        System.out.println("Первоначальная матрица:");
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[i].length; j++) {
                System.out.print(matr[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public String[] calcDiagonals(String[][] matr) {
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

    static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((!Character.isDigit(c) && chars[1] != '.')) {
                return false;
            }
        }
        return true;
    }

    public void zapolnenieMassiva(String[] arrayStr) {
        StringBuilder sbStr = new StringBuilder();
        double[] nums = new double[10];
        double numStr = 0;
        for (int i = 0, j = 0; i < arrayStr.length; i++) {
            if (isNumber(arrayStr[i]) == false) {
                sbStr.append(arrayStr[i], 2, 5);
                sbStr.append(",");
            } else {
                numStr = Double.parseDouble(arrayStr[i]);
                if (numStr > 1.7) {
                    nums[j] = Math.ceil(numStr);
                    j++;
                } else {
                    nums[j] = Math.floor(numStr);
                    j++;
                }
            }
        }
        System.out.println("Требуемый массив строк:");
        System.out.println(sbStr.toString());
        System.out.println("Требуемый массив чисел:");
        for (int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + "_");
    }
}

