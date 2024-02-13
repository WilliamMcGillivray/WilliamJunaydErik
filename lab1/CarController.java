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

public class CarController<T extends Vehicle> {
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

    private static int vehicleWidth = 100;
    private static int vehicleHeight = 60;
    private static int vehicleDistance = vehicleHeight + 100;

    private Workshop<Volvo240> volvoWorkshop = new Workshop<>(4);
    private Point volvoWorkshopPoint = new Point(300,0);; //101x96

    // A list of vehicles
    private ArrayList<T> vehicles = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController<Vehicle> cc = new CarController<>();

        cc.vehicles.add(new Volvo240());
        cc.vehicles.add(new Saab95());
        cc.vehicles.add(new Scania());
        cc.vehicles.get(1).setLocation(new Point(0, vehicleDistance));
        cc.vehicles.get(2).setLocation(new Point(0, 2*vehicleDistance));

        cc.volvoWorkshop.setLocation(new Point(300, 0));

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
            for (T vehicle : vehicles) {
                int x = (int) Math.round(vehicle.getLocation().getX());
                int y = (int) Math.round(vehicle.getLocation().getY());

                vehicle.move();

                int[] list = checkBoundaries(vehicle, x, y);
                x = list[0];
                y = list[1];

                if (vehicle instanceof Volvo240) {
                    checkWorkshop((Volvo240) vehicle, x, y);}

//                if (x > cc.volvoWorkshop.getLocation().getX() - vehicleWidth && x < volvoWorkshopPoint.getX() + 101){
//                    if (y >= volvoWorkshopPoint.getY() && y <= volvoWorkshopPoint.getY() + 96 && (vehicle instanceof Volvo240)){
//                        Point wallPoint = null;
//                        wallPoint = new Point((int) volvoWorkshopPoint.getX(), (int) volvoWorkshopPoint.getY());
//                        vehicle.setLocation(wallPoint);
//                        vehicle.stopEngine();
//                        x = (int) Math.round(vehicle.getLocation().getX());
//                        y = (int) Math.round(vehicle.getLocation().getY());
//                    }
//                }

                frame.drawPanel.moveit(vehicles.indexOf(vehicle), x, y);
                System.out.println(x);
                System.out.println(y);
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

    void checkWorkshop(Vehicle vehicle, int x, int y) {
        if (x > volvoWorkshop.getLocation().getX() - vehicleWidth && x < volvoWorkshop.getLocation().getX() + 101){
            if (y >= volvoWorkshop.getLocation().getY() && y <= volvoWorkshop.getLocation().getY() + 96){
                volvoWorkshop.acceptCar((Volvo240) vehicle);
                Point wallPoint = null;
                wallPoint = new Point((int) volvoWorkshop.getLocation().getX(), (int) volvoWorkshop.getLocation().getY());
                vehicle.setLocation(wallPoint);
                vehicle.stopEngine();
                x = (int) Math.round(vehicle.getLocation().getX());
                y = (int) Math.round(vehicle.getLocation().getY());
            }
        }
    }

    int[] checkBoundaries(Vehicle vehicle, int x, int y) {
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

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount)/100;
        for (T vehicle : vehicles
                ) {
            vehicle.gas(gas);
        }
    }

    void brake(int amount) {
        double gas = ((double) amount)/100;
        for (T vehicle : vehicles
        ) {
            vehicle.brake(gas);
        }
    }

    void startEngines() {
        for (T vehicle : vehicles
        ) {
            vehicle.startEngine();
        }
    }
    void stopEngines() {
        for (T vehicle : vehicles
        ) {
            vehicle.stopEngine();
        }
    }

    void turboOn() {
        for (T vehicle : vehicles) {
            if(vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOn();
                System.out.println("Turbo is on");
            }
        }
    }

    void turboOff() {
        for (T vehicle : vehicles) {
            if(vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOff();
                System.out.println("Turbo is off");
            }
        }
    }

    void liftBed(){
        for (T vehicle : vehicles) {
            if(vehicle instanceof Scania) {
                ((Scania) vehicle).changeFlatbedAngle(70);

            }
        }
    }

    void lowerBed(){
        for (T vehicle : vehicles) {
            if(vehicle instanceof Scania) {
                ((Scania) vehicle).changeFlatbedAngle(0);

            }
        }
    }


    public static int getYDistanceBetweenVehicles(){
        return vehicleDistance;
    }
}

//    public ArrayList<T> getVehicles() {
//        return vehicles;
//    }
//}
