package eu.senla.task7;

public class RoboHead {
    HeadType headType;
    private int id = 0;
    private static int count = 1;
    HeadType[] ht = HeadType.values();
    int randomNum = (int) (Math.random() * 3);

   /* public RoboHead(HeadType headType) {
        this.headType = headType;
        this.id = count++;

    }*/

    public RoboHead() {
        this.headType =ht[randomNum];
        this.id = count++;
    }

    public int getId() {
        return id;
    }

    public Object getType() {
        return headType;
    }

  /*  public RoboHead create() {
        HeadType[] ht = {HeadType.HEAD_TYPE_1, HeadType.HEAD_TYPE_2, HeadType.HEAD_TYPE_3};
        int randomNum = (int) (Math.random() * 3);
        return new RoboHead(ht[randomNum]);
    }*/

    @Override
    public String toString() {
        return "Head: " + headType;

    }
}
enum HeadType {
    HEAD_TYPE_1,
    HEAD_TYPE_2,
    HEAD_TYPE_3;
}
