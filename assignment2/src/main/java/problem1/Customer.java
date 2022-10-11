package problem1;

import java.util.Objects;

/**
 * Class Customer with below properties: name, age, and the shopping cart
 *
 * @author ycleo
 */
public class Customer {

  private static final int DEFAULT_ADD_PRODUCT_QUANTITY = 1;
  private String name;
  private int age;
  private ShoppingCart shoppingCart;

  /**
   * Constructs Customer with below properties, and instantiate a ShoppingCart object for the
   * shoppingCart property
   *
   * @param name customer name
   * @param age  customer age
   */
  public Customer(String name, int age) {
    this.name = name;
    this.age = age;
    this.shoppingCart = new ShoppingCart();
  }

  /**
   * Returns the customer name
   *
   * @return the customer name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Returns the customer age
   *
   * @return the customer age
   */
  public int getAge() {
    return this.age;
  }

  /**
   * Returns the customer shopping cart
   *
   * @return the customer shopping cart
   */
  public ShoppingCart getShoppingCart() {
    return this.shoppingCart;
  }

  /**
   * Adds or selects a certain stock item from certain inventory with quantity specified
   *
   * @param inventory The market inventory
   * @param stockItem The stock item in the market inventory
   * @param quantity  The quantity selected by the customer
   */
  public void addProduct(Inventory inventory, StockItem stockItem, int quantity) {
    Product product = stockItem.getProduct();
    try {
      if (quantity > stockItem.getQuantity()) {
        throw new ProductStockNotEnoughError("Warning: The product is out of stock.");
      } else {
        this.getShoppingCart().addItem(product, quantity);
      }
    } catch (ProductStockNotEnoughError e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Adds or selects a certain stock item from certain inventory
   *
   * @param inventory The market inventory
   * @param stockItem The stock item in the market inventory
   */
  public void addProduct(Inventory inventory, StockItem stockItem) {
    this.addProduct(inventory, stockItem, this.DEFAULT_ADD_PRODUCT_QUANTITY);
  }

  /**
   * Submits the shopping cart to get the final receipt
   *
   * @param inventory The market inventory
   * @return The final Receipt object
   */
  public Receipt submitShoppingCart(Inventory inventory) {
    Receipt receipt = new Receipt();
    ShoppingCart shoppingCart = this.getShoppingCart();

    inventory.checkAndSubstituteProduct(shoppingCart, receipt);
    inventory.ageCheckingAndStockQuantityUpdate(this.getAge(), shoppingCart, receipt);
    receipt.setTotalPricePaid(shoppingCart.totalCost());
    shoppingCart.clearShoppingCart();

    return receipt;
  }

  /**
   * Tests two objects have the same property values or not
   *
   * @param o tested object
   * @return boolean result
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    Customer customer = (Customer) o;
    return Objects.equals(this.name, customer.name)
        && Objects.equals(this.age, customer.age)
        && Objects.equals(this.shoppingCart, customer.shoppingCart);
  }

  /**
   * Returns the hash code of the Customer object
   *
   * @return the hash code value
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.name, this.age, this.shoppingCart);
  }

  /**
   * Returns the string represents the Customer information
   *
   * @return String about the Customer
   */
  @Override
  public String toString() {
    return "Customer{" +
        "Name: " + this.name +
        "; Age: " + this.age +
        "; Shopping Cart: " + this.shoppingCart.toString() +
        '}';
  }
}
