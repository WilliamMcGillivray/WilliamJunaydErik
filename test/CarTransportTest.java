import main.model.VehicleModels.Car;
import main.model.VehicleModels.CarTransport;
import main.model.VehicleModels.Saab95;
import main.model.VehicleModels.Volvo240;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTransportTest {

    CarTransport<Car> carTransport;
    CarTransport<Saab95> secondCarTransport;

    @BeforeEach
    void setUp() {
        carTransport = new CarTransport<Car>();
        carTransport.lowerRamp();
        Saab95 ChickHicks86 = new Saab95();
        Volvo240 McQueen95  = new Volvo240();
        carTransport.loadCar(ChickHicks86);
        carTransport.loadCar(McQueen95);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void speedFactor() {
        assertEquals(carTransport.speedFactor(), 0.5);
    }

    @Test
    void raiseRamp() {
        carTransport.raiseRamp();
        assertTrue(carTransport.getRampPosition());
    }

    @Test
    void lowerRamp() {
        carTransport.lowerRamp();
        assertFalse(carTransport.getRampPosition());
    }

    @Test
    void getRampPosition() {
        carTransport.raiseRamp();
        assertTrue(carTransport.getRampPosition());
    }

    @Test
    void loadCar() {
        Volvo240 StripWeathers43  = new Volvo240();
        carTransport.loadCar(StripWeathers43);
        assertEquals(carTransport.getCarList().peek(), StripWeathers43);

        assertEquals(StripWeathers43.getLocation(), carTransport.getLocation());
    }

    @Test
    void unloadCar() {
        Car first = carTransport.getCarList().peek();
        carTransport.unloadCar();
        Car second = carTransport.getCarList().peek();
        assertNotEquals(first, second);
    }

    @Test
    void gas() {
        carTransport.raiseRamp();
        carTransport.gas(1);
    }
}