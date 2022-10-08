package problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Inventory {

  private List<StockItem> groceries;
  private List<StockItem> households;

  public Inventory() {
    this.groceries = new ArrayList<>();
    this.households = new ArrayList<>();
  }

  public void addStockItem(StockItem stockItem) {
    if (stockItem.getProduct() instanceof Grocery) {
      this.groceries.add(stockItem);
    } else if (stockItem.getProduct() instanceof Household) {
      this.households.add(stockItem);
    }
  }

  public double getTotalRetailValue() {
    double totalRetailValue = 0.0;
    for (int i = 0; i < this.groceries.size(); i++) {
      StockItem stockGrocery = this.groceries.get(i);
      double groceryPrice = stockGrocery.getProduct().getPrice();
      int groceryQuantity = stockGrocery.getQuantity();
      totalRetailValue += groceryPrice * groceryQuantity;
    }
    for (int i = 0; i < this.households.size(); i++) {
      StockItem stockHousehold = this.households.get(i);
      double householdPrice = stockHousehold.getProduct().getPrice();
      int householdQuantity = stockHousehold.getQuantity();
      totalRetailValue += householdPrice * householdQuantity;
    }
    return totalRetailValue;
  }

  public StockItem getStockItem(Product product) {
    StockItem stockItem = new StockItem(null, 0);
    List<StockItem> searchingList = product instanceof Grocery ? this.groceries : this.households;

    for (int i = 0; i < searchingList.size(); i++) {
      if (searchingList.get(i).getProduct() == product) {
        stockItem = searchingList.get(i);
        break;
      }
    }
    return stockItem;
  }

  public void checkAndSubstituteProduct(ShoppingCart shoppingCart, Receipt receipt) {
    Map<Product, Integer> shoppingItems = shoppingCart.getShoppingItems();

    // check through the shopping items
    for (Map.Entry<Product, Integer> entry : shoppingItems.entrySet()) {
      Product productPurchased = entry.getKey();
      int quantityPurchased = entry.getValue();

      // product out of stock -> substitution
      if (quantityPurchased < this.getStockItem(productPurchased).getQuantity()) {
        // remove the product from the shopping cart
        shoppingCart.removeItem(productPurchased);
        boolean substituted = false;

        if (productPurchased instanceof Grocery) {
          substituted = this.substituteGrocery((Grocery) productPurchased, quantityPurchased,
              shoppingCart);
        } else {
          substituted = this.substituteHousehold((Household) productPurchased, quantityPurchased,
              shoppingCart);
        }

        // update receipt if substitution failed
        if (!substituted) {
          receipt.getProductsRemovedWithoutSubstitution().add(productPurchased);
        }
      }
    }
  }

  public boolean substituteGrocery(Grocery productPurchased, int quantityPurchased,
      ShoppingCart shoppingCart) {
    boolean substituted = false;
    for (int i = 0; i < this.groceries.size(); i++) {
      StockItem targetStockItem = this.groceries.get(i);
      Grocery targetProduct = (Grocery) targetStockItem.getProduct();

      if (this.passedGeneralSubstitutionRule(productPurchased, quantityPurchased, targetStockItem)
          && targetProduct.getWeight() >= productPurchased.getWeight()) {
        shoppingCart.addItem(targetProduct, quantityPurchased);
        substituted = true;
        break;
      }
    }
    return substituted;
  }

  public boolean substituteHousehold(Household productPurchased, int quantityPurchased,
      ShoppingCart shoppingCart) {
    boolean substituted = false;
    for (int i = 0; i < this.households.size(); i++) {
      StockItem targetStockItem = this.households.get(i);
      Household targetProduct = (Household) targetStockItem.getProduct();

      if (this.passedGeneralSubstitutionRule(productPurchased, quantityPurchased, targetStockItem)
          && targetProduct.getUnit() >= productPurchased.getUnit()) {
        shoppingCart.addItem(targetProduct, quantityPurchased);
        substituted = true;
        break;
      }
    }
    return substituted;
  }

  public boolean passedGeneralSubstitutionRule(Product productPurchased, int quantityPurchased,
      StockItem targetStockItem) {
    Product targetProduct = targetStockItem.getProduct();

    return targetProduct.getClass().equals(productPurchased.getClass())
        && targetStockItem.quantityEnoughForPurchase(quantityPurchased)
        && targetProduct.getPrice() <= productPurchased.getPrice();
  }

  public void finalCheckingProcess(int customersAge, ShoppingCart shoppingCart, Receipt receipt) {
    Map<Product, Integer> shoppingItems = shoppingCart.getShoppingItems();

    // check through the shopping items
    for (Map.Entry<Product, Integer> entry : shoppingItems.entrySet()) {
      Product productPurchased = entry.getKey();
      int quantityPurchased = entry.getValue();

      // check customer's age is qualified
      if (customersAge < productPurchased.getMinAgeToBuy()) {
        // record age-disqualified product on the receipt
        receipt.getProductsRemovedDueToAge().add(productPurchased);
      } else {
        StockItem stockItem = this.getStockItem(productPurchased);
        // update stock quantity
        stockItem.setQuantity(stockItem.getQuantity() - quantityPurchased);
        // add product to the receipt
        receipt.getProductsReceived().add(productPurchased);
      }
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    Inventory inventory = (Inventory) o;
    return Objects.equals(this.groceries, inventory.groceries)
        && Objects.equals(this.households, inventory.households);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.groceries, this.households);
  }

  @Override
  public String toString() {
    return "Inventory{" +
        "Groceries list: " + this.groceries.toString() +
        "; Households list: " + this.households.toString() +
        '}';
  }
}
