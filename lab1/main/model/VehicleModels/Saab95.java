package main.model.VehicleModels;

import main.view.DrawPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Saab95 extends Car {

    private boolean turboOn;

    private Image image;

    public Saab95() {
        super(2, Color.red, 125, "main.VehicleGeneral.VehicleModels.Saab95", 4.8, 1.8);
        turboOn = false;
        readImage();
    }

    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }

    public boolean getTurboOn(){
        return this.turboOn;
    }

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return this.getEnginePower() * 0.01 * turbo;
    }
    @Override
    protected void readImage(){
        try {
            image = ImageIO.read(DrawPanel.class.getResourceAsStream("../../pics/Saab95.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Image getImage(){
        return image;
    }


}
