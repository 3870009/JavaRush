package eu.senla.task7;

public class RoboBody {
    BodyType bodyType;
    private int id = 0;
    private static int count = 1;
    BodyType[] bt = BodyType.values();
    int randomNum = (int) (Math.random() * 3);
    ;

  /*  public RoboBody(BodyType bodyType) {
        this.bodyType = bodyType;
        this.id = count++;

    }*/

    public RoboBody() {

        this.bodyType =bt[randomNum];
        this.id = count++;
    }

    public int getId() {
        return id;
    }
    public Object getType() {
        return bodyType;
    }


   /* public RoboBody create() {
        BodyType[] bt = {BodyType.BODY_TYPE_1, BodyType.BODY_TYPE_2, BodyType.BODY_TYPE_3};
        int randomNum = (int) (Math.random() * 3);
        return new RoboBody(bt[randomNum]);
    }*/

    @Override
    public String toString() {
        return "Body: " + bodyType;
    }

}

enum BodyType {
    BODY_TYPE_1,
    BODY_TYPE_2,
    BODY_TYPE_3;
}
