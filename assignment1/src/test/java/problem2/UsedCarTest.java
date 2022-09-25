package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsedCarTest {

  private Integer expectedNumPrevOwner;
  private Integer expectedNumMinorAccident;
  private UsedCar testUsedCar;
  private UsedCar testUsedCar1;

  @BeforeEach
  void setUp() {
    expectedNumPrevOwner = Integer.valueOf("3");
    expectedNumMinorAccident = Integer.valueOf("5");
    testUsedCar = new UsedCar(Integer.valueOf("2018"), new MakeModel("Gold", "TeslaX"),
        Double.valueOf("5000.0"), Integer.valueOf("1000"), Integer.valueOf("3"),
        Integer.valueOf("5"));
  }

  @Test
  void getNumPrevOwner() {
    assertTrue(expectedNumPrevOwner.equals(testUsedCar.getNumPrevOwner()));
  }

  @Test
  void getNumMinorAccident() {
    assertTrue(expectedNumMinorAccident.equals(testUsedCar.getNumMinorAccident()));
  }

  @Test
  void setNumPrevOwner() {
    testUsedCar.setNumPrevOwner(Integer.valueOf("6"));
    assertEquals(Integer.valueOf("6"), testUsedCar.getNumPrevOwner());
  }

  @Test
  void setNumMinorAccident() {
    testUsedCar.setNumMinorAccident(Integer.valueOf("0"));
    assertEquals(Integer.valueOf("0"), testUsedCar.getNumMinorAccident());
  }

}
