import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class Workshop<T extends Car> {
    private CarsInOut<T> carListTool;

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
}
