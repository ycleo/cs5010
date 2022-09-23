package problem3;

public interface TaxFilerInterface {

  String getTaxId();

  ContactInfo getContactInfo();

  Double getLastYearEarnings();

  Double getIncomeTaxPaid();

  TaxMitigateExpense getTaxMitigateExpense();

  Double calculateTaxes();
}


