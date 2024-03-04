package main;


import main.controller.CarController;
import main.model.Model;
import main.model.VehicleGenerator;
import main.model.VehicleModels.Vehicle;
import main.model.VehicleModels.Volvo240;
import main.model.Workshop;
import main.view.Buttons;
import main.view.DrawPanel;

public class Main {

    public static void main(String[] args) {
        VehicleGenerator vg = new VehicleGenerator();

        Model<Vehicle> aModel = new Model<>(vg);
        DrawPanel view = new DrawPanel(800,560, aModel);
        aModel.addObserver(view);

        Buttons buttons = new Buttons("CarSim 1.0", view);

        CarController cc = new CarController(buttons, aModel);

        aModel.getTimer().start();

    }

}
