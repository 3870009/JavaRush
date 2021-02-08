package eu.senla.lesson24.task5;

public class ShipDeck {
    boolean allBig;
    private Container[] deckContainer;
    private int containerCount = 0;
    private double deckResultWeight = 0;


    public ShipDeck(boolean allBig) {
        this.allBig = allBig;
        if (this.allBig == true) {
            deckContainer = new Container[2];
            System.out.println("Shipdeck for 2 big containers is added. Please add containers.");
        } else {
            deckContainer = new Container[4];
            System.out.println("Shipdeck for 4 little containers is added. Please add containers.");
        }
    }

    public ShipDeck(boolean allBig, Container[] deckContainer) {
        this.allBig = allBig;
        if (this.allBig == true) {
            if (deckContainer.length <= 2) {
                this.deckContainer = deckContainer;
                containerCount = deckContainer.length;
                for (Container cont : deckContainer) {
                    deckResultWeight += cont.getContainerWeight();
                }
                System.out.println(deckContainer.length + " big containers are added to the shipdeck.");
            } else System.out.println("Reach maximum capacity for the deck.");
        } else if (deckContainer.length <= 4) {
            this.deckContainer = deckContainer;
            containerCount = deckContainer.length;
            for (Container cont : deckContainer) {
                deckResultWeight += cont.getContainerWeight();
            }
            System.out.println(deckContainer.length + " little containers are added to the shipdeck.");
        } else System.out.println("Reach maximum capacity for the deck.");
    }

    public boolean add(Container cont) {
        if (this.allBig == true) {
            if (containerCount < deckContainer.length) {
                deckContainer[containerCount] = cont;
                deckResultWeight += cont.getContainerWeight();
                containerCount++;
                System.out.println("Big container is added to the shipdeck");
                return true;
            } else {
                System.out.println("Reach maximum capacity for the deck.");
                return false;
            }
        } else if (containerCount < deckContainer.length) {
            deckContainer[containerCount] = cont;
            deckResultWeight += cont.getContainerWeight();
            containerCount++;
            System.out.println("Little container is added to the shipdeck");
            return true;
        } else {
            System.out.println("Reach maximum capacity for the deck.");
            return false;
        }

    }

    public boolean remove() {
        if (containerCount > 0) {
            containerCount--;
            deckResultWeight -= deckContainer[containerCount].getContainerWeight();
            deckContainer[containerCount] = null;

            System.out.println("Container is removed from the shipdeck");
            return true;
        } else {
            System.out.println("No containers to remove from the shipdeck");
            return false;
        }
    }

    public double getDeckResultWeight() {
        return deckResultWeight;
    }
}
