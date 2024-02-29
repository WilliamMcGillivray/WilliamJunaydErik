package main.model;

import main.model.VehicleModels.Car;
import main.model.CarsInOut;

import java.awt.*;
import java.util.Stack;

public class Workshop<T extends Car> {
    private CarsInOut<T> carListTool;
    private Point location;

    public Workshop(int maxCapacity) {
        carListTool = new CarsInOut<T>(maxCapacity);
    }

    public void acceptCar(T car) {
        carListTool.loadCar(car);
    }

    public T releaseCar() {
        return carListTool.unloadCar();
    }

    public Stack<T> getCarsInWorkshop() {
        return carListTool.getCarList();
    }

    public void setLocation(Point location) {
        this.location = location;}
    public Point getLocation() {
        return location;
    }
}
