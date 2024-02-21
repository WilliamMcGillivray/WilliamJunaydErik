package main.VehicleGeneral.VehicleModels;

import java.awt.*;


public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;

    public Volvo240(){
        super(4, Color.black, 100, "main.VehicleGeneral.VehicleModels.Volvo240", 5, 1.7);
    }

    @Override
    public double speedFactor(){
        return this.getEnginePower() * 0.01 * trimFactor;
    }

}

