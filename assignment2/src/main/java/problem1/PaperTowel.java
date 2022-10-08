package problem1;

import java.util.Objects;

public class PaperTowel extends Household {

  public PaperTowel(String manufacturer, String name, double price, int minAgeToBuy, int unit) {
    super(manufacturer, name, price, minAgeToBuy, unit);
  }

  @Override
  public boolean equals(Object o) {
    return (o instanceof PaperTowel) && super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode());
  }

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
