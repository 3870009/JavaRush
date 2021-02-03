package eu.senla.Task4;

public class DiagonalCalc {



    public static void arrayFilling(String[] arrayStr) {

        StringBuilder sbStr = new StringBuilder();
        double[] nums = new double[10];
        double numStr = 0;
        for (int i = 0, j = 0; i < arrayStr.length; i++) {
            if (MatrixCalc.isNumber(arrayStr[i]) == false) {
                sbStr.append(arrayStr[i], 1, 4);
                sbStr.append(",");
            } else {
                numStr = Double.parseDouble(arrayStr[i]);
                if (numStr >= 1.7) {
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
