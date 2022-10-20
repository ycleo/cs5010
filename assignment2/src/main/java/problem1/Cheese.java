package problem1;

import java.util.Objects;

/**
 * Class Cheese inherited from class Grocery
 *
 * @author ycleo
 */
public class Cheese extends Grocery {

  /**
   * Constructs Cheese with below properties
   *
   * @param manufacturer product manufacturer
   * @param name         product name
   * @param price        product price
   * @param minAgeToBuy  the minimum age to buy the product
   * @param weight       product weight
   */
  public Cheese(String manufacturer, String name, double price, int minAgeToBuy, double weight) {
    super(manufacturer, name, price, minAgeToBuy, weight);
  }

  /**
   * Tests two objects have the same property values or not
   *
   * @param o tested object
   * @return boolean result
   */
  @Override
  public boolean equals(Object o) {
    return (o instanceof Cheese) && super.equals(o);
  }

  /**
   * Returns the hash code of the Cheese object
   *
   * @return the hash code value
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode());
  }

  /**
   * Returns the string represents the Cheese information
   *
   * @return String about the Cheese
   */
  @Override
  public String toString() {
    return "Cheese{" +
        "Manufacturer: " + this.getManufacturer() +
        "; Product Name: " + this.getName() +
        "; Price: " + this.getPrice() +
        "; Minimum Age To Buy: " + this.getMinAgeToBuy() +
        "; Weight: " + this.getWeight() +
        '}';
  }
}
