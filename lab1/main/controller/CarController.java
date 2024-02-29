package main.controller;


import main.model.Boundaries;
import main.model.ButtonImplementation;
import main.model.Workshop;
import main.model.VehicleModels.Vehicle;
import main.model.VehicleModels.Volvo240;
import main.view.CarView;

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

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;

    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;

    private Workshop<Volvo240> volvoWorkshop = new Workshop<>(4);
    private Point volvoWorkshopPoint = new Point(300, 0);

    private final int maxNrVehicles = 5;

    private ButtonImplementation buttons = new ButtonImplementation();

    private Boundaries boundaries = new Boundaries();

    //methods:


    public CarController() {
        volvoWorkshop.setLocation(volvoWorkshopPoint);
        frame = new CarView("CarSim 1.0");
        frame.drawPanel.addWorkshopPoint(volvoWorkshop.getLocation());
        frame.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttons.startEngines();
            }
        });

        frame.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttons.stopEngines();
            }
        });

        frame.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttons.gas(frame.gasAmount, volvoWorkshop);
            }
        });

        frame.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttons.brake(frame.gasAmount);
            }
        });

        frame.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttons.turboOn();
            }
        });


        frame.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttons.turboOff();
            }
        });

        frame.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttons.liftBed();

            }
        });

        frame.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttons.lowerBed();
            }
        });

        frame.addVehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buttons.getVehicles().size() < maxNrVehicles) {
                    Vehicle newVehicle = buttons.addVehicle();
                    frame.viewVehicle(newVehicle);
                }
            }
        });

        frame.removeVehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttons.removeVehicle();
                frame.drawPanel.removeImage();
                frame.drawPanel.removePoint();
            }
        });


    }


    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            ArrayList<Vehicle> vehicleList = buttons.getVehicles();
            for (Vehicle vehicle : vehicleList) {
                int x = (int) Math.round(vehicle.getLocation().getX());
                int y = (int) Math.round(vehicle.getLocation().getY());

                vehicle.move();

                int[] list = boundaries.checkBoundaries(vehicle, x, y);
                x = list[0];
                y = list[1];

                if (vehicle instanceof Volvo240) {
                    boundaries.checkWorkshop((Volvo240) vehicle, x, y, volvoWorkshop);
                }

                frame.drawPanel.moveit(buttons.getVehicles().indexOf(vehicle), x, y);

                // repaint() calls the paintComponent method of the panel

            }
            frame.drawPanel.repaint();
        }
    }

    public Timer getTimer() {
        return timer;
    }
}
