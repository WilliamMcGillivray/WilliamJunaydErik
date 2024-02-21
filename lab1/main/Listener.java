//package main;
//
//import javax.swing.*;
//import javax.swing.event.ChangeEvent;
//import javax.swing.event.ChangeListener;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//
//public class Listener {
//    private static final int X = 800;
//    private static final int Y = 800;
//    CarController carC;
//    DrawPanel drawPanel = new DrawPanel(X, Y-240);
//
//    JPanel controlPanel = new JPanel();
//    JPanel gasPanel = new JPanel();
//    JSpinner gasSpinner = new JSpinner();
//    int gasAmount = 0;
//    JLabel gasLabel = new JLabel("Amount of gas");
//
//    JButton gasButton = new JButton("Gas");
//    JButton brakeButton = new JButton("Brake");
//    JButton turboOnButton = new JButton("Saab Turbo on");
//    JButton turboOffButton = new JButton("Saab Turbo off");
//    JButton liftBedButton = new JButton("Lift Bed");
//    JButton lowerBedButton = new JButton("Lower Lift Bed");
//
//    JButton startButton = new JButton("Start all cars");
//    JButton stopButton = new JButton("Stop all cars");
//
//    private ArrayList<JComponent> pieces = new ArrayList<>();
//
//    public Listener(CarController CarC){
//
//        gasPanel.setLayout(new BorderLayout());
//        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
//        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);
//
//        controlPanel.setLayout(new GridLayout(2,4));
//
//        controlPanel.add(gasButton, 0);
//        controlPanel.add(turboOnButton, 1);
//        controlPanel.add(liftBedButton, 2);
//        controlPanel.add(brakeButton, 3);
//        controlPanel.add(turboOffButton, 4);
//        controlPanel.add(lowerBedButton, 5);
//        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
//        controlPanel.setBackground(Color.CYAN);
//
//        startButton.setPreferredSize(new Dimension(X/5-15,200));
//        controlPanel.add(startButton);
//
//        stopButton.setPreferredSize(new Dimension(X/5-15,200));
//        controlPanel.add(stopButton);
//
//        controlPanel.add(gasPanel);
//        startButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                carC.startEngines();
//            }
//        });
//
//        stopButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                carC.stopEngines();
//            }
//        });
//
//        gasButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                carC.gas(gasAmount);
//            }
//        });
//
//        brakeButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                carC.brake(gasAmount);
//            }
//        });
//
//        turboOnButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                carC.turboOn();
//            }
//        });
//
//
//        turboOffButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                carC.turboOff();
//            }
//        });
//
//        liftBedButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                carC.liftBed();
//
//            }
//        });
//
//        lowerBedButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                carC.lowerBed();
//            }
//        });
//
//
//    }
//
//    public
//
//}
