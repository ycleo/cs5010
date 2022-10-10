package problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testStockItem {

  private Product expectedProduct;
  private int expectedQuantity;
  private StockItem testStockItem;
  private StockItem testStockItem1;

  @BeforeEach
  void setUp() {
    expectedProduct = new Cheese("Cheese Fact", "Laugh Cow", 10.9, 10, 8.8);
    expectedQuantity = 5;
    testStockItem = new StockItem(expectedProduct, expectedQuantity);
  }

  @Test
  void getProduct() {
    assertEquals(expectedProduct, testStockItem.getProduct());
  }

  @Test
  void getQuantity() {
    assertEquals(expectedQuantity, testStockItem.getQuantity());
  }

  @Test
  void setQuantity() {
    expectedQuantity = 10;
    testStockItem.setQuantity(expectedQuantity);
    assertEquals(expectedQuantity, testStockItem.getQuantity());
  }

  @Test
  void quantityEnoughForPurchase_NotEnough() {
    assertFalse(testStockItem.quantityEnoughForPurchase(100));
  }

  @Test
  void quantityEnoughForPurchase_Enough() {
    assertTrue(testStockItem.quantityEnoughForPurchase(1));
  }

  @Test
  void equals_SameObject() {
    assertTrue(testStockItem.equals(testStockItem));
  }

  @Test
  void equals_NullObject() {
    assertFalse(testStockItem.equals(null));
  }

  @Test
  void equals_DifferentObject() {
    assertFalse(testStockItem.equals(expectedProduct));
  }

  @Test
  void equals_DifferentProduct() {
    Product otherProduct = new Shampoo("Clean Clean", "max", 12.2, 10, 9);
    testStockItem1 = new StockItem(otherProduct, expectedQuantity);
    assertFalse(testStockItem.equals(testStockItem1));
  }

  @Test
  void equals_DifferentQuantity() {
    testStockItem1 = new StockItem(expectedProduct, expectedQuantity);
    testStockItem1.setQuantity(99);
    assertFalse(testStockItem.equals(testStockItem1));
  }

  @Test
  void equals_SameStockItem() {
    testStockItem1 = new StockItem(expectedProduct, expectedQuantity);
    assertTrue(testStockItem.equals(testStockItem1));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(expectedProduct, expectedQuantity);
    assertEquals(expectedHashCode, testStockItem.hashCode());
  }

  @Test
  void testToString() {
    String expectedString =
        "StockItem{Product: " + expectedProduct.toString() + "; Quantity: " + expectedQuantity
            + '}';
    assertEquals(expectedString, testStockItem.toString());
  }

}
