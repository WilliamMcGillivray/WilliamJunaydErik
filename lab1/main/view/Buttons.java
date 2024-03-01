package main.view;

import main.model.Observer;
import main.model.VehicleModels.Vehicle;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class Buttons extends JFrame {
    private static final int X = 800;
    private static final int Y = 800;

    JPanel controlPanel = new JPanel();
    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    public int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");
    public JButton addVehicleButton = new JButton("Add Vehicle");
    public JButton removeVehicleButton = new JButton("Remove Vehicle");

    public JButton gasButton = new JButton("Gas");
    public JButton brakeButton = new JButton("Brake");
    public JButton turboOnButton = new JButton("Saab Turbo on");
    public JButton turboOffButton = new JButton("Saab Turbo off");
    public JButton liftBedButton = new JButton("Lift Bed");
    public JButton lowerBedButton = new JButton("Lower Lift Bed");

    public JButton startButton = new JButton("Start all cars");
    public JButton stopButton = new JButton("Stop all cars");

    public DrawPanel drawPanel;
    // Constructor
    public Buttons(String framename, DrawPanel drawP){
        drawPanel = drawP;
        initComponents(framename, drawP);
    }



    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work
    private void initComponents(String title, DrawPanel drawP) {
        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawP);

        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
                System.out.println("gasamount " + gasAmount);
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,4));
        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.add(addVehicleButton, 6);
        controlPanel.add(removeVehicleButton,7);
        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);

        startButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(startButton);

        stopButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(stopButton);

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();
        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Adds a new vehicle to the view by adding an image and the location of that car
//    public void viewVehicle(Vehicle vehicle){
//        if (vehicle instanceof Volvo240) {
//            drawPanel.addVehicleImage(drawPanel.getVolvoImage());
//        } else if (vehicle instanceof Saab95) {
//            drawPanel.addVehicleImage(drawPanel.getSaabImage());
//        } else if (vehicle instanceof Scania) {
//            drawPanel.addVehicleImage(drawPanel.getScaniaImage());
//        }
//        drawPanel.addPoint(vehicle.getLocation());
//    }

//    public void observeVehicle(Vehicle vehicle){
//        drawPanel.addImage(vehicle.getImage());
//        drawPanel.addPoint(vehicle.getLocation());
//    }
}