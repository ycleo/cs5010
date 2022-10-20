package problem1;

import java.util.Objects;

/**
 * Abstract class that implements the Product interface, containing getter methods for product
 * manufacturer, name, price, and the minimum age to buy
 *
 * @author ycleo
 */
public abstract class AbstractProduct implements Product {

  final private String manufacturer;
  final private String name;
  final private double price;
  final private int minAgeToBuy;

  /**
   * Constructs Product by below properties
   *
   * @param manufacturer product manufacturer
   * @param name         product name
   * @param price        product price
   * @param minAgeToBuy  the minimum age to buy the product
   */
  public AbstractProduct(String manufacturer, String name, double price, int minAgeToBuy) {
    this.manufacturer = manufacturer;
    this.name = name;
    this.price = price;
    this.minAgeToBuy = minAgeToBuy;
  }

  /**
   * Returns the product manufacturer
   *
   * @return product manufacturer
   */
  public String getManufacturer() {
    return this.manufacturer;
  }

  /**
   * Returns the product name
   *
   * @return product name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Returns the product price
   *
   * @return product price
   */
  public double getPrice() {
    return this.price;
  }

  /**
   * Returns the minimum age to buy the product
   *
   * @return the minimum age to buy the product
   */
  public int getMinAgeToBuy() {
    return this.minAgeToBuy;
  }

  /**
   * Tests two objects have the same property values or not
   *
   * @param o tested object
   * @return boolean result
   */
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

  /**
   * Returns the hash code of the object
   *
   * @return hash code value
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.getManufacturer(), this.getName(), this.getPrice(),
        this.getMinAgeToBuy());
  }

}
