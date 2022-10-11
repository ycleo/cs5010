package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VehicleTest {

  private String expectedId;
  private Integer expectedManufactureYear;
  private MakeModel expectedMakeModel;
  private Double expectedMSRPrice;
  private Vehicle testVehicle;

  @BeforeEach
  void setUp() {
    expectedManufactureYear = Integer.valueOf("2022");
    expectedMakeModel = new MakeModel("Gold", "TeslaX");
    expectedMSRPrice = Double.valueOf("250000.0");
    testVehicle = new NewCar(Integer.valueOf("2022"), new MakeModel("Gold", "TeslaX"),
        Double.valueOf("250000.0"), Integer.valueOf("3000"));
    expectedId = testVehicle.getId();
  }

  @Test
  void getId() {
    assertEquals(expectedId, testVehicle.getId());
  }

  @Test
  void getManufactureYear() {
    assertEquals(expectedManufactureYear, Integer.valueOf("2022"));
  }

  @Test
  void getMakeModel() {
    assertTrue(expectedMakeModel.equals(new MakeModel("Gold", "TeslaX")));
  }

  @Test
  void getMSRPrice() {
    assertEquals(expectedMSRPrice, Double.valueOf("250000.0"));
  }
}
