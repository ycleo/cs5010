package problem1;

/**
 * Interface Product defines required methods
 *
 * @author ycloe
 */
public interface Product {

  /**
   * Returns the product manufacturer
   *
   * @return product manufacturer
   */
  String getManufacturer();

  /**
   * Returns the product name
   *
   * @return product name
   */
  String getName();

  /**
   * Returns the product price
   *
   * @return product price
   */
  double getPrice();

  /**
   * Returns the minimum age to buy the product
   *
   * @return the minimum age to buy the product
   */
  int getMinAgeToBuy();

  /**
   * Tests two objects have the same property values or not
   *
   * @param o tested object
   * @return boolean result
   */
  @Override
  boolean equals(Object o);

  /**
   * Returns the hash code of the object
   *
   * @return hash code value
   */
  @Override
  int hashCode();

  /**
   * Returns the string represents the Product information
   *
   * @return String about the Product
   */
  @Override
  String toString();
}
