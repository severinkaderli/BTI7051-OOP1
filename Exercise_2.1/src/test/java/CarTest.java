import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    public void testGasLevel() {
        Car car = new Car(10);
        assertEquals(0, car.getGasLevel());
        car.fillUpTank(30);
        assertEquals(30, car.getGasLevel());
        car.drive(200);
        assertEquals(10, car.getGasLevel());
    }
}