package eu.senla.task12;

import eu.senla.task12.goods.Goods;
import eu.senla.task12.orders.Orders;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class OrdersUtils {
    static Scanner scanner;
    private static boolean isOpened = false;
    private static List<Orders> ordersList = new ArrayList<>();


    public static void openOrdersFile(String source) {
        File file = new File(source);
        try {
            scanner = new Scanner(file);
            isOpened = true;
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        }
    }

    public static void addOrder() {
        int ID;
        scanner = new Scanner(System.in);
        if (ordersList.size() >= 1) {
            ID = ordersList.get(ordersList.size() - 1).getOrderId() + 1;
        } else ID = 1;
        System.out.println("Введите дату заказа товара(ДД-ММ-ГГГГ): ");
        LocalDate date = GoodsUtils.getDate(scanner.next());
        ordersList.add(new Orders(ID, date, addGoodsToOrder()));
    }

    private static List<Goods> addGoodsToOrder() {
        List<Goods> goodsOrdered;
        goodsOrdered = new ArrayList<>();
        while (true) {

            System.out.println("Введите индекс товара для добавления в заказ: ");
            int goodsIndex = scanner.nextInt();
            if (goodsIndex == -1) break;
            int index;
            for (Goods goods : GoodsUtils.goodsList) {
                if (goodsIndex == goods.getId()) {
                    index = GoodsUtils.goodsList.indexOf(goods);
                    goodsOrdered.add(GoodsUtils.goodsList.get(index));
                }
            }
        }
        return goodsOrdered;
    }
    public static void removeOrderByID(int orderId) {
        Iterator<Orders> iterator = ordersList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getOrderId() == orderId) {
                iterator.remove();
            }
        }
    }

    public static void readOrdersFile() {
        List<Goods> goodsOrdered;
        if (isOpened) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] lineSplit = line.split("/");
                String[] goodsSplit = lineSplit[2].split(";");
                goodsOrdered = new ArrayList<>();
                LocalDate date=LocalDate.now();
                boolean isAdded = false;
                for (String s : goodsSplit) {
                    for (int j = 0; j < GoodsUtils.goodsList.size(); j++) {
                        if (Integer.parseInt(s) == GoodsUtils.goodsList.get(j).getId()) {
                            goodsOrdered.add(GoodsUtils.goodsList.get(j));
                            isAdded = true;
                        }
                    }
                    if (!isAdded && !s.isEmpty())
                        goodsOrdered.add(new Goods(Integer.parseInt(s),"нет на складе",null));
                }
                Orders order = new Orders(Integer.parseInt(lineSplit[0]), GoodsUtils.getDate(lineSplit[1]), goodsOrdered);
                ordersList.add(order);
            }
        } else System.out.println("Файл не открыт");
    }

    public static void writeOrdersFile() {
        try {
            StringBuilder str = new StringBuilder();
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/eu/senla/task12/orders/orders.txt", false));
            for (Orders orders : ordersList) {
                String date = orders.getDateOfOrder().toString();
                String[] dateSplit = date.split("-");
                for (Goods goods : orders.getGoodsOrdered()) {
                    str.append(goods.getId());
                    str.append(";");
                }
                String write = orders.getOrderId() + "/" + dateSplit[2] + "-" + dateSplit[1] + "-" + dateSplit[0]
                        + "/" + str.substring(0, str.length() - 1);
                bw.write(write);
                bw.newLine();
                str = new StringBuilder();
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            System.out.println("Невозможно сохранить в файл");
        }
    }

    public static void printOrders() {
        System.out.println("------------------------------------------------------");
        for (Orders orders : ordersList) {
            System.out.println(orders);
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - ");
        }
    }
}
