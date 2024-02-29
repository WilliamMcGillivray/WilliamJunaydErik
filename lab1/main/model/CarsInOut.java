package main.model;

import main.model.VehicleModels.Car;

import java.util.Stack;

public class CarsInOut<T extends Car> {

    private Stack<T> carList;
    private int maxCapacity;

    public CarsInOut(int amount) {
        carList = new Stack<T>();
        maxCapacity = amount;
    }

    public void loadCar(T car) {
        if (carList.size() < maxCapacity) {
            carList.add(car);
        }
        else {throw new IllegalArgumentException("main.VehicleGeneral.VehicleModels.Car list is full");}
    }

    public T unloadCar() {
        if (!carList.isEmpty()) {
            T carToUnload = carList.pop();
            return carToUnload;
        }
        else {throw new IllegalArgumentException("main.VehicleGeneral.VehicleModels.Car list is empty");}
    }

    public Stack<T> getCarList() {
        return carList;
    }
}