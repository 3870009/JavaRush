package eu.senla.task12;

import eu.senla.task12.goods.Goods;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class GoodsUtils {
    private static Scanner scanner;
    private static String sourceF;
    private static boolean isOpened = false;
    static List<Goods> goodsList = new ArrayList<>();

    public static void openGoodsFile(String source) {
        File file = new File(source);
        try {
            scanner = new Scanner(file);
            isOpened = true;
            sourceF = source;
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        }
    }

    public static void readGoodsFile() {
        if (isOpened) {

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] lineSplit = line.split("/");
                Goods goods = new Goods(Integer.parseInt(lineSplit[0]), lineSplit[1], getDate(lineSplit[2]));
                goodsList.add(goods);
            }
        } else System.out.println("Файл не открыт");
    }

    public static void writeGoodsFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(sourceF, false));
            for (Goods goods : goodsList) {
                String date = goods.getDate().toString();
                String[] dateSplit = date.split("-");
                String write = goods.getId() + "/" + goods.getGoodsTitle() + "/" + dateSplit[2] + "-" + dateSplit[1] + "-" + dateSplit[0];
                bw.write(write);
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            System.out.println("Невозможно сохранить в файл");
        }
    }

    static LocalDate getDate(String date) {
        String[] splitDate = date.split("-");
        return LocalDate.of(Integer.parseInt(splitDate[2]), Integer.parseInt(splitDate[1]), Integer.parseInt(splitDate[0]));
    }

    public static void addGoods() {
        int ID;
        scanner = new Scanner(System.in);
        if (goodsList.size() >= 1) {
            ID = goodsList.get(goodsList.size() - 1).getId() + 1;
        } else ID = 1;

        System.out.println("Введите название товара: ");
        String goodsTitle = scanner.next();
        System.out.println("Введите дату производства товара(ДД-ММ-ГГГГ): ");
        LocalDate date = getDate(scanner.next());
        goodsList.add(new Goods(ID, goodsTitle, date));
    }

    public static void sortByTitle() {
        goodsList.stream()
                .sorted((o1, o2) -> o1.getGoodsTitle().compareTo(o2.getGoodsTitle()))
                .forEach(s -> System.out.println(s));
    }

    public static void sortByID() {
        goodsList.stream()
                .sorted((o1, o2) -> o1.getId() - o2.getId())
                .forEach(s -> System.out.println(s));
    }

    public static void sortByDate() {
        goodsList.stream()
                .sorted((o1, o2) -> o1.getDate().compareTo(o2.getDate()))
                .forEach(s -> System.out.println(s));
    }

    public static void removeGoodsByID(int ID) {
        Iterator<Goods> iterator = goodsList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == ID) {
                iterator.remove();
            }
        }
    }

    public static void printGoods() {
        System.out.println("------------------------------------------------------");
        for (Goods goods : goodsList) {
            System.out.println(goods);
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - ");
        }
    }
}
