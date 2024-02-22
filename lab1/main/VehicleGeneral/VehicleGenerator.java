package main.VehicleGeneral;
import main.VehicleGeneral.VehicleModels.*;

import java.awt.*;

public class VehicleGenerator {

    public Volvo240 generateVolvo(int x, int y){
        Volvo240 volvo240 = new Volvo240();
        volvo240.setLocation(new Point(x, y));
        return volvo240;
    }

    public Saab95 generateSaab(int x, int y){
        Saab95 saab95 = new Saab95();
        saab95.setLocation(new Point(x, y));
        return saab95;
    }

    public Scania generateScania(int x, int y){
        Scania scania = new Scania();
        scania.setLocation(new Point(x, y));
        return scania;
    }

    public CarTransport generateCarTransport(int x, int y){
        CarTransport carTransport = new CarTransport();
        carTransport.setLocation(new Point(x,y));
        return carTransport;
    }

}
