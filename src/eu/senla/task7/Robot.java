package eu.senla.task7;

public class Robot <T,S>{
    public String name;
    public int id = 0;
    public static int count = 1;
    T firstPart;
    S secondPart;

    public Robot(T firstPart, S secondPart) {
        this.id = count++;
        this.name = "Robo_" + this.id;

        this.firstPart = firstPart;
        this.secondPart = secondPart;
    }


    @Override
    public String toString() {
        return "Robot: " + name +" " + firstPart.toString() +" "+ secondPart.toString();
    }
}