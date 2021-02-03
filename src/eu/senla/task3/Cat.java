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
        return "Cat name: " + catName + "; Cat age: " + catAge;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return catAge == cat.catAge &&
                catName.equals(cat.catName);
    }



}
