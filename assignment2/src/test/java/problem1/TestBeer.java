package problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestBeer {

  private String expectedManufacturer;
  private String expectedName;

  private double expectedPrice;

  private int expectedMinAgeToBuy;

  private double expectedWeight;
  private double testWeight;
  private Beer testBeer;
  private Beer testBeer1;

  private String expectedString;

  @BeforeEach
  void setUp() {
    expectedManufacturer = "Johnny Walker";
    expectedName = "Green";
    expectedPrice = 60.8;
    expectedMinAgeToBuy = 21;
    expectedWeight = 21.2;

    testWeight = 99.6;
    testBeer = new Beer(expectedManufacturer, expectedName, expectedPrice, expectedMinAgeToBuy,
        expectedWeight);
    testBeer1 = new Beer(expectedManufacturer, expectedName, expectedPrice, expectedMinAgeToBuy,
        testWeight);
    expectedString = "Beer{Manufacturer: Johnny Walker; Product Name: Green; Price: 60.8; Minimum Age To Buy: 21; Weight: 21.2}";
  }

  @Test
  void getWeight() {
    assertEquals(expectedWeight, testBeer.getWeight());
  }

  @Test
  void testEquals_NotBeerInstance() {
    assertFalse(testBeer.equals(expectedName));
  }

  @Test
  void testEquals_NotPassSuperClassEquals() {
    assertFalse(testBeer.equals(testBeer1));
  }

  @Test
  void testEquals_SameBeer() {
    testBeer1 = new Beer(expectedManufacturer, expectedName, expectedPrice, expectedMinAgeToBuy,
        expectedWeight);
    assertTrue(testBeer.equals(testBeer1));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(Objects.hash(
        Objects.hash(expectedManufacturer, expectedName, expectedPrice, expectedMinAgeToBuy),
        expectedWeight));
    assertEquals(expectedHashCode, testBeer.hashCode());
  }

  @Test
  void testToSTring() {
    assertEquals(expectedString, testBeer.toString());
  }
}
