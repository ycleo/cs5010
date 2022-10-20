package problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Class Inventory that contains two types of product list: Grocery and Household
 *
 * @author ycleo
 */
public class Inventory<T> {

  private final static double ZERO_VALUE_DOUBLE = 0.0;
  private final static int ZERO_VALUE_INT = 0;
  private List<StockItem> groceries;
  private List<StockItem> households;

  /**
   * Constructs Inventory, auto instantiating two ArrayList: groceries and households
   */
  public Inventory() {
    this.groceries = new ArrayList<>();
    this.households = new ArrayList<>();
  }

  /**
   * Adds a StockItem object into inventory
   *
   * @param stockItem a StockItem object
   */

  public void addStockItem(StockItem stockItem) {
    if (stockItem.getProduct() instanceof Grocery) {
      this.groceries.add(stockItem);
    } else if (stockItem.getProduct() instanceof Household) {
      this.households.add(stockItem);
    }
  }

  /**
   * Returns the total retail value of the inventory
   *
   * @return the total retail value of the inventory
   */
  public double getTotalRetailValue() {
    double totalRetailValue = ZERO_VALUE_DOUBLE;
    for (int i = ZERO_VALUE_INT; i < this.groceries.size(); i++) {
      StockItem stockGrocery = this.groceries.get(i);
      double groceryPrice = stockGrocery.getProduct().getPrice();
      int groceryQuantity = stockGrocery.getQuantity();
      totalRetailValue += groceryPrice * groceryQuantity;
    }
    for (int i = ZERO_VALUE_INT; i < this.households.size(); i++) {
      StockItem stockHousehold = this.households.get(i);
      double householdPrice = stockHousehold.getProduct().getPrice();
      int householdQuantity = stockHousehold.getQuantity();
      totalRetailValue += householdPrice * householdQuantity;
    }
    return totalRetailValue;
  }

  /**
   * Searches and returns the StockItem object by a product object
   *
   * @param product the searching product object
   * @return the target StockItem object
   */
  public StockItem getStockItem(Product product) {
    StockItem stockItem = new StockItem(null, ZERO_VALUE_INT);
    List<StockItem> searchingList = product instanceof Grocery ? this.groceries : this.households;

    for (int i = ZERO_VALUE_INT; i < searchingList.size(); i++) {
      if (searchingList.get(i).getProduct() == product) {
        stockItem = searchingList.get(i);
        break;
      }
    }
    return stockItem;
  }

  /**
   * Checks the substitution operation can pass the general rules, including: 1. Products can only
   * be substituted with the same specific type of product 2. The substituted item must be enough
   * for purchase 3. Products can only be substituted with another product that is the same price as
   * or cheaper than the original
   *
   * @param productPurchased  the purchased product that is out of stock and needs to be
   *                          substituted
   * @param quantityPurchased the purchased quantity of the product
   * @param targetStockItem   the target StockItem in the inventory that might be a potential
   *                          substituted product
   * @return the boolean result
   */
  private boolean passedGeneralSubstitutionRule(Product productPurchased, int quantityPurchased,
      StockItem targetStockItem) {
    Product targetProduct = targetStockItem.getProduct();

    return targetProduct.getClass().equals(productPurchased.getClass())
        && targetStockItem.quantityEnoughForPurchase(quantityPurchased)
        && targetProduct.getPrice() <= productPurchased.getPrice();
  }

  /**
   * Substitutes the grocery product if passes the rule that the weight of the substitution must be
   * the same as or greater than the original product
   *
   * @param productPurchased  the purchased grocery product
   * @param quantityPurchased the purchased quantity
   * @param shoppingCart      the shopping cart
   * @return the boolean result
   */
  private boolean substituteGrocery(Grocery productPurchased, int quantityPurchased,
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

  /**
   * Substitutes the household product if passes the rule that the number of units in the package
   * must be the same as or greater than the original product
   *
   * @param productPurchased  the purchased household product
   * @param quantityPurchased the purchased quantity
   * @param shoppingCart      the shopping cart
   * @return the boolean result
   */
  private boolean substituteHousehold(Household productPurchased, int quantityPurchased,
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

  /**
   * Checks the submitted ShoppingCart and substitutes a product if out of stock
   *
   * @param shoppingCart The submitted ShoppingCart object
   * @param receipt      The Receipt object that records the substitution history
   */
  public void checkAndSubstituteProduct(ShoppingCart shoppingCart, Receipt receipt) {
    Map<Product, Integer> shoppingItems = shoppingCart.getShoppingItems();

    // check through the shopping items
    for (Map.Entry<Product, Integer> entry : shoppingItems.entrySet()) {
      Product productPurchased = entry.getKey();
      int quantityPurchased = entry.getValue();

      // product out of stock -> substitution
      if (quantityPurchased > this.getStockItem(productPurchased).getQuantity()) {
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

  /**
   * Checks the submitted ShoppingCart and removes a product if the customer's age is disqualified,
   * the method also updates the quantity of the purchased StockItem
   *
   * @param customersAge The customer's age
   * @param shoppingCart The submitted ShoppingCart object
   * @param receipt      The Receipt object that records the removal history and the final product
   *                     list
   */
  public void ageCheckingAndStockQuantityUpdate(int customersAge, ShoppingCart shoppingCart,
      Receipt receipt) {
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
    Inventory inventory = (Inventory) o;
    return Objects.equals(this.groceries, inventory.groceries)
        && Objects.equals(this.households, inventory.households);
  }

  /**
   * Returns the hash code of the Inventory object
   *
   * @return the hash code value
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.groceries, this.households);
  }

  /**
   * Returns the string represents the Inventory information
   *
   * @return String about the Inventory
   */
  @Override
  public String toString() {
    return "Inventory{" +
        "Groceries list: " + this.groceries.toString() +
        "; Households list: " + this.households.toString() +
        '}';
  }
}
