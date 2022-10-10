package problem1;

import java.util.Objects;

public class Customer {

  private static final int DEFAULT_ADD_PRODUCT_QUANTITY = 1;
  private String name;
  private int age;
  private ShoppingCart shoppingCart;

  public Customer(String name, int age) {
    this.name = name;
    this.age = age;
    this.shoppingCart = new ShoppingCart();
  }

  public String getName() {
    return this.name;
  }

  public int getAge() {
    return this.age;
  }

  public ShoppingCart getShoppingCart() {
    return this.shoppingCart;
  }

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

  public void addProduct(Inventory inventory, StockItem stockItem) {
    this.addProduct(inventory, stockItem, this.DEFAULT_ADD_PRODUCT_QUANTITY);
  }

  public Receipt submitShoppingCart(Inventory inventory) {
    Receipt receipt = new Receipt();
    ShoppingCart shoppingCart = this.getShoppingCart();

    inventory.checkAndSubstituteProduct(shoppingCart, receipt);
    inventory.ageCheckingAndStockQuantityUpdate(this.getAge(), shoppingCart, receipt);
    receipt.setTotalPricePaid(shoppingCart.totalCost());
    shoppingCart.clearShoppingCart();

    return receipt;
  }

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

  @Override
  public int hashCode() {
    return Objects.hash(this.name, this.age, this.shoppingCart);
  }

  @Override
  public String toString() {
    return "Customer{" +
        "Name: " + this.name +
        "; Age: " + this.age +
        "; Shopping Cart: " + this.shoppingCart.toString() +
        '}';
  }
}
