package problem1;

import java.util.ArrayList;
import java.util.List;

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


}
