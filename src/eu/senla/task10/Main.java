package eu.senla.task10;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> ml = new MyArrayList<>();
        ml.add(1);
        ml.add(8);
        ml.add(5);
        ml.add(3);
        ml.add(1);
        ml.add(656);
        ml.add(99);
        ml.add(54);
        ml.add(87);
        ml.add(23);
        ml.add(55);
        System.out.println(ml);
        try {
            ml.remove(13);
        } catch (MyIndexOutOfBoundsException me) {
            System.out.println(me.getMessage());
        } finally {
            System.out.println(ml);
        }
        try {
            ml.get(5);
        } catch (MyIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }


        try {
            ml.add(6, 666);
        } catch (MyIndexOutOfBoundsException | MyObjConteinsException me) {
            System.out.println(me.getMessage());
        } finally {
            System.out.println(ml);
        }
    }
}
