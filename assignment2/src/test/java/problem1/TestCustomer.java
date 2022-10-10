package problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Objects;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCustomer {

  private final PrintStream standardOut = System.out;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
  private static final int DEFAULT_ADD_PRODUCT_QUANTITY = 1;
  private String expectedName;
  private int expectedAge;
  private ShoppingCart expectedShoppingCart;
  private Customer testCustomer;
  private Customer testCustomer1;
  private int testPurchaseQuantity;
  private int testPurchaseQuantity1;

  private Product expectedProduct;
  private int expectedStockQuantity;
  private StockItem expectedStockItem;
  private Inventory expectedInventory;
  private String expectedWarning;

  private Receipt expectedReceipt;

  @BeforeEach
  void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
    expectedName = "Peter Parker";
    expectedAge = 23;

    testCustomer = new Customer(expectedName, expectedAge);
    testCustomer1 = new Customer(expectedName, expectedAge);
    testPurchaseQuantity = 10;

    expectedProduct = new Cheese("Cheese Fact", "Laugh Cow", 10.9, 10, 8.8);
    expectedShoppingCart = new ShoppingCart();
    expectedShoppingCart.addItem(expectedProduct, testPurchaseQuantity);

    expectedStockQuantity = 30;
    expectedStockItem = new StockItem(expectedProduct, expectedStockQuantity);
    expectedInventory = new Inventory();
    expectedInventory.addStockItem(expectedStockItem);
    expectedWarning = "Warning: The product is out of stock.";
    expectedReceipt = new Receipt();
    expectedReceipt.setTotalPricePaid(expectedProduct.getPrice() * testPurchaseQuantity);
    expectedReceipt.getProductsReceived().add(expectedProduct);
  }

  @Test
  void getName() {
    assertEquals(expectedName, testCustomer.getName());
  }

  @Test
  void getAge() {
    assertEquals(expectedAge, testCustomer.getAge());
  }

  @Test
  void getShoppingCart() {
    testCustomer.addProduct(expectedInventory, expectedStockItem, testPurchaseQuantity);
    assertEquals(expectedShoppingCart, testCustomer.getShoppingCart());
  }

  @Test
  void addProduct_OverStockQuantity() {
    testPurchaseQuantity = 100;
    testCustomer.addProduct(expectedInventory, expectedStockItem, testPurchaseQuantity);
    assertEquals(expectedWarning, outputStreamCaptor.toString().trim());
  }

  @Test
  void addProduct_ValidQuantity() {
    testCustomer.addProduct(expectedInventory, expectedStockItem, testPurchaseQuantity);
    assertEquals(expectedShoppingCart, testCustomer.getShoppingCart());
  }

  @Test
  void addProduct_WithoutGivenQuantity() {
    expectedShoppingCart = new ShoppingCart();
    expectedShoppingCart.addItem(expectedProduct, DEFAULT_ADD_PRODUCT_QUANTITY);

    testCustomer.addProduct(expectedInventory, expectedStockItem);
    assertEquals(expectedShoppingCart, testCustomer.getShoppingCart());
  }

  @Test
  void submitShoppingCart() {
    testCustomer.addProduct(expectedInventory, expectedStockItem, testPurchaseQuantity);
    assertEquals(expectedReceipt, testCustomer.submitShoppingCart(expectedInventory));
  }

  @Test
  void equals_SameObject() {
    assertTrue(testCustomer.equals(testCustomer));
  }

  @Test
  void equals_NullObject() {
    assertFalse(testCustomer.equals(null));
  }

  @Test
  void equals_DifferentObject() {
    assertFalse(testCustomer.equals(testPurchaseQuantity));
  }

  @Test
  void equals_DifferentName() {
    testCustomer1 = new Customer("Jason", expectedAge);
    assertFalse(testCustomer.equals(testCustomer1));
  }

  @Test
  void equals_DifferentAge() {
    testCustomer1 = new Customer(expectedName, 100);
    assertFalse(testCustomer.equals(testCustomer1));
  }

  @Test
  void equals_DifferentShoppingCart() {
    testCustomer.addProduct(expectedInventory, expectedStockItem, testPurchaseQuantity);
    assertFalse(testCustomer.equals(testCustomer1));
  }

  @Test
  void equals_SameCustomer() {
    assertTrue(testCustomer.equals(testCustomer1));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(testCustomer.getName(), testCustomer.getAge(),
        testCustomer.getShoppingCart());
    assertEquals(expectedHashCode, testCustomer.hashCode());
  }

  @Test
  void testToString() {
    String expectedString =
        "Customer{Name: Peter Parker; Age: 23; Shopping Cart: " + testCustomer.getShoppingCart()
            .toString() + "}";
    assertEquals(expectedString, testCustomer.toString());
  }

  @AfterEach
  void close() {
    System.setOut(standardOut);
  }

}
