package main.model.VehicleModels;

import main.model.TruckInterface;

import java.awt.*;

abstract class Truck extends Vehicle implements TruckInterface {


    public Truck(int nrDoors, Color color, double enginePower, String modelname) {
        super(nrDoors, color, enginePower, modelname);
    }

    public abstract boolean checkFlatbed();

    public boolean checkSpeedIsZero() {
        return getCurrentSpeed() == 0;
    }

    @Override
    public void gas(double amount){
        if (checkFlatbed()) {
            super.gas(amount);
        }
        else {throw new IllegalArgumentException("Flatbed needs to be flat");
        }
    }

    @Override
    public void startEngine(){
        if (checkFlatbed()) {
            super.startEngine();
        }
        else {throw new IllegalArgumentException("Flatbed needs to be flat");
        }
    }
}

