package problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;

public class TestReceipt {

  private double expectedTotalPricePaid;
  private List<Product> expectedProductsReceived;
  private List<Product> expectedProductsRemovedWithoutSubstitution;
  private List<Product> expectedProductsRemovedDueToAge;
  private Product testProduct;
  private Receipt testReceipt;
  private Receipt testReceipt1;

  @BeforeEach
  void setUp() {
    expectedTotalPricePaid = 0.0;
    expectedProductsReceived = new ArrayList<>();
    expectedProductsRemovedWithoutSubstitution = new ArrayList<>();
    expectedProductsRemovedDueToAge = new ArrayList<>();
    testProduct = new Cheese("Cheese Fact", "Laugh Cow", 10.9, 10, 8.8);
    testReceipt = new Receipt();
    testReceipt1 = new Receipt();
  }

  @Test
  void getTotalPricePaid() {
    assertEquals(expectedTotalPricePaid, testReceipt.getTotalPricePaid());
  }

  @Test
  void setTotalPricePaid() {
    testReceipt.setTotalPricePaid(100.0);
    expectedTotalPricePaid = 100.0;
    assertEquals(expectedTotalPricePaid, testReceipt.getTotalPricePaid());
  }

  @Test
  void getProductsReceived() {
    assertEquals(expectedProductsReceived, testReceipt.getProductsReceived());
  }

  @Test
  void getProductsRemovedWithoutSubstitution() {
    assertEquals(expectedProductsRemovedWithoutSubstitution,
        testReceipt.getProductsRemovedWithoutSubstitution());
  }

  @Test
  void getProductsRemovedDueToAge() {
    assertEquals(expectedProductsRemovedDueToAge, testReceipt.getProductsRemovedDueToAge());
  }

  @Test
  void equals_SameObject() {
    assertTrue(testReceipt.equals(testReceipt));
  }

  @Test
  void equals_NullObject() {
    assertFalse(testReceipt.equals(null));
  }

  @Test
  void equals_DifferentObject() {
    assertFalse(testReceipt.equals(expectedProductsReceived));
  }

  @Test
  void equals_DifferentTotalPricePaid() {
    testReceipt1.setTotalPricePaid(20.0);
    assertFalse(testReceipt.equals(testReceipt1));
  }

  @Test
  void equals_DifferentProductsReceived() {
    testReceipt1.getProductsReceived().add(testProduct);
    assertFalse(testReceipt.equals(testReceipt1));
  }

  @Test
  void equals_DifferentProductsRemovedWithoutSubstitution() {
    testReceipt1.getProductsRemovedWithoutSubstitution().add(testProduct);
    assertFalse(testReceipt.equals(testReceipt1));
  }

  @Test
  void equals_DifferentProductsRemovedDueToAge() {
    testReceipt1.getProductsRemovedDueToAge().add(testProduct);
    assertFalse(testReceipt.equals(testReceipt1));
  }

  @Test
  void equals_SameReceipt() {
    assertTrue(testReceipt.equals(testReceipt1));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(expectedTotalPricePaid, expectedProductsReceived,
        expectedProductsRemovedWithoutSubstitution, expectedProductsRemovedDueToAge);
    assertEquals(expectedHashCode, testReceipt.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "Receipt{Total Price Paid: " + expectedTotalPricePaid +
        "; Received Products List: " + expectedProductsReceived.toString() +
        "; Out of Stock Without Substitution Products List: "
        + expectedProductsRemovedWithoutSubstitution.toString() +
        "; Removed Due To Age Products List: " + expectedProductsRemovedDueToAge.toString() +
        '}';
    assertEquals(expectedString, testReceipt.toString());
  }
}
