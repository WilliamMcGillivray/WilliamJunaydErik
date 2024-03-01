package main.model;

import main.model.VehicleModels.Car;
import main.model.CarsInOut;
import main.view.DrawPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Stack;

public class Workshop<T extends Car> {
    private CarsInOut<T> carListTool;
    private Point location;

    private Image image;

    public Workshop(int maxCapacity) {
        carListTool = new CarsInOut<T>(maxCapacity);
        readImage();
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

    private void readImage(){
        try {
            image = ImageIO.read(DrawPanel.class.getResourceAsStream("../../pics/VolvoBrand.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Image getImage(){
        return image;
    }
}
