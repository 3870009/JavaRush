package eu.senla.lesson24.task5;

public class Port {
    private int maxShipsNumber = 0;
    private int shipCount = 0;
    private double portResultWeight = 0;

    private Ship[] ships;

    public Port(int maxShipsNumber) {
        this.maxShipsNumber = maxShipsNumber;
        ships = new Ship[maxShipsNumber];
        System.out.println("Port for " + maxShipsNumber + " ships is created. Please add ships.");
    }

    /*  public Port(int maxShipsNumber, Ship[] ship) {
          this.maxShipsNumber = maxShipsNumber;
          ships = new Ship[maxShipsNumber];
          this.ships = ship;
          shipCount = ship.length;
          for (Ship sh: ship){
              portResultWeight += sh.getShipResultWeight();
          }
          System.out.println(shipCount + " ships added to port.");
      }*/
    public boolean add(Ship ship) {
        if (shipCount < ships.length) {
            ships[shipCount] = ship;
            portResultWeight += ship.getShipResultWeight();
            shipCount++;
            System.out.println("Ship -" + ship.getShipName() + "- with " + ship.getShipResultWeight() + " of water is added to the port");
            return true;
        } else {
            System.out.println("Reach maximum number of ships for the port");
            return false;
        }
    }

    public boolean remove() {

        if (shipCount > 0) {
            shipCount--;
            portResultWeight -= ships[shipCount].getShipResultWeight();
            System.out.println("Ship -" + ships[shipCount].getShipName() + "- with " + ships[shipCount].getShipResultWeight() + " is removed from the port.");
            ships[shipCount] = null;
            return true;
        } else {
            System.out.println("No ships to remove from the port");
            return false;
        }
    }

    public double getPortResultWeight() {
        return portResultWeight;
    }
}
