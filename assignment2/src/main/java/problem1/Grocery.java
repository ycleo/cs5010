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
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Grocery grocery = (Grocery) o;
    return Objects.equals(this.getWeight(), grocery.getWeight());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.getWeight());
  }

  @Override
  public String toString() {
    return "Grocery{" +
        "Manufacturer: " + this.getManufacturer() +
        "; Product Name: " + this.getName() +
        "; Price: " + this.getPrice() +
        "; Minimum Age To Buy: " + this.getMinAgeToBuy() +
        "; Weight: " + this.getWeight() +
        '}';
  }
}
