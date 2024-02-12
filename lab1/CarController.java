import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;

    private int panelWidth = 800;
    private int panelHeight = 560;

    private static int carWidth = 100;
    private static int carHeight = 60;
    private static int carDistance = carHeight + 100;


    // A list of cars, modify if needed
    private ArrayList<Car> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();


        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                int x = (int) Math.round(car.getLocation().getX());
                int y = (int) Math.round(car.getLocation().getY());

                car.move();

                if (car.getLocation().getX() > panelWidth - carWidth || car.getLocation().getX() < 0) {
                    Point wallPoint;

                    if (car.getLocation().getX() > panelWidth - carWidth) {
                        wallPoint = new Point(panelWidth - carWidth, 0);
                    }
                    else {
                        wallPoint = new Point(0, 0);
                    }

                    car.setLocation(wallPoint);
                    car.stopEngine();

                    car.turnRight();
                    car.turnRight();
                    car.startEngine();
                    x = (int) Math.round(car.getLocation().getX());
                    y = (int) Math.round(car.getLocation().getY());

                }

                System.out.println(y);
                System.out.println("Angle: " + car.getAngle());

                frame.drawPanel.moveit(cars.indexOf(car), x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }
//    private boolean DroveIntoWall(Car car){
//        boolean isTooFarRight = car.getLocation().getX() > panelWidth - carWidth;
//        boolean isTooFarLeft = car.getLocation().getX() < 0;
//
//        //boolean isTooFarUp = car.getLocation().getY() < 0;
//        //boolean isTooFarDown = car.getLocation().getY() < panelHeight - carHeight;
//    }
    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount)/100;
        for (Car car : cars
                ) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double gas = ((double) amount)/100;
        for (Car car : cars
        ) {
            car.brake(gas);
        }
    }

    void startEngines() {
        for (Car car : cars
        ) {
            car.startEngine();
        }
    }
    void stopEngines() {
        for (Car car : cars
        ) {
            car.stopEngine();
        }
    }

    void turboOn() {
        for (Car car : cars) {
            if(car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
                System.out.println("Turbo is on");
            }
        }
    }

    void turboOff() {
        for (Car car : cars) {
            if(car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
                System.out.println("Turbo is off");
            }
        }
    }

//    void liftBed(){
//        for (Car car : cars) {
//            if(car instanceof Scania) {
//                ((Scania) car).changeFlatbedAngle(70);
//
//            }
//        }
//    }


    public static int getYDistanceBetweenCars(){
        return carDistance;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }
}
