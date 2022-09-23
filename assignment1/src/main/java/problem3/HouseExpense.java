package problem3;

public class HouseExpense {

  private Double mortgageInterestPaid;
  private Double propertyTaxPaid;

  public HouseExpense(Double mortgageInterestPaid, Double propertyTaxPaid) {
    this.mortgageInterestPaid = mortgageInterestPaid;
    this.propertyTaxPaid = propertyTaxPaid;
  }

  public Double getMortgageInterestPaid() {
    return this.mortgageInterestPaid;
  }

  public Double getPropertyTaxPaid() {
    return this.propertyTaxPaid;
  }
}
