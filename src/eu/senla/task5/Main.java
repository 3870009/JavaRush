package eu.senla.task5;

public class Main {
    public static void main(String[] args) {

        Container BigType1 = new CubicContainer(true, 90, 1000);
        Container BigType2 = new CylinderContainer(true, 60, 2000);
        Container BigType3 = new ConeContainer(true, 30, 1000);
        Container BigType4 = new CubicContainer(true, 70, 2000);
        Container BigType5 = new CylinderContainer(true, 20, 1000);
        Container LittleType1 = new CubicContainer(false, 80, 2000);
        Container LittleType2 = new ConeContainer(false, 20, 1000);
        Container LittleType3 = new CylinderContainer(false, 50, 2000);
        Container LittleType4 = new CubicContainer(false, 80, 2000);
        Container LittleType5 = new CubicContainer(false, 60, 1000);
        Container LittleType6 = new ConeContainer(false, 15, 2000);
        Container LittleType7 = new CylinderContainer(false, 25, 1000);
        Container LittleType8 = new CubicContainer(false, 70, 2000);

        Container [] Bt1 = {BigType1, BigType2};
        Container [] Bt2 = {BigType3, BigType4};
        Container [] Bt3 = {BigType4, BigType5};
        Container [] Bt4 = {BigType1, BigType5};
        Container [] Bt5 = {BigType2, BigType3};

        Container [] Lt1 = {LittleType1, LittleType2, LittleType3, LittleType4};
        Container [] Lt2 = {LittleType5, LittleType6, LittleType7, LittleType8};
        Container [] Lt3 = {LittleType1, LittleType5, LittleType2, LittleType6};
        Container [] Lt4 = {LittleType3, LittleType7, LittleType4, LittleType8};

        ShipDeck shipDeckBig1 = new ShipDeck(true, Bt1);
        ShipDeck shipDeckBig2 = new ShipDeck(true, Bt2);
        ShipDeck shipDeckBig3 = new ShipDeck(true, Bt3);
        ShipDeck shipDeckBig4 = new ShipDeck(true, Bt4);
        ShipDeck shipDeckBig5 = new ShipDeck(true, Bt5);

        ShipDeck shipDeckLittle1 = new ShipDeck(false, Lt1);
        ShipDeck shipDeckLittle2 = new ShipDeck(false, Lt2);
        ShipDeck shipDeckLittle3 = new ShipDeck(false, Lt3);
        ShipDeck shipDeckLittle4 = new ShipDeck(false, Lt4);

        ShipDeck [] sDb1 = {shipDeckBig1,shipDeckBig2};
        ShipDeck [] sDb2 = {shipDeckBig3,shipDeckLittle1};
        ShipDeck [] sDb3 = {shipDeckBig4};
        ShipDeck [] sDb4 = {shipDeckLittle1};
        ShipDeck [] sDb5 = {shipDeckLittle2,shipDeckLittle3};
        ShipDeck [] sDb6 = {shipDeckBig5,shipDeckLittle4};
        ShipDeck [] sDb7 = {shipDeckLittle4};

        Ship ship1 = new Ship("Akademik Pavlov",sDb1);
        Ship ship2 = new Ship("Nepotoplyaemy",sDb2);
        Ship ship3 = new Ship("Titanic",sDb3);
        Ship ship4 = new Ship("Sevmorput",sDb4);
        Ship ship5 = new Ship("Balkanskaya zvezda",sDb5);
        Ship ship6 = new Ship("Malinovoe varenye",sDb6);
        Ship ship7 = new Ship("Svobodny",sDb7);

        Ship [] ships = {ship1, ship2, ship3, ship4, ship5, ship6};

        Port port1 = new Port(10);
        port1.add(ship1);
        System.out.println("Summary amount of water in port is : " + port1.getPortResultWeight());
        port1.add(ship2);
        port1.add(ship3);
        port1.add(ship4);
        port1.add(ship5);
        port1.add(ship6);
        port1.add(ship7);
        System.out.println("Summary amount of water in port is : " + port1.getPortResultWeight());
        port1.remove();
        System.out.println("Summary amount of water in port is : " + port1.getPortResultWeight());
    }
}



