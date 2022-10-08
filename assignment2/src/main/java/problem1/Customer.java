package problem1;

public class Customer {

  private final int DEFAULT_ADD_PRODUCT_QUANTITY = 1;
  private String name;
  private int age;
  private ShoppingCart shoppingCart;

  public Customer(String name, int age) {
    this.name = name;
    this.age = age;
    this.shoppingCart = new ShoppingCart();
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
    inventory.finalCheckingProcess(this.getAge(), shoppingCart, receipt);
    receipt.setTotalPricePaid(shoppingCart.totalCost());
    shoppingCart.clearShoppingCart();

    return receipt;
  }
}
