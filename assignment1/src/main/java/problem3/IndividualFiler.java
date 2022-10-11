package problem3;

/**
 * Represents an individual tax filer with contact information, last year's earnings, Total income
 * tax already paid, all expenses for tax mitigation
 */
public class IndividualFiler extends TaxFiler {

  private FilerType filerType;

  /**
   * Constructor for the class IndividualFiler (Default filer type of the individual filer is
   * EMPLOYEE)
   *
   * @param contactInfo        the contact information
   * @param lastYearEarnings   the last year's earnings
   * @param incomeTaxPaid      the total tax income already paid
   * @param taxMitigateExpense the expenses for tax mitigation
   */
  public IndividualFiler(ContactInfo contactInfo, Double lastYearEarnings,
      Double incomeTaxPaid, TaxMitigateExpense taxMitigateExpense) {
    super(contactInfo, lastYearEarnings, incomeTaxPaid, taxMitigateExpense);
    this.filerType = FilerType.EMPLOYEE;
  }

  /**
   * gets the filer type
   *
   * @return the filer type
   */
  public FilerType getFilerType() {
    return this.filerType;
  }

  /**
   * Calculates the savings deduction
   *
   * @return the savings deduction
   */
  public Double calculateSavingsDeduction() {
    Savings savings = this.getTaxMitigateExpense().getSavings();
    Double savingsDeduction =
        (savings.getRetireSavings() + savings.getHealthSavings())
            * 0.7;
    return (savingsDeduction < this.calculateBasicTaxableIncome()) ? savingsDeduction
        : Double.valueOf(0.0);
  }

  /**
   * Calculates the tax amount
   *
   * @return the tax amount
   */
  public Double calculateTaxes() {
    Double basicTaxableIncome = this.calculateBasicTaxableIncome();
    Double savingsDeduction = this.calculateSavingsDeduction();
    Double houseExpenseDeduction = this.calculateHouseExpenseDeduction();
    Double taxAmount = basicTaxableIncome - savingsDeduction - houseExpenseDeduction;
    return (taxAmount.compareTo(55000.0) > 0) ? taxAmount * 0.19 : taxAmount * 0.15;
  }
}
