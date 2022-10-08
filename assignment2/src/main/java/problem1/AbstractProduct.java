package problem1;

public abstract class AbstractProduct implements Product{

  final private String manufacturer;
  final private String name;
  final private double price;
  final private int minAgeToBuy;

  public AbstractProduct(String manufacturer, String name, double price, int minAgeToBuy) {
    this.manufacturer = manufacturer;
    this.name = name;
    this.price = price;
    this.minAgeToBuy = minAgeToBuy;
  }

  public String getManufacturer() {
    return this.manufacturer;
  }

  public String getName() {
    return this.name;
  }

  public double getPrice() {
    return this.price;
  }

  public int getMinAgeToBuy() {
    return this.minAgeToBuy;
  }

}
