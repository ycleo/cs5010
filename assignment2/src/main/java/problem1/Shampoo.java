package problem1;

import java.util.Objects;

public class Shampoo extends Household {

  public Shampoo(String manufacturer, String name, double price, int minAgeToBuy, int unit) {
    super(manufacturer, name, price, minAgeToBuy, unit);
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
    return "Shampoo{" +
        "Manufacturer: " + this.getManufacturer() +
        "; Product Name: " + this.getName() +
        "; Price: " + this.getPrice() +
        "; Minimum Age To Buy: " + this.getMinAgeToBuy() +
        "; Units Per Package: " + this.getUnit() +
        '}';
  }
}
