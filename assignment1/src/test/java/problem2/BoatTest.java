package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BoatTest {

  private Float expectedLength;
  private Integer expectedNumPassenger;
  private PropulsionType expectedPropulsionType;
  private Boat testBoat;

  @BeforeEach
  void setUp() {
    expectedLength = Float.valueOf("8.65f");
    expectedNumPassenger = Integer.valueOf("6");
    expectedPropulsionType = PropulsionType.SAIL_POWER;
    testBoat = new Boat(Integer.valueOf("2018"), new MakeModel("Gold", "TeslaX"),
        Double.valueOf("5000.0"), Float.valueOf("8.65f"), Integer.valueOf("6"),
        PropulsionType.SAIL_POWER);
  }

  @Test
  void getLength() {
    assertEquals(expectedLength, testBoat.getLength());
  }

  @Test
  void getNumPassenger() {
    assertEquals(expectedNumPassenger, testBoat.getNumPassenger());
  }

  @Test
  void getPropulsionType() {
    assertEquals(expectedPropulsionType, testBoat.getPropulsionType());
  }

}
