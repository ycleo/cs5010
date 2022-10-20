package problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSalmon {

  private String expectedManufacturer;
  private String expectedName;

  private double expectedPrice;

  private int expectedMinAgeToBuy;

  private double expectedWeight;
  private double testWeight;
  private Salmon testSalmon;
  private Salmon testSalmon1;

  private String expectedString;

  @BeforeEach
  void setUp() {
    expectedManufacturer = "number one salmon";
    expectedName = "oh my salmon";
    expectedPrice = 3000.99;
    expectedMinAgeToBuy = 15;
    expectedWeight = 90.5;

    testWeight = 70.6;
    testSalmon = new Salmon(expectedManufacturer, expectedName, expectedPrice, expectedMinAgeToBuy,
        expectedWeight);
    testSalmon1 = new Salmon(expectedManufacturer, expectedName, expectedPrice, expectedMinAgeToBuy,
        testWeight);
    expectedString = "Salmon{Manufacturer: number one salmon; Product Name: oh my salmon; Price: 3000.99; Minimum Age To Buy: 15; Weight: 90.5}";
  }

  @Test
  void getWeight() {
    assertEquals(expectedWeight, testSalmon.getWeight());
  }

  @Test
  void testEquals_NotSalmonInstance() {
    assertFalse(testSalmon.equals(expectedName));
  }

  @Test
  void testEquals_NotPassSuperClassEquals() {
    assertFalse(testSalmon.equals(testSalmon1));
  }

  @Test
  void testEquals_SameSalmon() {
    testSalmon1 = new Salmon(expectedManufacturer, expectedName, expectedPrice, expectedMinAgeToBuy,
        expectedWeight);
    assertTrue(testSalmon.equals(testSalmon1));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(Objects.hash(
        Objects.hash(expectedManufacturer, expectedName, expectedPrice, expectedMinAgeToBuy),
        expectedWeight));
    assertEquals(expectedHashCode, testSalmon.hashCode());
  }

  @Test
  void testToString() {
    assertEquals(expectedString, testSalmon.toString());
  }
}