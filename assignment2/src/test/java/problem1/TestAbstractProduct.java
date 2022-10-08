package problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestAbstractProduct {
  private String expectedManufacturer;
  private String testManufacturer;
  private String expectedName;
  private String testName;
  private double expectedPrice;
  private double testPrice;
  private int expectedMinAgeToBuy;
  private int testMinAgeToBuy;
  private double expectedWeight;
  private AbstractProduct testProduct;
  private AbstractProduct testProduct1;

  @BeforeEach
  void setUp() {
    expectedManufacturer = "number one salmon";
    expectedName = "on my salmon";
    expectedPrice = 3000.99;
    expectedMinAgeToBuy = 15;
    expectedWeight = 90.5;
    testProduct = new Salmon(expectedManufacturer, expectedName, expectedPrice, expectedMinAgeToBuy, expectedWeight);

    testManufacturer = "cool salmon";
    testName = "proud salmon";
    testPrice = 150.2;
    testMinAgeToBuy = 2;
  }

  @Test
  void getManufacturer() {
    assertEquals(expectedManufacturer, testProduct.getManufacturer());
  }

  @Test
  void getName() {
    assertEquals(expectedName, testProduct.getName());
  }

  @Test
  void getPrice() {
    assertEquals(expectedPrice, testProduct.getPrice());
  }

  @Test
  void getMinAgeToBuy() {
    assertEquals(expectedMinAgeToBuy, testProduct.getMinAgeToBuy());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testProduct.equals(testProduct));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testProduct.equals(null));
  }

  @Test
  void testEquals_DifferentObject() {
    assertFalse(testProduct.equals(expectedManufacturer));
  }

  @Test
  void testEquals_DifferentManufacturer() {
    testProduct1 = new Salmon(testManufacturer, expectedName, expectedPrice, expectedMinAgeToBuy, expectedWeight);
    assertFalse(testProduct.equals(testProduct1));
  }

  @Test
  void testEquals_DifferentName() {
    testProduct1 = new Salmon(expectedManufacturer, testName, expectedPrice, expectedMinAgeToBuy, expectedWeight);
    assertFalse(testProduct.equals(testProduct1));
  }

  @Test
  void testEquals_DifferentPrice() {
    testProduct1 = new Salmon(expectedManufacturer, expectedName, testPrice, expectedMinAgeToBuy, expectedWeight);
    assertFalse(testProduct.equals(testProduct1));
  }
  @Test
  void testEquals_DifferentMinAgeToBuy() {
    testProduct1 = new Salmon(expectedManufacturer, expectedName, expectedPrice, testMinAgeToBuy, expectedWeight);
    assertFalse(testProduct.equals(testProduct1));
  }
  @Test
  void testEquals_SameProduct() {
    testProduct1 = new Salmon(expectedManufacturer, expectedName, expectedPrice, expectedMinAgeToBuy, expectedWeight);
    assertTrue(testProduct.equals(testProduct1));
  }

//  @Test
//  void testHashCode() {
//    int expectedHashCode = Objects.hash(expectedManufacturer, expectedName, expectedPrice, expectedMinAgeToBuy);
//    assertEquals(expectedHashCode, (AbstractProduct)testProduct.hashCode());
//  }

//  @Test
//  void testToString() {
//    String expectedString = "Product{Manufacturer: number one salmon; Product Name: oh my salmon; Price: 3000.99; Minimum Age To Buy: 15}";
//    assertEquals(expectedString, testProduct.toString());
//  }
}
