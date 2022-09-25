package problem3;

import java.util.UUID;

public abstract class TaxFiler implements TaxFilerInterface {

  protected String taxId;
  protected ContactInfo contactInfo;
  protected Double lastYearEarnings;
  protected Double incomeTaxPaid;
  protected TaxMitigateExpense taxMitigateExpense;

  public TaxFiler(ContactInfo contactInfo, Double lastYearEarnings,
      Double incomeTaxPaid, TaxMitigateExpense taxMitigateExpense) {
    this.taxId = UUID.randomUUID().toString();
    this.contactInfo = contactInfo;
    this.lastYearEarnings = lastYearEarnings;
    this.incomeTaxPaid = incomeTaxPaid;
    this.taxMitigateExpense = taxMitigateExpense;
  }

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

  public Double calculateHouseExpenseDeduction() {
    Double deduction = 0.0;
    HouseExpense houseExpense = this.taxMitigateExpense.getHouseExpense();
    Double houseExpenseAmount =
        houseExpense.getMortgageInterestPaid() + houseExpense.getPropertyTaxPaid();
    if (this.lastYearEarnings.compareTo(250000.0) < 0
        && houseExpenseAmount.compareTo(12500.0) > 0) {
      deduction = 2500.0;
    }
    return deduction;
  }

  public abstract Double calculateTaxes();
}
