package main;

import main.VehicleGeneral.VehicleGenerator;
import main.VehicleGeneral.VehicleModels.Saab95;
import main.VehicleGeneral.VehicleModels.Scania;
import main.VehicleGeneral.VehicleModels.Vehicle;

import javax.swing.*;
import java.util.ArrayList;

public class Buttons<T extends Vehicle> {
    private static final int X = 800;
    private static final int Y = 800;

    private final static int vehicleHeight = 60;

    private ArrayList<T> vehicles = new ArrayList<>();


        // Calls the gas method for each car once

    void gas(double amount, Workshop volvoWorkshop) {
        double gas = amount/100;
        for (T vehicle : vehicles
                ) if (!volvoWorkshop.getCarsInWorkshop().contains(vehicle) && vehicle.getCurrentSpeed()>0) {{
            vehicle.gas(gas);
        }}
    }

    void brake(int amount) {
        double gas = ((double) amount)/100;
        for (T vehicle : vehicles
        ) {
                vehicle.brake(gas);

        }
    }

    void startEngines() {
        for (T vehicle : vehicles
        ) {
            if (vehicle.getCurrentSpeed() < 1) {
                vehicle.startEngine();
            }
        }
    }
    void stopEngines() {
        for (T vehicle : vehicles
        ) {
            vehicle.stopEngine();
        }
    }

    void turboOn() {
        for (T vehicle : vehicles) {
            if(vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOn();
                System.out.println("Turbo is on");
            }
        }
    }

    void turboOff() {
        for (T vehicle : vehicles) {
            if(vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOff();
                System.out.println("Turbo is off");
            }
        }
    }

    void liftBed(){
        for (T vehicle : vehicles) {
            if(vehicle instanceof Scania) {
                ((Scania) vehicle).changeFlatbedAngle(70);

            }
        }
    }

    void lowerBed(){
        for (T vehicle : vehicles) {
            if(vehicle instanceof Scania) {
                ((Scania) vehicle).changeFlatbedAngle(0);

            }
        }
    }

    public void removeVehicle(){
        if (vehicles.size() > 0){
            vehicles.removeLast();
            System.out.println("size " + vehicles.size());
        }
    }

    public ArrayList<T> getVehicles() {
        return vehicles;
    }


    public Vehicle addVehicle() {
        Object[] options = {"Add Random Car", "Add Volvo240","Add Saab95","Add Scania"};
        int choice = JOptionPane.showOptionDialog(null, "Choose an option:", "Add Car",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        double closestYPos;

        if (vehicles.size() > 0) {
            closestYPos = vehicles.getLast().getLocation().getY();
        } else {
            closestYPos = -vehicleHeight;
        }

        Vehicle newVehicle;

        if (choice == 0) {
            newVehicle = VehicleGenerator.addRandomVehicle(0, (int) closestYPos + vehicleHeight);
        }
        else if (choice == 1) {
            newVehicle = VehicleGenerator.addVolvo(0, (int) closestYPos + vehicleHeight);
        }
        else if (choice == 2) {
            newVehicle = VehicleGenerator.addSaab(0, (int) closestYPos + vehicleHeight);
        }
        else {
            newVehicle = VehicleGenerator.addScania(0, (int) closestYPos + vehicleHeight);
        }
        vehicles.add((T) newVehicle);
        return newVehicle;

    }

}
