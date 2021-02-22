package eu.senla.task7;

public class Factory implements Createable {

    public Robot create() {
        RoboHead rh = new RoboHead();
        RoboBody rb = new RoboBody();

        //Очередность параметров неважна
        return new Robot(rb.create(), rh.create());
    }
}
