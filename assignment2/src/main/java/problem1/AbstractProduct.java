package problem1;

import java.util.Objects;

public abstract class AbstractProduct implements Product {

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    AbstractProduct abstractProduct = (AbstractProduct) o;
    return Objects.equals(this.getManufacturer(), abstractProduct.getManufacturer())
        && Objects.equals(this.getName(), abstractProduct.getName())
        && Objects.equals(this.getPrice(), abstractProduct.getPrice())
        && Objects.equals(this.getMinAgeToBuy(), abstractProduct.getMinAgeToBuy());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getManufacturer(), this.getName(), this.getPrice(),
        this.getMinAgeToBuy());
  }

  @Override
  public String toString() {
    return "Product{" +
        "Manufacturer: " + this.getManufacturer() +
        "; Product Name: " + this.getName() +
        "; Price: " + this.getPrice() +
        "; Minimum Age To Buy: " + this.getMinAgeToBuy() +
        '}';
  }

}
