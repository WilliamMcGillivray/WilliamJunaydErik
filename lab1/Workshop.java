import java.awt.*;
import java.util.ArrayList;

public class Workshop<T extends Car> {

    private ArrayList<T> carsInWorkshop;
    private int maxCapacity;

    public Workshop(int maxCapacity) {
        this.carsInWorkshop = new ArrayList<T>(maxCapacity);
        this.maxCapacity = maxCapacity;
    }

    public void acceptCar(T car) {
        if (carsInWorkshop.size() < maxCapacity) {
            carsInWorkshop.add(car);
        }
        else {throw new IllegalArgumentException("Workshop is full");

        }
    }

    public T releaseCar() {
        return carListTool.unloadCar();
    }

    public ArrayList<T> getCarsInWorkshop() {
        return carsInWorkshop;
    }
}
