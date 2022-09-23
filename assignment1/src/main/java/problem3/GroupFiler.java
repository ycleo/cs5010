package problem3;

public class GroupFiler extends TaxFiler {

  private DependentInfo dependentInfo;

  public GroupFiler(FilerType filerType, String taxId, ContactInfo contactInfo, Double lastYearEarnings,
      Double incomeTaxPaid, TaxMitigateExpense taxMitigateExpense, DependentInfo dependentInfo) {
    this.filerType = filerType;
    this.taxId = taxId;
    this.lastYearEarnings = lastYearEarnings;
    this.incomeTaxPaid = incomeTaxPaid;
    this.taxMitigateExpense = taxMitigateExpense;
    this.dependentInfo = dependentInfo;
  }

  public DependentInfo getDependentInfo() {
    return this.dependentInfo;
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
