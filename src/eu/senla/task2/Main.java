package eu.senla.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {

        Rainbow r = new Rainbow();
/* Вариант 1
        r.showNumToColor(1);
        r.showNumToColor(5);
        r.showNumToColor(1,2);
        r.showNumToColor(5,8);
        r.showNumToColor(9);
        r.showNumToColor(99);
        r.showNumToColor(5,5);
        r.showNumToColor(6,2);*/

        /* Вариант 2*/
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
                    r.showNumToColor(userColor1,userColor2);
                }
                if(userColor > 0 && userColor < 10)
                r.showNumToColor(userColor);
                }
            }
        }
    }




