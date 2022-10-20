package problem1;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestInventory {

  private List<StockItem> expectedGroceries;
  private List<StockItem> expectedHousehold;
  private Grocery testGrocery;
  private Grocery testGrocery1;
  private Household testHousehold;
  private Household testHousehold1;
  private StockItem expectedStockGroceryItem;
  private StockItem expectedStockHouseholdItem;
  private double expectedTotalRetailValue;
  private Inventory testInventory;
  private Inventory testInventory1;
  private ShoppingCart testShoppingCart;
  private Receipt testReceipt;
  private Receipt expectedReceipt;

  private Customer testCustomer;

  @BeforeEach
  void setUp() {
    expectedGroceries = new ArrayList<>();
    expectedHousehold = new ArrayList<>();

    testGrocery = new Cheese("Cheese Fact", "Laugh Cow", 10.9, 10, 8.8);
    testGrocery1 = new Cheese("Fact Cheese", "Cool", 10.9, 10, 8.8);
    testHousehold = new Shampoo("Clean Clean", "max", 12.2, 10, 9);
    testHousehold1 = new Shampoo("No Dirty", "max clean", 12.2, 10, 9);

    testInventory = new Inventory();
    testInventory1 = new Inventory();
    testShoppingCart = new ShoppingCart();
    testReceipt = new Receipt();

    expectedStockGroceryItem = new StockItem(testGrocery, 1);
    expectedStockHouseholdItem = new StockItem(testHousehold, 1);
    expectedReceipt = new Receipt();

    testCustomer = new Customer("Peter Parker", 23);
  }

  @Test
  void addStockItem_Grocery() {
    testInventory.addStockItem(expectedStockGroceryItem);
    assertEquals(expectedStockGroceryItem, testInventory.getStockItem(testGrocery));
  }

  @Test
  void addStockItem_Household() {
    testInventory.addStockItem(expectedStockHouseholdItem);
    assertEquals(expectedStockHouseholdItem, testInventory.getStockItem(testHousehold));
  }

  @Test
  void getTotalRetailValue() {
    expectedTotalRetailValue = testGrocery.getPrice() + testHousehold.getPrice();
    testInventory.addStockItem(expectedStockGroceryItem);
    testInventory.addStockItem(expectedStockHouseholdItem);
    assertEquals(expectedTotalRetailValue, testInventory.getTotalRetailValue());
  }

  @Test
  void getStockItem_ProductNotExists() {
    StockItem expectedStockItem = new StockItem(null, 0);
    testGrocery = new Salmon("good salmon", "happy", 1.2, 12, 99.02);
    assertEquals(expectedStockItem, testInventory.getStockItem(testGrocery));
  }

  @Test
  void getStockItem_GroceryProduct() {
    StockItem expectedStockItem = new StockItem(testGrocery, 1);
    testInventory.addStockItem(expectedStockItem);
    assertEquals(expectedStockItem, testInventory.getStockItem(testGrocery));
  }

  @Test
  void getStockItem_HouseholdProduct() {
    StockItem expectedStockItem = new StockItem(testHousehold, 1);
    testInventory.addStockItem(expectedStockItem);
    assertEquals(expectedStockItem, testInventory.getStockItem(testHousehold));
  }

  @Test
  void checkAndSubstituteProduct_NoSubstitution() {
    testInventory.addStockItem(expectedStockGroceryItem);
    testShoppingCart.getShoppingItems().put(testGrocery, 1);
    testInventory.checkAndSubstituteProduct(testShoppingCart, testReceipt);
    assertEquals(expectedReceipt, testReceipt);
  }

  @Test
  void checkAndSubstituteProduct_GroceryCanBeSubstituted() {
    StockItem groceryStockItem = new StockItem(testGrocery, 1);
    StockItem groceryStockItem1 = new StockItem(testGrocery1, 100);

    testInventory.addStockItem(groceryStockItem);
    testInventory.addStockItem(groceryStockItem1);

    testShoppingCart.addItem(testGrocery, 80);
    testInventory.checkAndSubstituteProduct(testShoppingCart, testReceipt);

    assertEquals(expectedReceipt, testReceipt);
  }

  @Test
  void checkAndSubstituteProduct_GroceryCanNotBeSubstituted() {
    StockItem groceryStockItem = new StockItem(testGrocery, 1);
    testInventory.addStockItem(groceryStockItem);

    testShoppingCart.addItem(testGrocery, 80);
    testInventory.checkAndSubstituteProduct(testShoppingCart, testReceipt);

    expectedReceipt.getProductsRemovedWithoutSubstitution().add(testGrocery);

    assertEquals(expectedReceipt, testReceipt);
  }

  @Test
  void checkAndSubstituteProduct_HouseholdCanBeSubstituted() {
    StockItem householdStockItem = new StockItem(testHousehold, 1);
    StockItem householdStockItem1 = new StockItem(testHousehold1, 100);

    testInventory.addStockItem(householdStockItem);
    testInventory.addStockItem(householdStockItem1);

    testShoppingCart.addItem(testHousehold, 80);
    testInventory.checkAndSubstituteProduct(testShoppingCart, testReceipt);

    assertEquals(expectedReceipt, testReceipt);
  }

  @Test
  void checkAndSubstituteProduct_HouseholdCanNotBeSubstituted() {
    StockItem householdStockItem = new StockItem(testHousehold, 1);
    testInventory.addStockItem(householdStockItem);

    testShoppingCart.addItem(testHousehold, 80);
    testInventory.checkAndSubstituteProduct(testShoppingCart, testReceipt);

    expectedReceipt.getProductsRemovedWithoutSubstitution().add(testHousehold);

    assertEquals(expectedReceipt, testReceipt);
  }

  @Test
  void ageCheckingAndStockQuantityUpdate_BelowMinAge() {
    testCustomer = new Customer("Peter Parker", 2);

    StockItem householdStockItem = new StockItem(testHousehold, 1);
    testInventory.addStockItem(householdStockItem);

    testShoppingCart.addItem(testHousehold, 1);
    testInventory.ageCheckingAndStockQuantityUpdate(testCustomer.getAge(), testShoppingCart,
        testReceipt);
    expectedReceipt.getProductsRemovedDueToAge().add(testHousehold);

    assertEquals(expectedReceipt, testReceipt);
  }

  @Test
  void ageCheckingAndStockQuantityUpdate_PassMinAge() {

    StockItem householdStockItem = new StockItem(testHousehold, 1);
    testInventory.addStockItem(householdStockItem);

    testShoppingCart.addItem(testHousehold, 1);
    testInventory.ageCheckingAndStockQuantityUpdate(testCustomer.getAge(), testShoppingCart,
        testReceipt);

    expectedReceipt.getProductsReceived().add(testHousehold);

    assertEquals(0, householdStockItem.getQuantity());
    assertEquals(expectedReceipt, testReceipt);
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testInventory.equals(testInventory));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testInventory.equals(null));
  }

  @Test
  void testEquals_DifferentClass() {
    assertFalse(testInventory.equals(testCustomer));
  }


  @Test
  void testEquals_DifferentGroceriesList() {
    StockItem groceryStockItem = new StockItem(testGrocery, 1);
    testInventory.addStockItem(groceryStockItem);
    assertFalse(testInventory.equals(testInventory1));
  }

  @Test
  void testEquals_DifferentHouseholdsList() {
    StockItem householdStockItem = new StockItem(testHousehold, 1);
    testInventory1.addStockItem(householdStockItem);
    assertFalse(testInventory.equals(testInventory1));
  }

  @Test
  void testEquals_SameInventory() {
    assertEquals(testInventory, testInventory1);
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(expectedGroceries, expectedHousehold);
    assertEquals(expectedHashCode, testInventory.hashCode());
  }

  @Test
  void testToString() {
    String expectedString =
        "Inventory{Groceries list: " + expectedGroceries.toString() + "; Households list: "
            + expectedHousehold.toString() + '}';
    assertEquals(expectedString, testInventory.toString());
  }

}
