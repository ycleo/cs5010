package problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCustomer {
  private String expectedName;
  private int expectedAge;
  private ShoppingCart expectedShoppingCart;
  private Customer testCustomer;

  @BeforeEach
  void setUp() {
    expectedName = "Peter Parker";
    expectedAge = 23;
    expectedShoppingCart = new ShoppingCart();
    testCustomer = new Customer(expectedName, expectedAge);
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
    assertEquals(expectedShoppingCart, testCustomer.getShoppingCart());
  }

  @Test
  void addProduct() {
    
  }
}
