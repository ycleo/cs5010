package problem1;

import java.util.Objects;

public class Salmon extends Grocery {

  public Salmon(String manufacturer, String name, double price, int minAgeToBuy, double weight) {
    super(manufacturer, name, price, minAgeToBuy, weight);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    return super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode());
  }

  @Override
  public String toString() {
    return "Salmon{" +
        "Manufacturer: " + this.getManufacturer() +
        "; Product Name: " + this.getName() +
        "; Price: " + this.getPrice() +
        "; Minimum Age To Buy: " + this.getMinAgeToBuy() +
        "; Weight: " + this.getWeight() +
        '}';
  }
}
