package main.view;

import main.model.Model;
import main.model.Observer;
import main.model.VehicleModels.Vehicle;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.IOException;


// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel implements Observer {

    private Image volvoWorkshopImage;

    private Point volvoWorkshopPoint;

    private final int sizeOfArray = 10;

    //private ArrayList<Image> workshopImages = new ArrayList<>(sizeOfArray);

    private Model model;


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, Model aModel) {
        model = aModel;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.blue);

        // Print an error message in case file is not found with a try/catch block
        try {
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("../../pics/VolvoBrand.jpg"));

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public void update(){
        this.repaint();
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (model.getVehicles().size() > 0){
            for (int i = 0; i < model.getVehicles().size(); i++) {
                Vehicle currentVehicle = (Vehicle) model.getVehicles().get(i);
                g.drawImage(currentVehicle.getImage(), currentVehicle.getLocation().x, currentVehicle.getLocation().y , null);
            }
        }
        g.drawImage(volvoWorkshopImage, model.getWorkshopPosition().x, model.getWorkshopPosition().y, null);

    }

}
