package problem1;

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
}
