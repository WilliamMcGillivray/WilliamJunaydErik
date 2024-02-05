import java.awt.*;

public class Scania extends Truck {
    
    private double flatbedAngle;

    public Scania() {
        super(2, Color.red, 300, "Scania");
        this.flatbedAngle = 0;
    }
    @Override
    public boolean checkFlatbed() {
        return flatbedAngle == 0.0;
    }
    public void changeFlatbedAngle(int amount) {
        if (checkSpeedIsZero() && amount <= 70 && amount >= 0) {
            flatbedAngle = amount;
        }
        else {throw new IllegalArgumentException("The angle has to be >=0 and <=70 degrees and speed = 0");
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
