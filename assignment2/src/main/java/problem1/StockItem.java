package problem1;

import java.util.Objects;

public class StockItem {

  private Product product;
  private int quantity;

  public StockItem(Product product, int quantity) {
    this.product = product;
    this.quantity = quantity;
  }

  public Product getProduct() {
    return this.product;
  }

  public int getQuantity() {
    return this.quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public boolean quantityEnoughForPurchase(int quantity) {
    return this.getQuantity() >= quantity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    StockItem stockItem = (StockItem) o;
    return Objects.equals(this.getProduct(), stockItem.getProduct())
        && Objects.equals(this.getQuantity(), stockItem.getQuantity());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getProduct(), this.getQuantity());
  }

  @Override
  public String toString() {
    return "StockItem{" +
        "Product: " + this.getProduct().toString() +
        "; Quantity: " + this.getQuantity() +
        '}';
  }
}
