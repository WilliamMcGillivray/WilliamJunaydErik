import java.awt.*;
import java.util.Stack;

public class CarTransport extends Truck {
    private CarsInOut carListTool;
    private boolean rampUp;
    private double maxLengthCar;
    private double maxWidthCar;

    public CarTransport() {
        super(2, Color.blue, 1000, "LongTrader");
        carListTool = new CarsInOut(7);
        rampUp = true;
        maxLengthCar = 5;
        maxWidthCar = 2.5;
    }

    @Override
    public boolean checkFlatbed() {
        return rampUp;
    }

    @Override
    protected double speedFactor() {
        return 0.5;
    }

    public void raiseRamp() {
        if (checkSpeedIsZero()) {
            rampUp = true;
        } else {
            throw new IllegalArgumentException("The truck cannot move while raising the ramp");
        }
    }

    public void lowerRamp() {
        if (checkSpeedIsZero()) {
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
        if (checkSpeedIsZero() && car.checkCarSpeedIsZero() && !checkFlatbed() &&
                !getCarList().contains(car) && isCloseToTruck(car) && car.getLength() <= maxLengthCar &&
                car.getWidth() <= maxWidthCar) {
            carListTool.loadCar(car);
            car.setLocation(this.getLocation());

        } else {
            throw new IllegalArgumentException("Can't load because of either size constraints or " +
                    "max number of cars already reached");
        }
    }

    public Car unloadCar() {
        if (!getCarList().isEmpty() && !checkFlatbed() && checkSpeedIsZero()) {
            Car carToUnload = carListTool.unloadCar();
            double x = this.getLocation().getX() - carToUnload.getLength() - 1;
            double y = this.getLocation().getY();

            int xInt = (int) x;
            int yInt = (int) y;

            Point p = new Point(xInt, yInt);
            carToUnload.setLocation(p);
            return carToUnload;
        }
        else {throw new IllegalArgumentException("Car list is empty");}
    }

    public Stack<Car> getCarList() {
        return carListTool.getCarList();
    }



}

