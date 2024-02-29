import main.model.VehicleModels.Saab95;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Saab95Test {
    Saab95 saab95;

    @BeforeEach
    public void setUp() throws Exception {
        saab95 = new Saab95();
    }
    @AfterEach
    public void tearDown() throws Exception {
    }
    @Test
    public void testSetTurboOn() {
        saab95.setTurboOn();
        assertTrue(saab95.getTurboOn());
    }
    @Test
    public void testSetTurboOff() {
        saab95.setTurboOff();
        assertFalse(saab95.getTurboOn());
    }
    @Test
    public void testSpeedFactor() {
        saab95.setTurboOn();
        assertEquals(saab95.speedFactor(), 125.0 * 0.01 * 1.3);
        saab95.setTurboOff();
        assertEquals(saab95.speedFactor(), 125.0 * 0.01);
    }
}