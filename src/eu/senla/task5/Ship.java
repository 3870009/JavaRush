package eu.senla.task5;

public class Ship {
    double resultWeight;
    private String name;
    int deckNumber;
    private int deckCount = 0;
    private double shipResultWeight = 0;

    private ShipDeck[] shipDeck;

    public Ship(int deckNumber) {
        this.deckNumber = deckNumber;
        shipDeck = new ShipDeck[deckNumber];
        System.out.println(deckNumber + "-deck ship is created. Please add decks.");
    }

    public Ship(String name, ShipDeck[] shipDeck) {
        this.name = name;
        this.shipDeck = shipDeck;
        deckCount = shipDeck.length;
        deckNumber = shipDeck.length;
        for (ShipDeck shd : shipDeck) {
            shipResultWeight += shd.getDeckResultWeight();
        }
        System.out.println(deckNumber + "-deck ship with " + deckNumber + "-decks is created");
    }

    public boolean add(ShipDeck shd) {
        if (deckCount < shipDeck.length) {
            shipDeck[deckCount] = shd;
            shipResultWeight += shd.getDeckResultWeight();
            deckCount++;
            System.out.println("Deck is added to the ship");
            return true;
        } else {
            System.out.println("Reach maximum number of decks for the ship");
            return false;
        }
    }

    public boolean remove() {

        if (deckCount > 0) {
            deckCount--;
            shipResultWeight -= shipDeck[deckCount].getDeckResultWeight();
            shipDeck[deckCount] = null;

            System.out.println("Deck is removed from the ship");
            return true;
        } else {
            System.out.println("No decks to remove from the ship");
            return false;
        }
    }

    public double getShipResultWeight() {
        return shipResultWeight;
    }
    public String getShipName() {
        return name;
    }
}