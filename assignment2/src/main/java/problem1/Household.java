package problem1;

import java.util.Objects;

/**
 * Abstract class inherited from another abstract class AbstractProduct, but with additional
 * property: product units per package
 *
 * @author ycleo
 */
public abstract class Household extends AbstractProduct {

  final private int unit;

  /**
   * Constructs Household with below properties
   *
   * @param manufacturer product manufacturer
   * @param name         product name
   * @param price        product price
   * @param minAgeToBuy  the minimum age to buy the product
   * @param unit         product units per package
   */
  public Household(String manufacturer, String name, double price, int minAgeToBuy, int unit) {
    super(manufacturer, name, price, minAgeToBuy);
    this.unit = unit;
  }

  /**
   * Returns the product units per package
   *
   * @return the product units per package
   */
  public int getUnit() {
    return this.unit;
  }

  /**
   * Tests two objects have the same property values or not
   *
   * @param o tested object
   * @return boolean result
   */
  @Override
  public boolean equals(Object o) {
    if (o instanceof Household) {
      Household household = (Household) o;
      return super.equals(o) && Objects.equals(this.getUnit(), household.getUnit());
    }
    return false;
  }

  /**
   * Returns the hash code of the object
   *
   * @return the hash code value
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.getUnit());
  }
}
