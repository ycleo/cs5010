package problem3;

public class IndividualFiler extends TaxFiler {

  private FilerType filerType;

  public IndividualFiler(ContactInfo contactInfo, Double lastYearEarnings,
      Double incomeTaxPaid, TaxMitigateExpense taxMitigateExpense) {
    super(contactInfo, lastYearEarnings, incomeTaxPaid, taxMitigateExpense);
    this.filerType = FilerType.EMPLOYEE;
  }

  public FilerType getFilerType() {
    return this.filerType;
  }

  public Double calculateSavingsDeduction() {
    Savings savings = this.getTaxMitigateExpense().getSavings();
    Double savingsDeduction =
        (savings.getRetireSavings() + savings.getHealthSavings())
            * 0.7;
    return (savingsDeduction < this.calculateBasicTaxableIncome()) ? savingsDeduction
        : Double.valueOf(0.0);
  }


  public Double calculateTaxes() {
    Double basicTaxableIncome = this.calculateBasicTaxableIncome();
    Double savingsDeduction = this.calculateSavingsDeduction();
    Double houseExpenseDeduction = this.calculateHouseExpenseDeduction();
    Double taxAmount = basicTaxableIncome - savingsDeduction - houseExpenseDeduction;
    return (taxAmount.compareTo(55000.0) > 0) ? taxAmount * 0.19 : taxAmount * 0.15;
  }
}
