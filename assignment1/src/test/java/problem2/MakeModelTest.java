package problem2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problem1.Name;

public class MakeModelTest {

  private MakeModel testMakeModel;
  private String expectedMake;
  private String expectedModel;

  @BeforeEach
  void setUp() {
    expectedMake = "Gold";
    expectedModel = "TeslaX";
    testMakeModel = new MakeModel("Gold", "TeslaX");
  }

  @Test
  void getMake() {
    assertEquals(expectedMake, "Gold");
  }

  @Test
  void getModel() {
    assertEquals(expectedModel, "TeslaX");
  }

  @Test
  void equalsGetSameMakeModelObject() {
    assertTrue(testMakeModel.equals(testMakeModel));
  }

  @Test
  void equalsGetNullObject() {
    assertFalse(testMakeModel.equals(null));
  }

  @Test
  void equalsGetSameName() {
    MakeModel testMakeModel1 = new MakeModel("Gold", "TeslaX");
    assertTrue(testMakeModel.equals(testMakeModel1));
  }
}
