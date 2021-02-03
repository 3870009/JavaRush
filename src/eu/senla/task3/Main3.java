package eu.senla.task3;

public class Main3 {


    static void addCat1() {
        int catCount = 0;
        while (catCount < 10) {
            Cat cat1 = new Cat();
            System.out.println(cat1.toString());
            catCount++;
        }
    }

    static void addCat2() {
        for (int catCount = 0; catCount < 10; catCount++) {
            Cat cat = new Cat();
            cat.setCatName("Petka" + catCount);
            cat.setCatAge(catCount + 1);
            System.out.println("Cat name: " + cat.getCatName() + "; Cat age: " + cat.getCatAge());
        }
    }

    static void addCat3() {
        int catCount = 0;
        do {
            String name = "Murzik" + (catCount + 1);
            Cat cat = new Cat(name, catCount + 1);
            System.out.println(cat.toString());
            catCount++;
        } while (catCount < 10);
    }

    static void addCat4() {
        Cat[] cat = {new Cat("Vaska", 3), new Cat("Petka", 6), new Cat("Tom", 2), new Cat("Murzik", 11), new Cat("Jery", 4)};
        for (Cat cat1 : cat) {
            System.out.println(cat1.toString());
        }
    }

    static void catToStringTest() {
        Cat cat = new Cat("Petka", 5);
        System.out.println(cat.toString());
    }

    static void catEqualsTest() {
        Cat cat1 = new Cat("Petka", 5);
        Cat cat2 = new Cat("Petka", 5);

        System.out.println(cat1.equals(cat2));
    }
    public static void main(String[] args) {
        addCat1();
        System.out.println("----------------------------------------------");
        addCat2();
        System.out.println("----------------------------------------------");
        addCat3();
        System.out.println("----------------------------------------------");
        addCat4();
        System.out.println("----------------------------------------------");
        catToStringTest();
        System.out.println("----------------------------------------------");
        catEqualsTest();
    }
}
