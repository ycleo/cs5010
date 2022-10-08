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
    if (o instanceof Household) {
      Household household = (Household) o;
      return super.equals(o) && Objects.equals(this.getUnit(), household.getUnit());
    }
    return false;
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
