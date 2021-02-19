package eu.senla.task7;

public class Robot {
    public String name;
    public int id = 0;
    public static int count = 1;
    RoboBody rb;
    RoboHead rh;

    public Robot(RoboBody rb, RoboHead rh) {
        this.id = count++;
        this.name = "Robo_" + this.id + "_" + "rb" + rb.getId() + "rh" + rh.getId();

        this.rb = rb;
        this.rh = rh;
    }


    @Override
    public String toString() {
        return "Robot: " + name + " Body: " + rb.bodyType + " Head: " + rh.headType;
    }
}
