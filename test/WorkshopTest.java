import main.model.VehicleModels.Car;
import main.model.VehicleModels.Saab95;
import main.model.VehicleModels.Volvo240;
import main.model.Workshop;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkshopTest {

    Workshop<Car> theGarage;
    Workshop<Saab95> luigiGarage;
    Workshop<Volvo240> guidoGarage;
    Saab95 ChickHicks86 = new Saab95();
    Volvo240 McQueen95  = new Volvo240();
    Volvo240 DocHudson51 = new Volvo240();
    Volvo240 StripWeathers43  = new Volvo240();




    @BeforeEach
    void setUp() {
        theGarage = new Workshop<Car>(3);
        luigiGarage = new Workshop<Saab95>(2);
        guidoGarage = new Workshop<Volvo240>(2);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void acceptCar() {
        theGarage.acceptCar(ChickHicks86);
        theGarage.acceptCar(McQueen95);
        theGarage.acceptCar(DocHudson51);
        assertTrue(theGarage.getCarsInWorkshop().contains(DocHudson51));
        assertThrows(IllegalArgumentException.class, () -> theGarage.acceptCar(StripWeathers43));

        guidoGarage.acceptCar(StripWeathers43);
        assertTrue(guidoGarage.getCarsInWorkshop().contains(StripWeathers43));

        luigiGarage.acceptCar(ChickHicks86);
        assertTrue(luigiGarage.getCarsInWorkshop().contains(ChickHicks86));

        //guidoGarage.acceptCar(); //(Vet statiskt att bara main.VehicleGeneral.VehicleModels.Volvo240 kan acceptaras)
        //luigiGarage.acceptCar(); //(Vet statiskt att bara main.VehicleGeneral.VehicleModels.Saab95 kan acceptaras)
        //luigiGarage.acceptCar(McQueen95); //(Blir statiskt (compile time) fel då fel sorts bil lämnas in)
        //guidoGarage.acceptCar(ChickHicks86); //(Blir statiskt (compile time) fel då fel sorts bil lämnas in)

    }

    @Test
    void releaseCar() {
        theGarage.acceptCar(DocHudson51);
        theGarage.releaseCar();
        assertFalse(theGarage.getCarsInWorkshop().contains(DocHudson51));
        assertThrows(IllegalArgumentException.class, () -> theGarage.releaseCar());


        guidoGarage.acceptCar(StripWeathers43);
        guidoGarage.releaseCar();
        assertFalse(guidoGarage.getCarsInWorkshop().contains(StripWeathers43));
        assertThrows(IllegalArgumentException.class, () -> guidoGarage.releaseCar());

        luigiGarage.acceptCar(ChickHicks86);
        luigiGarage.releaseCar();
        assertFalse(luigiGarage.getCarsInWorkshop().contains(ChickHicks86));
        assertThrows(IllegalArgumentException.class, () -> luigiGarage.releaseCar());

        //guidoGarage.releaseCar(); //(Vet statiskt att bara main.VehicleGeneral.VehicleModels.Volvo240 kan acceptaras)
        //luigiGarage.releaseCar(); //(Vet statiskt att bara main.VehicleGeneral.VehicleModels.Saab95 kan acceptaras)


    }
}