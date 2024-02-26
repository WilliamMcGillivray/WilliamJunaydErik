package main;

import main.VehicleGeneral.VehicleGenerator;
import main.VehicleGeneral.VehicleModels.Saab95;
import main.VehicleGeneral.VehicleModels.Scania;
import main.VehicleGeneral.VehicleModels.Volvo240;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        VehicleGenerator vehicleGenerator = new VehicleGenerator();

        CarController cc = new CarController();

        cc.addVehicleToArr(vehicleGenerator.addSaab(0,0));

        cc.getTimer().start();




    }

}
