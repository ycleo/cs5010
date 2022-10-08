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

  public String getName() {
    return this.name;
  }

  public int getAge() {
    return this.age;
  }

  public ShoppingCart getShoppingCart() {
    return this.shoppingCart;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }
  public void addProduct(Inventory inventory, StockItem stockItem, int quantity){
    Product product = stockItem.getProduct();
    try {
      if(quantity > stockItem.getQuantity()) {
        throw new ProductNotEnoughError("The quantity you order is over our stock.");
      } else {
        this.getShoppingCart().addItem(product, quantity);
      }
    } catch (ProductNotEnoughError e) {
      System.out.println(e.getMessage());
    }
  }

  public void addProduct(Inventory inventory, StockItem stockItem) {
    this.addProduct(inventory, stockItem, this.DEFAULT_ADD_PRODUCT_QUANTITY);
  }

  public Receipt submitShoppingCart(Inventory inventory) {
    Receipt receipt = new Receipt();
    inventory.checkShoppingCart(this, this.getShoppingCart(), receipt);
    inventory.finalProcess(this, this.getShoppingCart(), receipt);
    return receipt;
  }
}
