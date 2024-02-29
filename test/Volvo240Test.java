import main.model.VehicleModels.Volvo240;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Volvo240Test{

    Volvo240 volvo240;

    @BeforeEach
    public void setUp() throws Exception {
        volvo240 = new Volvo240();
    }
    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    public void testSpeedFactor() {
        assertEquals(volvo240.speedFactor(), 100 * 0.01 * 1.25);
    }
}