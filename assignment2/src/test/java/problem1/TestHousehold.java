package problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestHousehold {

  private String expectedManufacturer;
  private String expectedName;

  private double expectedPrice;

  private int expectedMinAgeToBuy;

  private int expectedUnit;
  private int testUnit;
  private Household testPaperTowel;
  private Household testPaperTowel1;


  @BeforeEach
  void setUp() {
    expectedManufacturer = "Clean Clean";
    expectedName = "max";
    expectedPrice = 12.2;
    expectedMinAgeToBuy = 10;
    expectedUnit = 9;

    testUnit = 20;
    testPaperTowel = new PaperTowel(expectedManufacturer, expectedName, expectedPrice,
        expectedMinAgeToBuy, expectedUnit);
    testPaperTowel1 = new PaperTowel(expectedManufacturer, expectedName, expectedPrice,
        expectedMinAgeToBuy, testUnit);
  }

  @Test
  void getUnit() {
    assertEquals(expectedUnit, testPaperTowel.getUnit());
  }

  @Test
  void testEquals_NotHouseholdInstance() {
    assertFalse(testPaperTowel.equals(expectedName));
  }

  @Test
  void testEquals_NotPassSuperClassEquals() {
    testPaperTowel1 = new PaperTowel("Very Very Comfy", expectedName, expectedPrice,
        expectedMinAgeToBuy, expectedUnit);
    assertFalse(testPaperTowel.equals(testPaperTowel1));
  }

  @Test
  void tesEquals_DifferentUnits() {
    assertFalse(testPaperTowel.equals(testPaperTowel1));
  }

  @Test
  void testEquals_SamePaperTowel() {
    testPaperTowel1 = new PaperTowel(expectedManufacturer, expectedName, expectedPrice,
        expectedMinAgeToBuy, expectedUnit);
    assertTrue(testPaperTowel.equals(testPaperTowel1));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(Objects.hash(
        Objects.hash(expectedManufacturer, expectedName, expectedPrice, expectedMinAgeToBuy),
        expectedUnit));
    assertEquals(expectedHashCode, testPaperTowel.hashCode());
  }
}
