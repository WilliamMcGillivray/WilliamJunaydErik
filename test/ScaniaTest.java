import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {

    Scania scania;

    @BeforeEach
    void setUp() {
        scania = new Scania();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testChangeFlatbedAngle() {
        scania.changeFlatbedAngle(50);
        assertEquals(scania.getFlatbedAngle(), 50);

        scania.changeFlatbedAngle(0);
        scania.gas(1);
        assertThrows(IllegalArgumentException.class, () -> scania.changeFlatbedAngle(1));
    }

    @Test
    void testGas() {
        scania.gas(1);
        assertEquals(scania.getCurrentSpeed(), 0.5);

        scania.brake(1);
        scania.changeFlatbedAngle(5);
        assertThrows(IllegalArgumentException.class, () -> scania.gas(1));
    }

    @Test
    void testStartEngine() {
        scania.startEngine();
        assertEquals(scania.getCurrentSpeed(), 0.1);
    }

    @Test
    void testSpeedFactor() {
        assertEquals(scania.speedFactor(), 0.5);
    }

    @Test
    void testGetFlatbedAngle() {
        scania.changeFlatbedAngle(50);
        assertEquals(scania.getFlatbedAngle(), 50);
    }
}