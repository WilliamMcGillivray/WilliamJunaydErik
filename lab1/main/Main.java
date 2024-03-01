package main;


import main.controller.CarController;
import main.model.ButtonImplementation;
import main.model.VehicleGenerator;
import main.model.VehicleModels.Vehicle;
import main.model.VehicleModels.Volvo240;
import main.model.Workshop;
import main.view.CarView;

public class Main {

    public static void main(String[] args) {
        VehicleGenerator vg = new VehicleGenerator();
        CarView frame = new CarView("CarSim 1.0");
        vg.addObserver(frame);
        ButtonImplementation<Vehicle> button = new ButtonImplementation<>(vg);
        Workshop<Volvo240> workshop = new Workshop<>(4);
        CarController cc = new CarController(frame, button, workshop);
        cc.getTimer().start();


//        bl.addVehicle(VehicleGenerator.addVolvo(0, 0
//        ));
//        cc.addVehicle(VehicleGenerator.addSaab(0, cc.getYDistanceBetweenVehicles()));
//        cc.addVehicleToArr(VehicleGenerator.addScania(0, 2*cc.getYDistanceBetweenVehicles()));

//        cc.frame = new CarView("CarSim 1.0");
//        cc.volvoWorkshop.setLocation(new Point(300, 0));
//        cc.frame.drawPanel.addWorkshopPoint(cc.volvoWorkshop.getLocation());
        //cc.addVehicleToArr(vehicleGenerator.addSaab(0,0));

    }

}
