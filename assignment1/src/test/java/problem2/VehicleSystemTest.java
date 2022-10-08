package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VehicleSystemTest {

  private Integer expectedInitialNewCarWithinFiftyMiles;
  private Integer expectedNewCarWithinFiftyMiles;

  @BeforeEach
  void setUp() {
    expectedInitialNewCarWithinFiftyMiles = Integer.valueOf("0");
    expectedNewCarWithinFiftyMiles = Integer.valueOf("20");
  }

  @Test
  void getNewCarWithinFiftyMiles() {
    Integer actualInitialVehicleNum = Integer.valueOf("0");
    assertEquals(expectedInitialNewCarWithinFiftyMiles, actualInitialVehicleNum);
  }

  @Test
  void setNewCarWithinFiftyMiles() {
    VehicleSystem.setNewCarWithinFiftyMiles(Integer.valueOf("20"));
    assertEquals(expectedNewCarWithinFiftyMiles, VehicleSystem.getNewCarWithinFiftyMiles());
  }
}
