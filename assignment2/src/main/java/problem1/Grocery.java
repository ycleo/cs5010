package problem1;

import java.util.Objects;

/**
 * Abstract class inherited from another abstract class AbstractProduct, but with additional
 * property: product weight
 *
 * @author ycleo
 */
public abstract class Grocery extends AbstractProduct {

  final private double weight;

  /**
   * Constructs Grocery with below properties
   *
   * @param manufacturer product manufacturer
   * @param name         product name
   * @param price        product price
   * @param minAgeToBuy  the minimum age to buy the product
   * @param weight       product weight
   */
  public Grocery(String manufacturer, String name, double price, int minAgeToBuy, double weight) {
    super(manufacturer, name, price, minAgeToBuy);
    this.weight = weight;
  }

  /**
   * Returns the product weight
   *
   * @return the product weight
   */
  public double getWeight() {
    return this.weight;
  }

  /**
   * Tests two objects have the same property values or not
   *
   * @param o tested object
   * @return boolean result
   */
  @Override
  public boolean equals(Object o) {
    if (o instanceof Grocery) {
      Grocery grocery = (Grocery) o;
      return super.equals(o) && Objects.equals(this.getWeight(), grocery.getWeight());
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
    return Objects.hash(super.hashCode(), this.getWeight());
  }

}
