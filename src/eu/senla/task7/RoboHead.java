package eu.senla.task7;

public class RoboHead implements Createable{
    HeadType headType;
    public int id = 0;
    public static int count = 1;

    public RoboHead(HeadType headType) {
        this.headType = headType;
        this.id = count++;

    }

    public RoboHead() {

    }

    public int getId() {
        return id;
    }

    public RoboHead create() {
        HeadType[] ht = {HeadType.HEAD_TYPE_1, HeadType.HEAD_TYPE_2, HeadType.HEAD_TYPE_3};
        int randomNum = (int) (Math.random() * 3);
        return new RoboHead(ht[randomNum]);
    }

    @Override
    public String toString() {
        return "RoboHead{" +
                "headType=" + headType +
                "ID=" + id +
                '}';
    }
}

enum HeadType {
    HEAD_TYPE_1,
    HEAD_TYPE_2,
    HEAD_TYPE_3;
}
