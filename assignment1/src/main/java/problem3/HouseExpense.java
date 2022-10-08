package problem3;

/**
 * Represents the house expense of a tax filer with the mortgage interest paid and the property
 * taxes paid
 *
 * @author Yi-Cheng Lee
 */
public class HouseExpense {

  private Double mortgageInterestPaid;
  private Double propertyTaxPaid;

  /**
   * Constructor for class HouseExpense
   *
   * @param mortgageInterestPaid the mortgage interest paid
   * @param propertyTaxPaid      the property taxes paid
   */
  public HouseExpense(Double mortgageInterestPaid, Double propertyTaxPaid) {
    this.mortgageInterestPaid = mortgageInterestPaid;
    this.propertyTaxPaid = propertyTaxPaid;
  }

  /**
   * gets the mortgage interest paid
   *
   * @return the mortgage interest paid
   */
  public Double getMortgageInterestPaid() {
    return this.mortgageInterestPaid;
  }

  /**
   * gets the property taxes paid
   *
   * @return the property taxes paid
   */
  public Double getPropertyTaxPaid() {
    return this.propertyTaxPaid;
  }
}
