import java.awt.*;

abstract class Truck extends Vehicle implements TruckInterface {


    public Truck(int nrDoors, Color color, double enginePower, String modelname) {
        super(nrDoors, color, enginePower, modelname);
    }

    public abstract boolean checkFlatbed();

    public boolean checkSpeedIsZero() {
        return getCurrentSpeed() == 0;
    }
}

