package main.model.VehicleModels;
import main.Movable;

import java.awt.*;

//WASSUUUUPPPP
//tjjjjjenare

abstract public class Vehicle implements Movable {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name

    private double angle; // Direction the car travels in degrees
    private Point location;

    public Vehicle(int nrDoors, Color color, double enginePower, String modelname){
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelname;
        location = new Point();
        stopEngine();
    }

    @Override
    public void move() {

        double d = Math.toRadians(angle);
        System.out.println("current speed: " + this.currentSpeed);
        System.out.println("x-vinkeln: " + Math.cos(d));
        System.out.println("y-vinkeln: " + Math.sin(d));

        double x = location.getX() + Math.cos(d) * this.currentSpeed;
        double y = location.getY() + Math.sin(d) * this.currentSpeed;

        int xInt = (int) x;
        int yInt = (int) y;

        location.setLocation(xInt, yInt);
    }

    @Override
    public void turnLeft() {
        angle += 90;
        //this.move();
        System.out.println("Turning left");
    }

    @Override
    public void turnRight() {
        angle -= 90;
        //this.move();
        System.out.println("Turning right");
    }

    public int getNrDoors(){

        return this.nrDoors;
    }
    public double getEnginePower(){

        return this.enginePower;
    }

    public double getCurrentSpeed(){

        return this.currentSpeed;
    }

    public Color getColor(){

        return this.color;
    }

    public void setColor(Color clr){

        this.color = clr;
    }

    public void startEngine(){

        this.currentSpeed = 1;
    }

    public void stopEngine(){
        this.currentSpeed = 0;
    }

    protected abstract double speedFactor();


    private void incrementSpeed(double amount){
        this.currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,this.enginePower);
    }

    private void decrementSpeed(double amount){
        this.currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        if (amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
        }
        else {throw new IllegalArgumentException("Has to be between 0 and 1");
        }
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        }
        else {throw new IllegalArgumentException("Has to be between 0 and 1");
        }

    }

    public double getAngle(){
        return this.angle;
    }

    public Point getLocation() {
        return location;
    }

    public Point setLocation(Point newLocation) {
        location.setLocation(newLocation);
        return location;
    }


    public String getModelName(){
        return this.modelName;
    }

}



