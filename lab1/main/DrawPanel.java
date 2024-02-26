package main;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;


// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{



    // Just a single image, TODO: Generalize
    private Image saabImage;
    private Image volvoImage;
    private Image scaniaImage;
    private Image volvoWorkshopImage;

    private Point volvoPoint = new Point(0,0);
    private Point saabPoint = new Point(0,160);
    private Point scaniaPoint = new Point(0,320);
    private Point volvoWorkshopPoint = new Point(300,0);

    private final int sizeOfArray = 10;


    private ArrayList<Image> images = new ArrayList<>(sizeOfArray);
    private ArrayList<Point> points = new ArrayList<>(sizeOfArray);

    public void addPoint(Point point){
        this.points.add(point);
    }

    public void addImage(Image image){
        this.images.add(image);
    }

    // TODO: Make this general for all cars
    void moveit(int index, int x, int y){
        this.points.set(index, new Point(x,y));
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.blue);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("main.VehicleGeneral.VehicleModels.Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.


            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("../pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("../pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("../pics/Scania.jpg"));
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("../pics/VolvoBrand.jpg"));

            //addEveryImage(volvoImage, saabImage, scaniaImage, volvoWorkshopImage);
            //addEveryPoint(volvoPoint, saabPoint, scaniaPoint, volvoWorkshopPoint);
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("brrrrrrroooooorrr");

//        if (points.size() > 0){
//            for (int i = 0; i < sizeOfArray; i++) {
//                g.drawImage(images.get(i), points.get(i).x, points.get(i).y, null);
//            }
//        }
    }

    public Image getSaabImage() {
        return saabImage;
    }

    public Image getVolvoImage() {
        return volvoImage;
    }

    public Image getScaniaImage() {
        return scaniaImage;
    }
}
