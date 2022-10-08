package problem1;

import java.util.Objects;

public class Cheese extends Grocery {

  public Cheese(String manufacturer, String name, double price, int minAgeToBuy, double weight) {
    super(manufacturer, name, price, minAgeToBuy, weight);
  }

  @Override
  public boolean equals(Object o) {
    return (o instanceof Cheese) && super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode());
  }

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
