package problem3;

public class IndividualFiler extends TaxFiler {

  public IndividualFiler(FilerType filerType, String taxId, ContactInfo contactInfo, Double lastYearEarnings,
      Double incomeTaxPaid, TaxMitigateExpense taxMitigateExpense) {
    this.filerType = filerType;
    this.taxId = taxId;
    this.lastYearEarnings = lastYearEarnings;
    this.incomeTaxPaid = incomeTaxPaid;
    this.taxMitigateExpense = taxMitigateExpense;
  }

  public Double calculateTaxes() {
    Double basicTaxableIncome = this.calculateBasicTaxableIncome();
    Double savingsDeduction = this.calculateSavingsDeduction();
    Double houseExpenseDeduction = this.calculateHouseExpenseDeduction();
    Double taxAmount = basicTaxableIncome - savingsDeduction - houseExpenseDeduction;
    return (taxAmount.compareTo(55000.0) > 0) ? taxAmount * 0.19 : taxAmount * 0.15;
  }
}
