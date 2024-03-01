package main.view;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.IOException;


// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{
//    private Image saabImage;
//    private Image volvoImage;
//    private Image scaniaImage;
//
    private Image volvoWorkshopImage;

    private Point volvoWorkshopPoint;

    private final int sizeOfArray = 10;

    //private ArrayList<Image> workshopImages = new ArrayList<>(sizeOfArray);
    private ArrayList<Image> images = new ArrayList<>(sizeOfArray);
    private ArrayList<Point> points = new ArrayList<>(sizeOfArray);

    public void addPoint(Point point){
        this.points.add(point);
    }

    public void removePoint(){
        this.points.remove(points.size()-1);
        System.out.println("size point " + points.size());
    }

    public void addImage(Image image){
        this.images.add(image);
    }

//    public void addWorkshopImage(Image image){
//        this.workshopImages.add(image);
//    }

    public void removeImage(){
        this.images.remove(images.size()-1);
        System.out.println("size image " + images.size());
    }

    public void addWorkshopPoint(Point point){volvoWorkshopPoint = point;}

    // TODO: Make this general for all cars
    public void moveit(int index, int x, int y){
        this.points.set(index, new Point(x,y));
        System.out.println("Max" + this.points.size());
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.blue);

        // Print an error message in case file is not found with a try/catch block
        try {
//            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("../../pics/Volvo240.jpg"));
//            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("../../pics/Saab95.jpg"));
//            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("../../pics/Scania.jpg"));
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("../../pics/VolvoBrand.jpg"));

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
        System.out.println("Points"+ points);
        if (points.size() > 0){
            for (int i = 0; i < points.size(); i++) {
                g.drawImage(images.get(i), points.get(i).x, points.get(i).y, null);
            }
        }
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
//        if (workshopImages.size() > 0){
//            for (Image image : workshopImages) {
//                g.drawImage(image, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
//            }
//        }
    }

//    public Image getSaabImage() {
//        return saabImage;
//    }
//
//    public Image getVolvoImage() {
//        return volvoImage;
//    }
//
//    public Image getScaniaImage() {
//        return scaniaImage;
//    }
//
//    public Image getVolvoWorkshopImage() {
//        return volvoWorkshopImage;
//    }
}
