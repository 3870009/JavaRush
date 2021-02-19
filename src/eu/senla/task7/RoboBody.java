package eu.senla.task7;

public class RoboBody implements Createable{
    BodyType bodyType;
    public int id = 0;
    public static int count = 1;

    public RoboBody(BodyType bodyType) {
        this.bodyType = bodyType;
        this.id = count++;

    }

    public RoboBody() {

    }

    public int getId() {
        return id;
    }

    public RoboBody create() {
        BodyType[] bt = {BodyType.BODY_TYPE_1, BodyType.BODY_TYPE_2, BodyType.BODY_TYPE_3};
        int randomNum = (int) (Math.random() * 3);
        return new RoboBody(bt[randomNum]);
    }

    @Override
    public String toString() {
        return "RoboBody{" +
                "bodyType=" + bodyType +
                "ID=" + id +
                '}';
    }

}

enum BodyType {
    BODY_TYPE_1,
    BODY_TYPE_2,
    BODY_TYPE_3;
}
