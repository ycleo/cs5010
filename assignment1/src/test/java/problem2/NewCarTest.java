package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NewCarTest {

  private Integer expectedMileage;
  private Integer expectedNewCarWithinFiftyMiles;
  private Integer actualNewCarWithinFiftyMiles;
  private NewCar testNewCar;
  private NewCar testNewCarWithinFiftyMiles;
  private NewCar testNewCarAboveFiftyMiles;

  @BeforeEach
  void setUp() {
    expectedMileage = Integer.valueOf("95");
//    expectedNewCarWithinFiftyMiles = VehicleSystem.getNewCarWithinFiftyMiles();
    testNewCarAboveFiftyMiles = new NewCar(Integer.valueOf("2018"), new MakeModel("Gold", "TeslaX"),
        Double.valueOf("5000.0"), Integer.valueOf("85"));
    testNewCarWithinFiftyMiles = new NewCar(Integer.valueOf("2018"),
        new MakeModel("Gold", "TeslaX"),
        Double.valueOf("5000.0"), Integer.valueOf("30"));
    expectedNewCarWithinFiftyMiles = VehicleSystem.getNewCarWithinFiftyMiles();
  }

  @Test
  void constructorToIncrementNewCarWithinFiftyMiles() {
    testNewCar = new NewCar(Integer.valueOf("2018"), new MakeModel("Gold", "TeslaX"),
        Double.valueOf("5000.0"), Integer.valueOf("30"));
    actualNewCarWithinFiftyMiles = VehicleSystem.getNewCarWithinFiftyMiles();
    assertEquals(expectedNewCarWithinFiftyMiles + 1,
        actualNewCarWithinFiftyMiles.intValue());
  }

  @Test
  void setMileage() {
    testNewCarAboveFiftyMiles.setMileage(Integer.valueOf("95"));
    assertEquals(expectedMileage, testNewCarAboveFiftyMiles.getMileage());
  }

  @Test
  void setMileageToIncrementNewCarWithinFiftyMiles() {
    testNewCarAboveFiftyMiles.setMileage(Integer.valueOf("50"));
    actualNewCarWithinFiftyMiles = VehicleSystem.getNewCarWithinFiftyMiles();
    assertEquals(expectedNewCarWithinFiftyMiles + 1,
        actualNewCarWithinFiftyMiles.intValue());
  }

  @Test
  void setMileageToDecrementNewCarWithinFiftyMiles() {
    testNewCarWithinFiftyMiles.setMileage(Integer.valueOf("51"));
    actualNewCarWithinFiftyMiles = VehicleSystem.getNewCarWithinFiftyMiles();
    assertEquals(expectedNewCarWithinFiftyMiles - 1,
        actualNewCarWithinFiftyMiles.intValue());
  }

  @AfterEach
  void afterEachTest() {
    VehicleSystem.setNewCarWithinFiftyMiles(Integer.valueOf("0"));
  }

}
