import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTransportTest {

    CarTransport carTransport;

    @BeforeEach
    void setUp() {
        carTransport = new CarTransport();
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
    }

    @Test
    void unloadCar() {
        Car first = carTransport.getCarList().peek();
        carTransport.unloadCar();
        Car second = carTransport.getCarList().peek();
        assertNotEquals(first, second);
    }
}