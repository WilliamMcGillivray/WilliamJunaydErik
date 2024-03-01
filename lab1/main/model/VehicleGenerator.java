package main.model;
import main.model.VehicleModels.*;

import java.util.ArrayList;
import java.util.Random;

import java.awt.*;

public class VehicleGenerator {

    private static final Random random = new Random();

    private static ArrayList<AddVehicleObserver> observerList = new ArrayList<>();

    public void addObserver(AddVehicleObserver observer){
        observerList.add(observer);
    }

    public static Volvo240 addVolvo(int x, int y){
        Volvo240 volvo240 = new Volvo240();
        volvo240.setLocation(new Point(x, y));
        sendVehicleToObserver(volvo240);
        return volvo240;
    }

    public static Saab95 addSaab(int x, int y){
        Saab95 saab95 = new Saab95();
        saab95.setLocation(new Point(x, y));
        sendVehicleToObserver(saab95);
        return saab95;
    }

    public static Scania addScania(int x, int y){
        Scania scania = new Scania();
        scania.setLocation(new Point(x, y));
        sendVehicleToObserver(scania);
        return scania;
    }

    public static Vehicle addRandomVehicle(int x, int y){
        Vehicle[] vehicleTypeList = {new Volvo240(), new Saab95(), new Scania()};
        Vehicle selectedVehicle = vehicleTypeList[random.nextInt(vehicleTypeList.length)];
        selectedVehicle.setLocation(new Point(x, y));
        sendVehicleToObserver(selectedVehicle);
        return selectedVehicle;
    }

    private static void sendVehicleToObserver(Vehicle vehicle){
        for (AddVehicleObserver observer : observerList) {
            observer.observeVehicle(vehicle);
        }
    }



}
