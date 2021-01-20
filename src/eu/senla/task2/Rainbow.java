package eu.senla.task2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Rainbow {
    final String COLOR_1 = "красный";
    final String COLOR_2 = "оранжевый";
    final String COLOR_3 = "желтый";
    final String COLOR_4 = "зеленый";
    final String COLOR_5 = "голубой";
    final String COLOR_6 = "синий";
    final String COLOR_7 = "фиолетовый";

    void userInput() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("Введите номер цвета (0- для выхода из программы): ");
            int userColor = Integer.parseInt(reader.readLine());
            if(userColor == 0) break;
            else {
                if(userColor < 0 || userColor >= 100)
                    System.out.println("Неверный ввод. Диапазон ввода для простых цветов 1-7, для сложных цветов 10-77. Пожалуйста, повторите ввод.");
                if(userColor >= 10 && userColor < 100){
                    int userColor1 = userColor/10; //нахождение числа из разряда десятков
                    int userColor2 = userColor%10; //нахождение числа из разряда единиц
                    showNumToColor(userColor1,userColor2);
                }
                if(userColor > 0 && userColor < 10)
                    showNumToColor(userColor);
            }
        }
    }

    void showNumToColor(int userColor) {
        switch (userColor) {
            case 1:
                System.out.println("Выбранный цвет - " + COLOR_1);
                break;
            case 2:
                System.out.println("Выбранный цвет - " + COLOR_2);
                break;
            case 3:
                System.out.println("Выбранный цвет - " + COLOR_3);
                break;
            case 4:
                System.out.println("Выбранный цвет - " + COLOR_4);
                break;
            case 5:
                System.out.println("Выбранный цвет - " + COLOR_5);
                break;
            case 6:
                System.out.println("Выбранный цвет - " + COLOR_6);
                break;
            case 7:
                System.out.println("Выбранный цвет - " + COLOR_7);
                break;
            default:
                System.out.println("Неверный ввод. Диапазон ввода для простых цветов 1-7");
        }
    }

    void showNumToColor(int userColor1, int userColor2) {
        int userColorMix = Integer.parseInt(String.valueOf(userColor1) + String.valueOf(userColor2));

        switch (userColorMix) {
            case 01:
                showNumToColor(1);
                break;
            case 10:
                showNumToColor(1);
                break;
            case 11:
                showNumToColor(1);
                break;
            case 12:
                System.out.println("Выбранный цвет - красно-" + COLOR_2);
                break;
            case 13:
                System.out.println("Выбранный цвет - красно-" + COLOR_3);
                break;
            case 14:
                System.out.println("Выбранный цвет - красно-" + COLOR_4);
                break;
            case 15:
                System.out.println("Выбранный цвет - красно-" + COLOR_5);
                break;
            case 16:
                System.out.println("Выбранный цвет - красно-" + COLOR_6);
                break;
            case 17:
                System.out.println("Выбранный цвет - красно-" + COLOR_7);
                break;
            case 02:
                showNumToColor(2);
                break;
            case 20:
                showNumToColor(2);
                break;
            case 22:
                showNumToColor(2);
                break;
            case 21:
                showNumToColor(1,2);
                break;
            case 23:
                System.out.println("Выбранный цвет - оранжево-" + COLOR_3);
                break;
            case 24:
                System.out.println("Выбранный цвет - оранжево-" + COLOR_4);
                break;
            case 25:
                System.out.println("Выбранный цвет - оранжево-" + COLOR_5);
                break;
            case 26:
                System.out.println("Выбранный цвет - оранжево-" + COLOR_6);
                break;
            case 27:
                System.out.println("Выбранный цвет - оранжево-" + COLOR_7);
                break;
            case 03:
                showNumToColor(3);
                break;
            case 30:
                showNumToColor(3);
                break;
            case 33:
                showNumToColor(3);
                break;
            case 31:
                showNumToColor(1,3);
                break;
            case 32:
                showNumToColor(2,3);
                break;
            case 34:
                System.out.println("Выбранный цвет - желто-" + COLOR_4);
                break;
            case 35:
                System.out.println("Выбранный цвет - желто-" + COLOR_5);
                break;
            case 36:
                System.out.println("Выбранный цвет - желто-" + COLOR_6);
                break;
            case 37:
                System.out.println("Выбранный цвет - желто-" + COLOR_7);
                break;
            case 04:
                showNumToColor(4);
                break;
            case 40:
                showNumToColor(4);
                break;
            case 44:
                showNumToColor(4);
                break;
            case 41:
                showNumToColor(1,4);
                break;
            case 42:
                showNumToColor(2,4);
                break;
            case 43:
                showNumToColor(3,4);
                break;
            case 45:
                System.out.println("Выбранный цвет - зелено-" + COLOR_5);
                break;
            case 46:
                System.out.println("Выбранный цвет - зелено-" + COLOR_6);
                break;
            case 47:
                System.out.println("Выбранный цвет - зелено-" + COLOR_7);
                break;
            case 05:
                showNumToColor(5);
                break;
            case 50:
                showNumToColor(5);
                break;
            case 55:
                showNumToColor(5);
                break;
            case 51:
                showNumToColor(1,5);
                break;
            case 52:
                showNumToColor(2,5);
                break;
            case 53:
                showNumToColor(3,5);
                break;
            case 54:
                showNumToColor(4,5);
                break;
            case 56:
                System.out.println("Выбранный цвет - сине-" + COLOR_5);
                break;
            case 57:
                System.out.println("Выбранный цвет - фиолетово-" + COLOR_5);
                break;
            case 06:
                showNumToColor(6);
                break;
            case 60:
                showNumToColor(6);
                break;
            case 66:
                showNumToColor(6);
                break;
            case 61:
                showNumToColor(1,6);
                break;
            case 62:
                showNumToColor(2,6);
                break;
            case 63:
                showNumToColor(3,6);
                break;
            case 64:
                showNumToColor(4,6);
                break;
            case 65:
                showNumToColor(5,6);
                break;
            case 67:
                System.out.println("Выбранный цвет - сине-" + COLOR_7);
                break;
            case 07:
                showNumToColor(7);
                break;
            case 70:
                showNumToColor(7);
                break;
            case 77:
                showNumToColor(7);
                break;
            case 71:
                showNumToColor(1,7);
                break;
            case 72:
                showNumToColor(2,7);
                break;
            case 73:
                showNumToColor(3,7);
                break;
            case 74:
                showNumToColor(4,7);
                break;
            case 75:
                showNumToColor(5,7);
                break;
            case 76:
                showNumToColor(6,7);
                break;
            default:
                System.out.println("Неверный ввод. Диапазон ввода для сложных цветов 10-77");
        }
    }
}