package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {

  private Integer expectedMileage;
  private Car testCar;

  @BeforeEach
  void setUp() {
    expectedMileage = Integer.valueOf("100");
    testCar = new NewCar(Integer.valueOf("2020"), new MakeModel("Gold", "TeslaX"),
        Double.valueOf("80000"), Integer.valueOf("100"));
  }

  @Test
  void getMileage() {
    assertEquals(expectedMileage, Integer.valueOf("100"));
  }

  @Test
  void setMileage() {
    testCar.setMileage(Integer.valueOf("9000"));
    assertEquals(testCar.getMileage(), Integer.valueOf("9000"));
  }
}
