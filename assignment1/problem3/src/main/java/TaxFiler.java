public class TaxFiler {

  private String taxId;
  private ContactInfo contactInfo;
  private Double lastYearIncome;
  private Double incomeTaxPaid;
  private Double mortgageInterestPaid;
  private Double propertyTaxPaid;
  private Double studentLoanTuitionPaid;
  private Double retireSavings;
  private Double healthSavings;
  private Double charity;

  public TaxFiler(
      String taxId,
      ContactInfo contactInfo,
      Double lastYearIncome,
      Double incomeTaxPaid,
      Double mortgageInterestPaid,
      Double propertyTaxPaid,
      Double studentLoanTuitionPaid,
      Double retireSavings,
      Double healthSavings,
      Double charity) {
    this.taxId = taxId;
    this.contactInfo = contactInfo;
    this.lastYearIncome = lastYearIncome;
    this.incomeTaxPaid = incomeTaxPaid;
    this.mortgageInterestPaid = mortgageInterestPaid;
    this.propertyTaxPaid = propertyTaxPaid;
    this.studentLoanTuitionPaid = studentLoanTuitionPaid;
    this.retireSavings = retireSavings;
    this.healthSavings = healthSavings;
    this.charity = charity;
  }

  public String getTaxId() {
    return this.taxId;
  }

  public ContactInfo getContactInfo() {
    return this.contactInfo;
  }

  public Double getLastYearIncome() {
    return this.lastYearIncome;
  }

  public Double getIncomeTaxPaid() {
    return this.incomeTaxPaid;
  }

  public Double getMortgageInterestPaid() {
    return this.mortgageInterestPaid;
  }

  public Double getPropertyTaxPaid() {
    return this.propertyTaxPaid;
  }

  public Double getStudentLoanTuitionPaid() {
    return this.studentLoanTuitionPaid;
  }

  public Double getRetireSavings() {
    return this.retireSavings;
  }

  public Double getHealthSavings() {
    return this.healthSavings;
  }

  public Double getCharity() {
    return this.charity;
  }

  public Double retireHealthDeduction() {
    return (this.getRetireSavings() + this.getHealthSavings()) * 0.7;
  }

  public Double mortgagePropertyDeduction() {
    if (this.getLastYearIncome() < 250000
        && (this.getMortgageInterestPaid() + this.getPropertyTaxPaid()) > 12500) {
      return 2500.0;
    } else {
      return 0.0;
    }
  }

  public Double calculateTaxes() {
    Double basicTaxableIncome = this.getLastYearIncome() - this.getIncomeTaxPaid();
    Double retireHealthDeduction = this.retireHealthDeduction();
    Double mortgagePropertyDeduction = this.mortgagePropertyDeduction();

    Double taxableIncome = basicTaxableIncome - retireHealthDeduction - mortgagePropertyDeduction;
    taxableIncome = (taxableIncome > 0) ? taxableIncome : 0;

    return (taxableIncome < 55000) ? taxableIncome * 0.15 : taxableIncome * 0.19;
  }
}
