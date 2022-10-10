package problem1;

import java.util.Objects;

/**
 * Represents Product
 *
 * @author Yi-Cheng Lee
 */
public abstract class Grocery extends AbstractProduct {

  final private double weight;

  public Grocery(String manufacturer, String name, double price, int minAgeToBuy, double weight) {
    super(manufacturer, name, price, minAgeToBuy);
    this.weight = weight;
  }

  public double getWeight() {
    return this.weight;
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Grocery) {
      Grocery grocery = (Grocery) o;
      return super.equals(o) && Objects.equals(this.getWeight(), grocery.getWeight());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.getWeight());
  }

}
