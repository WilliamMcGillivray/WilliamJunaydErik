package main.model;

import main.model.VehicleModels.Vehicle;

import java.awt.*;

public interface AddVehicleObserver {
    void observeVehicle(Vehicle vehicle);
}
