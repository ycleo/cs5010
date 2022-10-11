package problem1;

import java.util.Objects;

/**
 * Class Shampoo inherited from class Household
 *
 * @author ycleo
 */
public class Shampoo extends Household {

  /**
   * Constructs Shampoo with below properties
   *
   * @param manufacturer product manufacturer
   * @param name         product name
   * @param price        product price
   * @param minAgeToBuy  the minimum age to buy the product
   * @param unit         product units per package
   */
  public Shampoo(String manufacturer, String name, double price, int minAgeToBuy, int unit) {
    super(manufacturer, name, price, minAgeToBuy, unit);
  }

  /**
   * Tests two objects have the same property values or not
   *
   * @param o tested object
   * @return boolean result
   */
  @Override
  public boolean equals(Object o) {
    return (o instanceof Shampoo) && super.equals(o);
  }

  /**
   * Returns the hash code of the Shampoo object
   *
   * @return the hash code value
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode());
  }

  /**
   * Returns the string represents the Shampoo information
   *
   * @return String about the Shampoo
   */
  @Override
  public String toString() {
    return "Shampoo{" +
        "Manufacturer: " + this.getManufacturer() +
        "; Product Name: " + this.getName() +
        "; Price: " + this.getPrice() +
        "; Minimum Age To Buy: " + this.getMinAgeToBuy() +
        "; Units Per Package: " + this.getUnit() +
        '}';
  }
}
