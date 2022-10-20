package problem1;

import java.util.Objects;

/**
 * Class PaperTowel inherited from class Household
 *
 * @author ycleo
 */
public class PaperTowel extends Household {

  /**
   * Constructs PaperTowel with below properties
   *
   * @param manufacturer product manufacturer
   * @param name         product name
   * @param price        product price
   * @param minAgeToBuy  the minimum age to buy the product
   * @param unit         product units per package
   */
  public PaperTowel(String manufacturer, String name, double price, int minAgeToBuy, int unit) {
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
    return (o instanceof PaperTowel) && super.equals(o);
  }

  /**
   * Returns the hash code of the PaperTowel object
   *
   * @return the hash code value
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode());
  }

  /**
   * Returns the string represents the PaperTowel information
   *
   * @return String about the PaperTowel
   */
  @Override
  public String toString() {
    return "PaperTowel{" +
        "Manufacturer: " + this.getManufacturer() +
        "; Product Name: " + this.getName() +
        "; Price: " + this.getPrice() +
        "; Minimum Age To Buy: " + this.getMinAgeToBuy() +
        "; Units Per Package: " + this.getUnit() +
        '}';
  }
}
