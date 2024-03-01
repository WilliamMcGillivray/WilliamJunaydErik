package main.model.VehicleModels;

import main.view.DrawPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Scania extends Truck {
    
    private double flatbedAngle;

    private Image image;

    public Scania() {
        super(2, Color.red, 300, "main.VehicleGeneral.VehicleModels.Scania");
        this.flatbedAngle = 0;
        readImage();
    }
    @Override
    public boolean checkFlatbed() {
        return flatbedAngle == 0.0;
    }
    public void changeFlatbedAngle(int amount) {
        if (checkSpeedIsZero() && amount <= 70 && amount >= 0) {
            flatbedAngle = amount;
        }
        else {throw new IllegalArgumentException("The angle has to be >=0 and <=70 degrees and speed = 0");
        }
    }

    @Override
    public double speedFactor() {
        return 0.5;
    }

    public double getFlatbedAngle(){
        return this.flatbedAngle;
    }

    protected void readImage(){
        try {
            image = ImageIO.read(DrawPanel.class.getResourceAsStream("../../pics/Scania.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public Image getImage(){
        return image;
    }


}
