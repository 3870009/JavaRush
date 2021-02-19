package eu.senla.task7;

public class Main {
    public static void main(String[] args) {
        Factory factory = new Factory();

        for(int i=0; i<9; i++ ){
            Robot robot = factory.create();
            System.out.println(robot);
        }
    }
}
