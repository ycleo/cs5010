package problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class Receipt containing the following information: 1. The total price paid 2. The list of
 * products the customer received when the order was processed 3. A list of any products that were
 * out of stock and could not be substituted 4. A list of any products that were removed from the
 * order because the customer did not meet minimum age requirements
 *
 * @author ycleo
 */
public class Receipt {

  private double totalPricePaid;
  private List<Product> productsReceived;
  private List<Product> productsRemovedWithoutSubstitution;
  private List<Product> productsRemovedDueToAge;

  /**
   * Constructs Receipt object with below properties instantiated: 1. The total price paid 2. The
   * list of products the customer received 3. The list of any products that were out of stock and
   * could not be substituted 4. The list of any products that were removed from the order because
   * the customer did not meet minimum age requirements
   */
  public Receipt() {
    this.totalPricePaid = 0.0;
    this.productsReceived = new ArrayList<>();
    this.productsRemovedWithoutSubstitution = new ArrayList<>();
    this.productsRemovedDueToAge = new ArrayList<>();
  }

  /**
   * Returns the total price paid
   *
   * @return the total price paid
   */
  public double getTotalPricePaid() {
    return this.totalPricePaid;
  }

  /**
   * Sets the total price paid with a double value
   *
   * @param totalPricePaid new total price paid value
   */
  public void setTotalPricePaid(double totalPricePaid) {
    this.totalPricePaid = totalPricePaid;
  }

  /**
   * Returns the list of products the customer received
   *
   * @return the list of products the customer received
   */
  public List<Product> getProductsReceived() {
    return this.productsReceived;
  }

  /**
   * Returns the list of any products that were out of stock and could not be substituted
   *
   * @return the list of any products that were out of stock and could not be substituted
   */
  public List<Product> getProductsRemovedWithoutSubstitution() {
    return this.productsRemovedWithoutSubstitution;
  }

  /**
   * Returns the list of any products that were removed from the order because the customer did not
   * meet minimum age requirements
   *
   * @return the list of any products that were removed from the order because the customer did not
   * meet minimum age requirements
   */
  public List<Product> getProductsRemovedDueToAge() {
    return productsRemovedDueToAge;
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
    Receipt receipt = (Receipt) o;
    return Objects.equals(this.getTotalPricePaid(), receipt.getTotalPricePaid())
        && Objects.equals(this.getProductsReceived(), receipt.getProductsReceived())
        && Objects.equals(this.getProductsRemovedWithoutSubstitution(),
        receipt.getProductsRemovedWithoutSubstitution())
        && Objects.equals(this.getProductsRemovedDueToAge(), receipt.getProductsRemovedDueToAge());
  }

  /**
   * Returns the hash code of the Receipt object
   *
   * @return the hash code value
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.getTotalPricePaid(), this.getProductsReceived(),
        this.getProductsRemovedWithoutSubstitution(), this.getProductsRemovedDueToAge());
  }

  /**
   * Returns the string represents the Receipt information
   *
   * @return String about the Receipt
   */
  @Override
  public String toString() {
    return "Receipt{" +
        "Total Price Paid: " + this.getTotalPricePaid() +
        "; Received Products List: " + this.getProductsReceived().toString() +
        "; Out of Stock Without Substitution Products List: "
        + this.getProductsRemovedWithoutSubstitution().toString() +
        "; Removed Due To Age Products List: " + this.getProductsRemovedDueToAge().toString() +
        '}';
  }

}
