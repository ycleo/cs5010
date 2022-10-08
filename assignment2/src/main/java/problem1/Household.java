package problem1;

public abstract class Household extends AbstractProduct {

  final private int unit;

  public Household(String manufacturer, String name, double price, int minAgeToBuy, int unit) {
    super(manufacturer, name, price, minAgeToBuy);
    this.unit = unit;
  }

  public int getUnit() {
    return this.unit;
  }
}
