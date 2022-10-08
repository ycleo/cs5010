package problem1;

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

  public boolean isEnoughForPurchase(int quantity) {
    return this.getQuantity() >= quantity;
  }
}
