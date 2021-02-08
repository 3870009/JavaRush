package eu.senla.lesson24.task5;

abstract class Container {
    private final int DENSITY1 = 1000;
    private final int DENSITY2 = 2000;
    int currentDensity;
    boolean isBig;
    int height;

    abstract double getContainerWeight();

    public Container(boolean isBig, int height, int density) {
        this.isBig = isBig;
        if (height >= 10 || height <= 100) {
            this.height = height;
        } else System.out.println("The height of the container is incorrect. Must be 10...100");
        if (density == DENSITY1 || density == DENSITY2)
            this.currentDensity = density;
        else System.out.println("The density of water is incorrect. Must be 1000 or 2000");
    }
}

class CubicContainer extends Container {
    private double resultWeight;

    public CubicContainer(boolean isBig, int height, int density) {
        super(isBig, height, density);
    }

    @Override
    double getContainerWeight() {

        if (isBig) {
            resultWeight = currentDensity * height * 20 * 20 / 2;
        } else resultWeight = currentDensity * height * 10 * 10 / 2;
        return resultWeight;
    }
}

class CylinderContainer extends Container {
   private double resultWeight;

    public CylinderContainer(boolean isBig, int height, int density) {
        super(isBig, height, density);
    }

    @Override
    double getContainerWeight() {

        if (isBig) {
            resultWeight = currentDensity * height * 3.14 * 20 * 20 / 4;
        } else resultWeight = currentDensity * height * 3.14 * 10 * 10 / 4;
        return resultWeight;
    }
}

class ConeContainer extends Container {
   private double resultWeight;

    public ConeContainer(boolean isBig, int height, int density) {
        super(isBig, height, density);
    }

    @Override
    double getContainerWeight() {

        if (isBig) {
            resultWeight = currentDensity * height * 3.14 * 20 * 20 / 12;
        } else resultWeight = currentDensity * height * 3.14 * 10 * 10 / 12;
        return resultWeight;
    }
}

