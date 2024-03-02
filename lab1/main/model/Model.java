package main.model;

import main.model.VehicleModels.Saab95;
import main.model.VehicleModels.Scania;
import main.model.VehicleModels.Volvo240;
import main.model.VehicleModels.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Model<T extends Vehicle> {
    private static final int X = 800;
    private static final int Y = 800;

    private final static int vehicleHeight = 60;

    private ArrayList<T> vehicles = new ArrayList<>();

    private VehicleGenerator vg;

    private static ArrayList<Observer> observerList = new ArrayList<>();

    private final int delay = 50;

    private Timer timer = new Timer(delay, new TimerListener());

    private static Boundaries boundaries = new Boundaries();

    private Point volvoWorkshopPoint = new Point(300, 0);

    private Workshop<Volvo240> volvoWorkshop = new Workshop(5);

    // Calls the gas method for each car once

    public Model(VehicleGenerator VG){
        vg = VG;
        volvoWorkshop.setLocation(volvoWorkshopPoint);
        notifyObserver();
    }

    public void addObserver(Observer observer){
        observerList.add(observer);
    }

    public void removeObserver(Observer observer){
        observerList.remove(observer);
    }

    public void gas(double amount) {
        double gas = amount/100;
        for (T vehicle : vehicles
                ) if (!volvoWorkshop.getCarsInWorkshop().contains(vehicle) && vehicle.getCurrentSpeed()>0) {{
            vehicle.gas(gas);
        }}
    }

    public void brake(int amount) {
        double gas = ((double) amount)/100;
        for (T vehicle : vehicles
        ) {
                vehicle.brake(gas);
        }
    }

    public void startEngines() {
        for (T vehicle : vehicles
        ) {
            if (vehicle.getCurrentSpeed() < 1) {
                vehicle.startEngine();
            }
        }
    }
    public void stopEngines() {
        for (T vehicle : vehicles
        ) {
            vehicle.stopEngine();
        }
    }

    public void turboOn() {
        for (T vehicle : vehicles) {
            if(vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOn();
                System.out.println("Turbo is on");
            }
        }
    }

    public void turboOff() {
        for (T vehicle : vehicles) {
            if(vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOff();
                System.out.println("Turbo is off");
            }
        }
    }

    public void liftBed(){
        for (T vehicle : vehicles) {
            if(vehicle instanceof Scania) {
                ((Scania) vehicle).changeFlatbedAngle(70);
            }
        }
    }

    public void lowerBed(){
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
        String[] options = {"Add Random Car", "Add Volvo240","Add Saab95","Add Scania"};
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
            newVehicle = vg.addRandomVehicle(0, (int) closestYPos + vehicleHeight);
        }
        else if (choice == 1) {
            newVehicle = vg.addVolvo(0, (int) closestYPos + vehicleHeight);
        }
        else if (choice == 2) {
            newVehicle = vg.addSaab(0, (int) closestYPos + vehicleHeight);
        }
        else {
            newVehicle = vg.addScania(0, (int) closestYPos + vehicleHeight);
        }
        notifyObserver();
        vehicles.add((T) newVehicle);
        return newVehicle;
    }

    private class TimerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : vehicles) {
                int x = (int) Math.round(vehicle.getLocation().getX());
                int y = (int) Math.round(vehicle.getLocation().getY());

                vehicle.move();

                int[] list = boundaries.checkBoundaries(vehicle, x, y);
                x = list[0];
                y = list[1];

                if (vehicle instanceof Volvo240) {
                    boundaries.checkWorkshop((Volvo240) vehicle, x, y, volvoWorkshop);
                }

//                frame.drawPanel.moveit(buttons.getVehicles().indexOf(vehicle), x, y);

                // repaint() calls the paintComponent method of the panel
            }
            notifyObserver();
//            frame.drawPanel.repaint();
        }
    }

    private static void notifyObserver(){
        for (Observer observer : observerList) {
            observer.update();
        }
    }

    public Point getWorkshopPosition(){
        return volvoWorkshopPoint;
    }

    public Timer getTimer() {
        return timer;
    }

}
