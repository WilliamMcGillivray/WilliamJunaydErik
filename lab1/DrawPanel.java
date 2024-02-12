import java.awt.*;
import java.awt.image.BufferedImage;
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

    private Point saabPoint = new Point(0,0);
    private Point volvoPoint = new Point(0,CarController.getYDistanceBetweenCars());
    private Point scaniaPoint = new Point(0,2*CarController.getYDistanceBetweenCars());

    private final int sizeOfArray = 3;

    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300,400);

    private ArrayList<Image> images = new ArrayList<>(sizeOfArray);
    private ArrayList<Point> points = new ArrayList<>(sizeOfArray);

    public void addEveryPoint(Point... points){
        for (Point point: points){
            this.points.add(point);
        }
    }

    public void addEveryImage(Image... images){
        for (Image image: images){
            this.images.add(image);
        }
    }
    // To keep track of a single car's position


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
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            //volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));

            addEveryImage(scaniaImage, volvoImage, saabImage);
            addEveryPoint(scaniaPoint, volvoPoint, saabPoint);
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
//        g.drawImage(saabImage, saabPoint.x, saabPoint.y, null);
//        g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null);
//        g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y, null);
        for (int i = 0; i < sizeOfArray; i++) {
            g.drawImage(images.get(i), points.get(i).x, points.get(i).y, null);
        }


    }
}
