package main.VehicleGeneral;
import main.VehicleGeneral.VehicleModels.*;
import java.util.Random;

import java.awt.*;

public class VehicleGenerator {

    private static final Random random = new Random();

    public static Volvo240 addVolvo(int x, int y){
        Volvo240 volvo240 = new Volvo240();
        volvo240.setLocation(new Point(x, y));

        return volvo240;
    }

    public static Saab95 addSaab(int x, int y){
        Saab95 saab95 = new Saab95();
        saab95.setLocation(new Point(x, y));
        return saab95;
    }

    public static Scania addScania(int x, int y){
        Scania scania = new Scania();
        scania.setLocation(new Point(x, y));
        return scania;
    }

    public static Vehicle addRandomVehicle(int x, int y){
        Vehicle[] vehicleTypeList = {new Volvo240(), new Saab95(), new Scania()};
        Vehicle selectedVehicle = vehicleTypeList[random.nextInt(vehicleTypeList.length)];
        selectedVehicle.setLocation(new Point(x, y));
        return selectedVehicle;
    }
}
