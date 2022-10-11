package problem1;

import java.util.Objects;

/**
 * Class StockItem contains the Product object and the stock quantity as its properties
 *
 * @author ycleo
 */
public class StockItem {

  private Product product;
  private int quantity;

  /**
   * Constructs StockItem with below properties
   *
   * @param product  the Product object
   * @param quantity the stock quantity
   */
  public StockItem(Product product, int quantity) {
    this.product = product;
    this.quantity = quantity;
  }

  /**
   * Returns the Product object
   *
   * @return the Product object
   */
  public Product getProduct() {
    return this.product;
  }

  /**
   * Returns the stock quantity
   *
   * @return the stock quantity
   */
  public int getQuantity() {
    return this.quantity;
  }

  /**
   * Sets the stock quantity with a different integer number
   *
   * @param quantity the new stock quantity
   */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  /**
   * Checks the StockItem is enough for purchase with the quantity specified
   *
   * @param quantity the purchased quantity
   * @return the boolean result
   */
  public boolean quantityEnoughForPurchase(int quantity) {
    return this.getQuantity() >= quantity;
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
    StockItem stockItem = (StockItem) o;
    return Objects.equals(this.getProduct(), stockItem.getProduct())
        && Objects.equals(this.getQuantity(), stockItem.getQuantity());
  }

  /**
   * Returns the hash code of the StockItem object
   *
   * @return the hash code value
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.getProduct(), this.getQuantity());
  }

  /**
   * Returns the string represents the StockItem information
   *
   * @return String about the StockItem
   */
  @Override
  public String toString() {
    return "StockItem{" +
        "Product: " + this.getProduct().toString() +
        "; Quantity: " + this.getQuantity() +
        '}';
  }
}
