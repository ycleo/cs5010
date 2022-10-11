package problem3;

/**
 * Represents the interface for the TaxFiler class with methods including getTaxId(),
 * getContactInfo(), getLastYearEarnings(), getIncomeTaxPaid(), getTaxMitigateExpense(), and most
 * importantly calculateTaxes()
 *
 * @author Yi-Cheng Lee
 */
public interface TaxFilerInterface {

  /**
   * gets the tax ID
   *
   * @return the tax ID
   */
  String getTaxId();

  /**
   * gets the contact information
   *
   * @return the contact information
   */
  ContactInfo getContactInfo();

  /**
   * gets the last year's earnings
   *
   * @return the last year's earnings
   */
  Double getLastYearEarnings();

  /**
   * gets the total tax income already paid
   *
   * @return the total tax income already paid
   */
  Double getIncomeTaxPaid();

  /**
   * gets the expenses for tax mitigation
   *
   * @return the expenses for tax mitigation
   */
  TaxMitigateExpense getTaxMitigateExpense();

  /**
   * Calculates the tax amount (abstract method)
   *
   * @return the tax amount
   */
  Double calculateTaxes();
}


