package problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCheese {

  private String expectedManufacturer;
  private String expectedName;

  private double expectedPrice;

  private int expectedMinAgeToBuy;

  private double expectedWeight;
  private double testWeight;
  private Cheese testCheese;
  private Cheese testCheese1;

  private String expectedString;

  @BeforeEach
  void setUp() {
    expectedManufacturer = "Cheese fact";
    expectedName = "swiss";
    expectedPrice = 60.8;
    expectedMinAgeToBuy = 21;
    expectedWeight = 11.2;

    testWeight = 99.6;
    testCheese = new Cheese(expectedManufacturer, expectedName, expectedPrice, expectedMinAgeToBuy,
        expectedWeight);
    testCheese1 = new Cheese(expectedManufacturer, expectedName, expectedPrice, expectedMinAgeToBuy,
        testWeight);
    expectedString = "Cheese{Manufacturer: Cheese fact; Product Name: swiss; Price: 60.8; Minimum Age To Buy: 21; Weight: 11.2}";
  }

  @Test
  void getWeight() {
    assertEquals(expectedWeight, testCheese.getWeight());
  }

  @Test
  void testEquals_NotCheeseInstance() {
    assertFalse(testCheese.equals(expectedName));
  }

  @Test
  void testEquals_NotPassSuperClassEquals() {
    assertFalse(testCheese.equals(testCheese1));
  }

  @Test
  void testEquals_SameCheese() {
    testCheese1 = new Cheese(expectedManufacturer, expectedName, expectedPrice, expectedMinAgeToBuy,
        expectedWeight);
    assertTrue(testCheese.equals(testCheese1));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(Objects.hash(
        Objects.hash(expectedManufacturer, expectedName, expectedPrice, expectedMinAgeToBuy),
        expectedWeight));
    assertEquals(expectedHashCode, testCheese.hashCode());
  }

  @Test
  void testToString() {
    assertEquals(expectedString, testCheese.toString());
  }
}