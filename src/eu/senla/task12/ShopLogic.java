package eu.senla.task12;

import java.util.Scanner;

public class ShopLogic {
    final static String GOODS_SOURCE_FILE = "src/eu/senla/task12/goods/goods.txt";
    final static String ORDERS_SOURCE_FILE = "src/eu/senla/task12/orders/orders.txt";

    public static void startMenu() {
        openFiles();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Для работы с товарами нажмите <1>\nДля работы с заказами нажмите <2>\n" +
                    "Для выхода из программы нажмите <3>");
            String select = scanner.next();
            int sel;
            if (isNum(select)) {
                sel = Integer.parseInt(select);
                if (sel == 3) {
                    closeFiles();
                    break;
                }
                switch (sel) {
                    case 1:
                        GoodsUtils.readGoodsFile();
                        goodsMenu();
                        break;
                    case 2:
                        GoodsUtils.readGoodsFile();
                        OrdersUtils.readOrdersFile();
                        ordersMenu();
                        break;
                    default:
                        System.out.println("Вы ввели не то число");
                        break;
                }
            }
        }
    }

    private static boolean isNum(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели не число");
            return false;
        }
        return true;
    }

    private static void openFiles() {
        GoodsUtils.openGoodsFile(GOODS_SOURCE_FILE);
        OrdersUtils.openOrdersFile(ORDERS_SOURCE_FILE);
        System.out.println("***********************************");
        System.out.println("* Добро пожаловать в наш магазин! *");
        System.out.println("***********************************");
    }

    private static void closeFiles() {
        System.out.println("************************************");
        System.out.println("* Ждем вас снова в нашем магазине! *");
        System.out.println("************************************");
        GoodsUtils.writeGoodsFile();
        OrdersUtils.writeOrdersFile();
    }

    private static void goodsMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите что делать с товарами\nДля просмотра всего списка товаров нажмите <1>\n" +
                    "Для добавления товара нажмите <2>\nДля удаления товара по индексу нажмите <3>\n" +
                    "Для сортировки вывода нажмите <4>\n" +
                    "Для возврата в главное меню нажмите <5>");
            String select1 = scanner.next();
            int sel1;
            if (isNum(select1)) {
                sel1 = Integer.parseInt(select1);
                if (sel1 == 5) {
                    GoodsUtils.writeGoodsFile();
                    break;
                }
                switch (sel1) {
                    case 1:
                        GoodsUtils.printGoods();
                        break;
                    case 2:
                        GoodsUtils.addGoods();
                        break;
                    case 3:
                        System.out.println("Введите индекс товара, который хотите удалить: ");
                        String select13 = scanner.next();
                        int sel13;
                        if (isNum(select13)) {
                            sel13 = Integer.parseInt(select13);
                            GoodsUtils.removeGoodsByID(sel13);
                        }
                        break;
                    case 4:
                        sortingMenu();
                        break;
                    default:
                        System.out.println("Вы ввели не то число");
                        break;
                }
            }
        }
    }

    private static void sortingMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Для сортировки по индексу нажмите <1>\n" +
                    "Для сортировки по названию нажмите <2>\n" +
                    "Для сортировки по дате производства нажмите <3>\n" +
                    "Для возврата в меню работы с товарами нажмите <4>");
            String select41 = scanner.next();
            int sel41;
            if (isNum(select41)) {
                sel41 = Integer.parseInt(select41);
                if (sel41 == 4) break;
                switch (sel41) {
                    case 1:
                        GoodsUtils.sortByID();
                        break;
                    case 2:
                        GoodsUtils.sortByTitle();
                        break;
                    case 3:
                        GoodsUtils.sortByDate();
                        break;
                    default:
                        System.out.println("Вы ввели не то число");
                        break;
                }
            }
        }
    }

    private static void ordersMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите что делать с заказами\nДля просмотра всего списка заказов нажмите <1>\n" +
                    "Для добавления заказа нажмите <2>\nДля удаления заказа по индексу нажмите <3>\n" +
                    "Для возврата в главное меню нажмите <4>");
            String select2 = scanner.next();
            int sel2;
            if (isNum(select2)) {
                sel2 = Integer.parseInt(select2);
                if (sel2 == 4) {
                    OrdersUtils.writeOrdersFile();
                    break;
                }
                switch (sel2) {
                    case 1:
                        OrdersUtils.printOrders();
                        break;
                    case 2:
                        OrdersUtils.addOrder();
                        break;
                    case 3:
                        System.out.println("Введите индекс заказа, который хотите удалить: ");
                        String select23 = scanner.next();
                        int sel23;
                        if (isNum(select23)) {
                            sel23 = Integer.parseInt(select23);
                            OrdersUtils.removeOrderByID(sel23);
                        }
                        break;
                    default:
                        System.out.println("Вы ввели не то число");
                        break;
                }
            }
        }
    }

}