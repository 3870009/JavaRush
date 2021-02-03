package eu.senla.Task4;

import java.util.Random;

public class MatrixCalc {
    public static String makeRandomString() {
        String symbols = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(symbols.charAt(random.nextInt(symbols.length() - 1)));
        }
        return sb.toString();
    }
    public static String makeRandomStringDouble(int min, int max) {
        Random random = new Random();
        String stringDouble;
        stringDouble = String.valueOf((random.nextDouble() * (max-min)) + 1);
        return stringDouble.substring(0, 6);
    }
    public static boolean isNumber(String s) {
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


}
