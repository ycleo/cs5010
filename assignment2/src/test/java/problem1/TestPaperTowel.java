package problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPaperTowel {

  private String expectedManufacturer;
  private String expectedName;

  private double expectedPrice;

  private int expectedMinAgeToBuy;

  private int expectedUnit;
  private int testUnit;
  private PaperTowel testPaperTowel;
  private PaperTowel testPaperTowel1;

  private String expectedString;

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
    expectedString = "PaperTowel{Manufacturer: Clean Clean; Product Name: max; Price: 12.2; Minimum Age To Buy: 10; Units Per Package: 9}";
  }

  @Test
  void getUnit() {
    assertEquals(expectedUnit, testPaperTowel.getUnit());
  }

  @Test
  void testEquals_NotPaperTowelInstance() {
    assertFalse(testPaperTowel.equals(expectedName));
  }

  @Test
  void testEquals_NotPassSuperClassEquals() {
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

  @Test
  void testToSTring() {
    assertEquals(expectedString, testPaperTowel.toString());
  }
}
