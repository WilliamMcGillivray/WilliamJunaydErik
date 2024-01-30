import java.awt.*;
import java.util.Stack;

public class CarTransport extends Truck {
    private boolean rampUp;
    private Stack<Car> carList;
    private int maxCars;
    private double maxLengthCar;
    private double maxWidthCar;

    public CarTransport() {
        super(2, Color.blue, 1000, "LongTrader");
        rampUp = true;
        this.carList = new Stack<>();
        this.maxCars = 7;
        maxLengthCar = 5;
        maxWidthCar = 2.5;
    }

    @Override
    protected double speedFactor() {
        return 0.5;
    }

    public void raiseRamp() {
        if (getCurrentSpeed() == 0) {
            rampUp = true;
        } else {
            throw new IllegalArgumentException("The truck cannot move while raising the ramp");
        }
    }

    public void lowerRamp() {
        if (getCurrentSpeed() == 0) {
            rampUp = false;
        } else {
            throw new IllegalArgumentException("The truck cannot move while lowering the ramp");
        }
    }

    public boolean getRampPosition() {
        return this.rampUp;
    }



    private boolean isCloseToTruck(Car car) {

        return car.getLocation().getY() == this.getLocation().getY() &&
                (car.getLocation().getX() - this.getLocation().getX()) < 0.5;
    }

    public void loadCar(Car car) {
        if (carList.size() < this.maxCars && getCurrentSpeed() == 0 && !rampUp &&
                !carList.contains(car) && isCloseToTruck(car) && car.getLength() <= maxLengthCar &&
                car.getWidth() <= maxWidthCar) {
            carList.add(car);
            car.setLocation(this.getLocation());

        } else {
            throw new IllegalArgumentException("Can't load because of either size constraints or " +
                    "max number of cars already reached");
        }
    }

    public void unloadCar() {
        if (!carList.isEmpty() && !rampUp && getCurrentSpeed() == 0) {
            Car carToUnload = carList.pop();
            double x = this.getLocation().getX() - carToUnload.getLength() - 1;
            double y = (int) this.getLocation().getY();

            int xInt = (int) x;
            int yInt = (int) y;

            Point p = new Point(xInt, yInt);
            carToUnload.setLocation(p);
        }
    }

    public Stack<Car> getCarList() {
        return this.carList;
    }



}

