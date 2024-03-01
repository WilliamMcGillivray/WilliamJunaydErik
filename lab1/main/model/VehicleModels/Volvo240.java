package main.model.VehicleModels;

import main.view.DrawPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;


public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;

    private Image image;

    public Volvo240(){
        super(4, Color.black, 100, "main.VehicleGeneral.VehicleModels.Volvo240", 5, 1.7);
        readImage();
    }

    @Override
    public double speedFactor(){
        return this.getEnginePower() * 0.01 * trimFactor;
    }

    protected void readImage(){
        try {
            image = ImageIO.read(DrawPanel.class.getResourceAsStream("../../pics/Volvo240.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Image getImage(){
        return image;
    }

}

