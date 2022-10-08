package problem1;

import java.util.Objects;

public abstract class Household extends AbstractProduct {

  final private int unit;

  public Household(String manufacturer, String name, double price, int minAgeToBuy, int unit) {
    super(manufacturer, name, price, minAgeToBuy);
    this.unit = unit;
  }

  public int getUnit() {
    return this.unit;
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
    Household grocery = (Household) o;
    return Objects.equals(this.getUnit(), grocery.getUnit());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.getUnit());
  }

  @Override
  public String toString() {
    return "Household{" +
        "Manufacturer: " + this.getManufacturer() +
        "; Product Name: " + this.getName() +
        "; Price: " + this.getPrice() +
        "; Minimum Age To Buy: " + this.getMinAgeToBuy() +
        "; Units Per Package: " + this.getUnit() +
        '}';
  }
}
