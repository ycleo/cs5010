package problem1;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestShoppingCart {

  private Map<Product, Integer> expectedShoppingItems;
  private double expectedTotalCost;
  private int expectedQuantity;
  private Product expectedProduct;
  private ShoppingCart testShoppingCart;
  private ShoppingCart testShoppingCart1;

  @BeforeEach
  void setUp() {
    expectedShoppingItems = new HashMap<>();
    expectedTotalCost = 109.0;
    expectedQuantity = 10;
    expectedProduct = new Cheese("Cheese Fact", "Laugh Cow", 10.9, 10, 8.8);

    testShoppingCart = new ShoppingCart();
    testShoppingCart1 = new ShoppingCart();

    expectedShoppingItems.put(expectedProduct, expectedQuantity);
    testShoppingCart.addItem(expectedProduct, expectedQuantity);
  }

  @Test
  void getShoppingItems() {
    assertEquals(expectedShoppingItems, testShoppingCart.getShoppingItems());
  }

  @Test
  void addItem() {
    assertEquals(expectedShoppingItems, testShoppingCart.getShoppingItems());
  }

  @Test
  void removeItem() {
    expectedShoppingItems.remove(expectedProduct);
    testShoppingCart.removeItem(expectedProduct);
    assertEquals(expectedShoppingItems, testShoppingCart.getShoppingItems());
  }

  @Test
  void clearShoppingCart() {
    expectedShoppingItems.clear();
    testShoppingCart.clearShoppingCart();
    assertEquals(expectedShoppingItems, testShoppingCart.getShoppingItems());
  }

  @Test
  void totalCost() {
    assertEquals(expectedTotalCost, testShoppingCart.totalCost());
  }

  @Test
  void equals_SameObject() {
    assertTrue(testShoppingCart.equals(testShoppingCart));
  }

  @Test
  void equals_NullObject() {
    assertFalse(testShoppingCart.equals(null));
  }

  @Test
  void equals_DifferentObject() {
    assertFalse(testShoppingCart.equals(expectedProduct));
  }

  @Test
  void equals_DifferentShoppingItems() {
    assertFalse(testShoppingCart.equals(testShoppingCart1));
  }

  @Test
  void equals_SameShoppingCart() {
    testShoppingCart1.addItem(expectedProduct, expectedQuantity);
    assertTrue(testShoppingCart.equals(testShoppingCart1));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(expectedShoppingItems);
    assertEquals(expectedHashCode, testShoppingCart.hashCode());
  }

  @Test
  void testToString() {
    String expectedString =
        "ShoppingCart{Shopping Items: " + expectedShoppingItems.toString() + '}';
    assertEquals(expectedString, testShoppingCart.toString());
  }
}
