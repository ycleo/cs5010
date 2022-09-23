package problem3;

public abstract class TaxFiler implements TaxFilerInterface {

  protected FilerType filerType;
  protected String taxId;
  protected ContactInfo contactInfo;
  protected Double lastYearEarnings;
  protected Double incomeTaxPaid;
  protected TaxMitigateExpense taxMitigateExpense;

  public String getTaxId() {
    return this.taxId;
  }

  public ContactInfo getContactInfo() {
    return this.contactInfo;
  }

  public Double getLastYearEarnings() {
    return this.lastYearEarnings;
  }

  public Double getIncomeTaxPaid() {
    return this.incomeTaxPaid;
  }

  public TaxMitigateExpense getTaxMitigateExpense() {
    return this.taxMitigateExpense;
  }

  public Double calculateBasicTaxableIncome() {
    return this.getLastYearEarnings() - this.getIncomeTaxPaid();
  }

  public Double calculateSavingsDeduction() {
    Savings savings = this.getTaxMitigateExpense().getSavings();
    Double savingsDeduction = savings.getRetireSavings() + savings.getHealthSavings();
    if (this instanceof IndividualFiler) {
      savingsDeduction *= 0.7;
    } else {
      savingsDeduction *= 0.65;
      if (savingsDeduction.compareTo(17500.0) > 0) {
        savingsDeduction = 17500.0;
      }
    }
    return (savingsDeduction < this.calculateBasicTaxableIncome()) ? savingsDeduction : 0;
  }

  public Double calculateHouseExpenseDeduction() {
    Double deduction = 0.0;
    HouseExpense houseExpense = this.taxMitigateExpense.getHouseExpense();
    Double houseExpenseAmount =
        houseExpense.getMortgageInterestPaid() + houseExpense.getPropertyTaxPaid();
    if (this.lastYearEarnings.compareTo(250000.0) < 0
        && houseExpenseAmount.compareTo(12500.0) > 0) {
      deduction = 2_500.0;
    }
    return deduction;
  }

  abstract public Double calculateTaxes();
}
