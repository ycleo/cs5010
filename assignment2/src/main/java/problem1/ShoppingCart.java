package problem1;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ShoppingCart {

  private Map<Product, Integer> shoppingItems; // product name: quantities

  public ShoppingCart() {
    this.shoppingItems = new HashMap<>();
  }

  public Map<Product, Integer> getShoppingItems() {
    return this.shoppingItems;
  }

  public void addItem(Product item, Integer quantity) {
    this.shoppingItems.put(item, quantity);
  }

  public void removeItem(Product item) {
    this.shoppingItems.remove(item);
  }

  public void clearShoppingCart() {
    this.shoppingItems.clear();
  }

  public double totalCost() {
    double totalCost = 0.0;
    for (Map.Entry<Product, Integer> entry : this.shoppingItems.entrySet()) {
      double productPrice = entry.getKey().getPrice();
      Integer quantity = entry.getValue();
      totalCost += productPrice * quantity;
    }
    return totalCost;
  }

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

  @Override
  public int hashCode() {
    return Objects.hash(this.getShoppingItems());
  }

  @Override
  public String toString() {
    return "ShoppingCart{Shopping Items: " + this.getShoppingItems().toString() + '}';
  }
}
