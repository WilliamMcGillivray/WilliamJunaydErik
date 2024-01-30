import java.awt.*;

public class Scania extends Truck {
    
    private double flatbedAngle;

    public Scania() {
        super(2, Color.red, 300, "Scania");
        this.flatbedAngle = 0;
    }

    public void changeFlatbedAngle(int amount) {
        if (this.getCurrentSpeed() == 0 && amount <= 70 && amount >= 0) {
            flatbedAngle = amount;
        }
        else {throw new IllegalArgumentException("The angle has to be >=0 and <=70 degrees and speed = 0");
        }
    }

    @Override
    public void gas(double amount){
        if (this.flatbedAngle == 0) {
            super.gas(amount);
        }
        else {throw new IllegalArgumentException("Flatbed needs to be flat");
        }
    }

    @Override
    public void startEngine(){
        if (this.flatbedAngle == 0) {
            super.startEngine();

        }
        else {
            throw new IllegalArgumentException("Flatbed needs to be flat");
        }
    }


    @Override
    protected double speedFactor() {
        return 0.5;
    }

    public double getFlatbedAngle(){
        return this.flatbedAngle;
    }

}
