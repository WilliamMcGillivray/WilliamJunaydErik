package main.model;

import main.model.VehicleModels.Volvo240;
import main.model.VehicleModels.Vehicle;

import java.awt.*;

public class Boundaries {

    private final static int panelWidth = 800;
    private final static int vehicleWidth = 100;

    public static int[] checkBoundaries(Vehicle vehicle, int x, int y) {
        if (x > panelWidth - vehicleWidth || x < 0) {
            Point wallPoint;

            if (x > panelWidth - vehicleWidth) {
                wallPoint = new Point(panelWidth - vehicleWidth, y);
            }
            else {
                wallPoint = new Point(0, y);
            }

            vehicle.setLocation(wallPoint);
            vehicle.stopEngine();

            vehicle.turnRight();
            vehicle.turnRight();
            vehicle.startEngine();
            x = (int) Math.round(vehicle.getLocation().getX());
            y = (int) Math.round(vehicle.getLocation().getY());
        }
        return new int[] {x, y};
    }

    public static void checkWorkshop(Vehicle vehicle, int x, int y, Workshop volvoWorkshop) {
        if (x > volvoWorkshop.getLocation().getX() - vehicleWidth && x < volvoWorkshop.getLocation().getX() + 101 &&
                !volvoWorkshop.getCarsInWorkshop().contains(vehicle)){
            if (y >= volvoWorkshop.getLocation().getY() && y <= volvoWorkshop.getLocation().getY() + 96){
                Point wallPoint;
                wallPoint = new Point((int) volvoWorkshop.getLocation().getX(), (int) volvoWorkshop.getLocation().getY());
                vehicle.setLocation(wallPoint);
                vehicle.stopEngine();
                x = (int) Math.round(vehicle.getLocation().getX());
                y = (int) Math.round(vehicle.getLocation().getY());
                volvoWorkshop.acceptCar((Volvo240) vehicle);

            }
        }
        if (x < volvoWorkshop.getLocation().getX() - vehicleWidth || x > volvoWorkshop.getLocation().getX() + 101) {
            if (volvoWorkshop.getCarsInWorkshop().contains(vehicle)) {
                volvoWorkshop.releaseCar();
            }
        }
    }

}