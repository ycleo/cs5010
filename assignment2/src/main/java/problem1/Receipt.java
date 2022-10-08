package problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Receipt {

  private double totalPricePaid;
  private List<Product> productsReceived;
  private List<Product> productsRemovedWithoutSubstitution;
  private List<Product> productsRemovedDueToAge;

  public Receipt() {
    this.totalPricePaid = 0.0;
    this.productsReceived = new ArrayList<>();
    this.productsRemovedWithoutSubstitution = new ArrayList<>();
    this.productsRemovedDueToAge = new ArrayList<>();
  }

  public double getTotalPricePaid() {
    return this.totalPricePaid;
  }

  public void setTotalPricePaid(double totalPricePaid) {
    this.totalPricePaid = totalPricePaid;
  }

  public List<Product> getProductsReceived() {
    return this.productsReceived;
  }

  public List<Product> getProductsRemovedWithoutSubstitution() {
    return this.productsRemovedWithoutSubstitution;
  }

  public List<Product> getProductsRemovedDueToAge() {
    return productsRemovedDueToAge;
  }

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

  @Override
  public int hashCode() {
    return Objects.hash(this.getTotalPricePaid(), this.getProductsReceived(),
        this.getProductsRemovedWithoutSubstitution(), this.getProductsRemovedDueToAge());
  }

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
