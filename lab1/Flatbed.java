public class Flatbed {
    private double flatbedAngle = 0.0;

    public void changeFlatbedAngle(Truck trucker, double angle) {
        if (trucker.getCurrentSpeed() == 0 && angle <= 70 && angle >= 0) {
            flatbedAngle = angle;
        }
        else {throw new IllegalArgumentException("The angle has to be >=0 and <=70 degrees and speed = 0");
        }
    }

    public void changeFlatbedAngle(Truck trucker, String changeTo) {
        if (trucker.getCurrentSpeed() == 0) {
            if (changeTo == "Up") {

            }

        }
    }
}
