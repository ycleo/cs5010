package problem3;

public class GroupFiler extends TaxFiler {

  private FilerType filerType;
  private DependentInfo dependentInfo;

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

  public FilerType getFilerType() {
    return this.filerType;
  }

  public DependentInfo getDependentInfo() {
    return this.dependentInfo;
  }

  public Double calculateSavingsDeduction() {
    Savings savings = this.getTaxMitigateExpense().getSavings();
    Double savingsDeduction = (savings.getRetireSavings() + savings.getHealthSavings()) * 0.65;
    if (savingsDeduction.compareTo(17500.0) > 0) {
      savingsDeduction = 17500.0;
    }

    return (savingsDeduction < this.calculateBasicTaxableIncome()) ? savingsDeduction : Double.valueOf(0.0);
  }
  public Double calculateChildcareDeduction() {
    Double childcareDeduction = 0.0;
    Double childcareExpense = this.getDependentInfo().getChildcareExpense();
    if (this.getLastYearEarnings().compareTo(200000.0) < 0
        && childcareExpense.compareTo(5000.0) > 0) {
      childcareDeduction = 1250.0;
    }
    return childcareDeduction;
  }

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
