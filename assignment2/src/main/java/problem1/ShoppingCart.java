package problem1;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Class ShoppingCart the contains a shoppingItems which is a HashMap to stores the Product (key)
 * and its stock quantity (value)
 *
 * @author ycleo
 */
public class ShoppingCart {

  private Map<Product, Integer> shoppingItems; // product name: quantities

  /**
   * Constructs ShoppingCart object with the shoppingItems HashMap instantiated
   */
  public ShoppingCart() {
    this.shoppingItems = new HashMap<>();
  }

  /**
   * Returns the shoppingItems hashmap
   *
   * @return the shoppingItems hashmap
   */
  public Map<Product, Integer> getShoppingItems() {
    return this.shoppingItems;
  }

  /**
   * Adds the product to the shopping cart
   *
   * @param item     product item
   * @param quantity adding quantity
   */
  public void addItem(Product item, Integer quantity) {
    this.shoppingItems.put(item, quantity);
  }

  /**
   * Removes the product from the shopping cart
   *
   * @param item product item
   */
  public void removeItem(Product item) {
    this.shoppingItems.remove(item);
  }

  /**
   * Clears the shopping cart
   */
  public void clearShoppingCart() {
    this.shoppingItems.clear();
  }

  /**
   * Calculates and returns the total cost of the shopping cart
   *
   * @return the total cost of the shopping cart
   */
  public double totalCost() {
    double totalCost = 0.0;
    for (Map.Entry<Product, Integer> entry : this.shoppingItems.entrySet()) {
      double productPrice = entry.getKey().getPrice();
      Integer quantity = entry.getValue();
      totalCost += productPrice * quantity;
    }
    return totalCost;
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
    ShoppingCart shoppingCart = (ShoppingCart) o;
    return Objects.equals(this.getShoppingItems(), shoppingCart.getShoppingItems());
  }

  /**
   * Returns the hash code of the ShoppingCart object
   *
   * @return the hash code value
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.getShoppingItems());
  }

  /**
   * Returns the string represents the ShoppingCart information
   *
   * @return String about the ShoppingCart
   */
  @Override
  public String toString() {
    return "ShoppingCart{Shopping Items: " + this.getShoppingItems().toString() + '}';
  }
}
