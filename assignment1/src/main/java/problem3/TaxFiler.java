package problem3;

import java.util.UUID;

/**
 * Represents a tax filer with the tax ID, contact information, last year's earnings, Total income
 * tax already paid, all expenses for tax mitigation
 */
public abstract class TaxFiler implements TaxFilerInterface {

  /**
   * the tax ID
   */
  protected String taxId;
  /**
   * the contact information
   */
  protected ContactInfo contactInfo;
  /**
   * the last year's earnings
   */
  protected Double lastYearEarnings;
  /**
   * the total tax income already paid
   */
  protected Double incomeTaxPaid;
  /**
   * the expenses for tax mitigation
   */
  protected TaxMitigateExpense taxMitigateExpense;

  /**
   * Constructor for the class TaxFiler (the tax ID property will be automatically generated as a
   * UUID for a new TaxFiler)
   *
   * @param contactInfo        the contact information
   * @param lastYearEarnings   the last year's earnings
   * @param incomeTaxPaid      the total tax income already paid
   * @param taxMitigateExpense the expenses for tax mitigation
   */
  public TaxFiler(ContactInfo contactInfo, Double lastYearEarnings,
      Double incomeTaxPaid, TaxMitigateExpense taxMitigateExpense) {
    this.taxId = UUID.randomUUID().toString();
    this.contactInfo = contactInfo;
    this.lastYearEarnings = lastYearEarnings;
    this.incomeTaxPaid = incomeTaxPaid;
    this.taxMitigateExpense = taxMitigateExpense;
  }

  /**
   * gets the tax ID
   *
   * @return the tax ID
   */
  public String getTaxId() {
    return this.taxId;
  }

  /**
   * gets the contact information
   *
   * @return the contact information
   */
  public ContactInfo getContactInfo() {
    return this.contactInfo;
  }

  /**
   * gets the last year's earnings
   *
   * @return the last year's earnings
   */
  public Double getLastYearEarnings() {
    return this.lastYearEarnings;
  }

  /**
   * gets the total tax income already paid
   *
   * @return the total tax income already paid
   */
  public Double getIncomeTaxPaid() {
    return this.incomeTaxPaid;
  }

  /**
   * gets the expenses for tax mitigation
   *
   * @return the expenses for tax mitigation
   */
  public TaxMitigateExpense getTaxMitigateExpense() {
    return this.taxMitigateExpense;
  }

  /**
   * Calculates the basic taxable income
   *
   * @return the basic taxable income
   */
  public Double calculateBasicTaxableIncome() {
    return this.getLastYearEarnings() - this.getIncomeTaxPaid();
  }

  /**
   * Calculates the house expense deduction
   *
   * @return the house expense deduction
   */
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

  /**
   * Calculates the tax amount (abstract method)
   *
   * @return the tax amount
   */
  public abstract Double calculateTaxes();
}
