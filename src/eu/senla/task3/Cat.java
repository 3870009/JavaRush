package eu.senla.task3;

public class Cat {
    private String catName = "John Doe";
    private int catAge = 1;

    Cat() {
    }

    Cat(String catName, int catAge) {
        this.catName = catName;
        this.catAge = catAge;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public int getCatAge() {
        return catAge;
    }

    public void setCatAge(int catAge) {
        this.catAge = catAge;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "catName='" + catName + '\'' +
                ", catAge=" + catAge +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return catAge == cat.catAge &&
                catName.equals(cat.catName);
    }

    static void addCat1() {
        int catCount = 0;
        while (catCount < 10) {
            Cat cat1 = new Cat();
            System.out.println("Cat name: " + cat1.catName + "; Cat age: " + cat1.catAge);
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
            System.out.println("Cat name: " + cat.catName + "; Cat age: " + cat.catAge);
            catCount++;
        } while (catCount < 10);
    }

    static void addCat4() {
        Cat[] cat = {new Cat("Vaska", 3), new Cat("Petka", 6), new Cat("Tom", 2), new Cat("Murzik", 11), new Cat("Jery", 4)};
        for (Cat cat1 : cat) {
            System.out.println("Cat name: " + cat1.catName + "; Cat age: " + cat1.catAge);
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

}
