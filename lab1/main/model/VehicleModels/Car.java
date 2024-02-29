package main.model.VehicleModels;

import java.awt.*;

abstract public class Car extends Vehicle {

    final private double length;
    final private double width;

    public Car (int nrDoors, Color color, double enginePower, String modelname, double length, double width) {
        super(nrDoors, color, enginePower, modelname);
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return this.length;
    }

    public double getWidth() {
        return this.width;
    }

    public boolean checkCarSpeedIsZero(){
        return getCurrentSpeed() == 0.0;
    }

}
