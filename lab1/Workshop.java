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

    public void releaseCar(T car) {
        if (carsInWorkshop.contains(car)) {
            carsInWorkshop.remove(car);
        }
        else {throw new IllegalArgumentException("The specified car is not in the workshop");
        }
    }

    public ArrayList<T> getCarsInWorkshop() {
        return carsInWorkshop;
    }
}
