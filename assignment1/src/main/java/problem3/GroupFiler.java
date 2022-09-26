package problem3;

/**
 * Represents a group tax filer with contact information, last year's earnings, Total income tax
 * already paid, all expenses for tax mitigation, filer type, and dependent information
 *
 * @author Yi-Cheng Lee
 */
public class GroupFiler extends TaxFiler {

  private FilerType filerType;
  private DependentInfo dependentInfo;

  /**
   * Constructor for class GroupFiler
   *
   * @param contactInfo        the contact information
   * @param lastYearEarnings   the last year's earnings
   * @param incomeTaxPaid      the total tax income already paid
   * @param taxMitigateExpense the expenses for tax mitigation
   * @param filerType          the filer type
   * @param dependentInfo      the dependent information
   */
  public GroupFiler(ContactInfo contactInfo, Double lastYearEarnings,
      Double incomeTaxPaid, TaxMitigateExpense taxMitigateExpense, FilerType filerType,
      DependentInfo dependentInfo) {
    super(contactInfo, lastYearEarnings, incomeTaxPaid, taxMitigateExpense);
    if (filerType == FilerType.EMPLOYEE) {
      throw new IllegalArgumentException(
          "Employee belongs to individual tax filer, not group tax filer.");
    }
    this.filerType = filerType;
    this.dependentInfo = dependentInfo;
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
   * gets the dependent information
   *
   * @return the dependent information
   */
  public DependentInfo getDependentInfo() {
    return this.dependentInfo;
  }

  /**
   * Calculates the savings deduction
   *
   * @return the savings deduction
   */
  public Double calculateSavingsDeduction() {
    Savings savings = this.getTaxMitigateExpense().getSavings();
    Double savingsDeduction = (savings.getRetireSavings() + savings.getHealthSavings()) * 0.65;
    if (savingsDeduction.compareTo(17500.0) > 0) {
      savingsDeduction = 17500.0;
    }

    return (savingsDeduction < this.calculateBasicTaxableIncome()) ? savingsDeduction
        : Double.valueOf(0.0);
  }

  /**
   * Calculates the childcare deduction
   *
   * @return the childcare deduction
   */
  public Double calculateChildcareDeduction() {
    Double childcareDeduction = 0.0;
    Double childcareExpense = this.getDependentInfo().getChildcareExpense();
    if (this.getLastYearEarnings().compareTo(200000.0) < 0
        && childcareExpense.compareTo(5000.0) > 0) {
      childcareDeduction = 1250.0;
    }
    return childcareDeduction;
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
    Double childcareDeduction = this.calculateChildcareDeduction();
    Double taxAmount =
        basicTaxableIncome - savingsDeduction - houseExpenseDeduction - childcareDeduction;
    return (taxAmount.compareTo(90000.0) > 0) ? taxAmount * 0.185 : taxAmount * 0.145;
  }
}
