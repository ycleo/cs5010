package problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestShampoo {
  private String expectedManufacturer;
  private String expectedName;

  private double expectedPrice;

  private int expectedMinAgeToBuy;

  private int expectedUnit;
  private int testUnit;
  private Shampoo testShampoo;
  private Shampoo testShampoo1;

  private String expectedString;

  @BeforeEach
  void setUp() {
    expectedManufacturer = "Clean Clean";
    expectedName = "max";
    expectedPrice = 12.2;
    expectedMinAgeToBuy = 10;
    expectedUnit = 9;

    testUnit = 20;
    testShampoo = new Shampoo(expectedManufacturer, expectedName, expectedPrice, expectedMinAgeToBuy, expectedUnit);
    testShampoo1 = new Shampoo(expectedManufacturer, expectedName, expectedPrice, expectedMinAgeToBuy, testUnit);
    expectedString = "Shampoo{Manufacturer: Clean Clean; Product Name: max; Price: 12.2; Minimum Age To Buy: 10; Units Per Package: 9}";
  }

  @Test
  void getUnit() {
    assertEquals(expectedUnit, testShampoo.getUnit());
  }

  @Test
  void testEquals_NotShampooInstance() {
    assertFalse(testShampoo.equals(expectedName));
  }

  @Test
  void testEquals_NotPassSuperClassEquals() {
    assertFalse(testShampoo.equals(testShampoo1));
  }
  @Test
  void testEquals_SameShampoo() {
    testShampoo1 = new Shampoo(expectedManufacturer, expectedName, expectedPrice, expectedMinAgeToBuy, expectedUnit);
    assertTrue(testShampoo.equals(testShampoo1));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(Objects.hash(Objects.hash(expectedManufacturer, expectedName, expectedPrice, expectedMinAgeToBuy), expectedUnit));
    assertEquals(expectedHashCode, testShampoo.hashCode());
  }

  @Test
  void testToSTring() {
    assertEquals(expectedString, testShampoo.toString());
  }
}
