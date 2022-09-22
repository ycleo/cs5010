public class GroupTaxFiler extends TaxFiler {

  public enum GroupType {MARRIED_FILE_JOINTLY, MARRIED_FILE_SEPARATELY, HEAD_HOUSEHOLD}

  private GroupType groupType;
  private Integer numDependents;
  private Integer numMinorChildren;
  private Double childrenExpense;
  private Double dependentCareExpense;

  public GroupTaxFiler(
      String taxId,
      ContactInfo contactInfo,
      Double lastYearIncome,
      Double incomeTaxPaid,
      Double mortgageInterestPaid,
      Double propertyTaxPaid,
      Double studentLoanTuitionPaid,
      Double retireSavings,
      Double healthSavings,
      Double charity,
      GroupType groupType,
      Integer numDependents,
      Integer numMinorChildren,
      Double childrenExpense,
      Double dependentCareExpense
  ) {
    super(
        taxId,
        contactInfo,
        lastYearIncome,
        incomeTaxPaid,
        mortgageInterestPaid,
        propertyTaxPaid,
        studentLoanTuitionPaid,
        retireSavings,
        healthSavings,
        charity);
    this.groupType = groupType;
    this.numDependents = numDependents;
    this.numMinorChildren = numMinorChildren;
    this.childrenExpense = childrenExpense;
    this.dependentCareExpense = dependentCareExpense;
  }

  public GroupType getGroupType() {
    return this.groupType;
  }

  public Integer getNumDependents() {
    return this.numDependents;
  }

  public Integer getNumMinorChildren() {
    return this.numMinorChildren;
  }

  public Double getChildrenExpense() {
    return this.childrenExpense;
  }

  public Double getDependentCareExpense() {
    return this.dependentCareExpense;
  }

  public Double childCareDeduction() {
    if (this.getLastYearIncome() < 200000 && this.getChildrenExpense() > 5000) {
      return 1250.0;
    } else {
      return 0.0;
    }
  }

  @Override
  public Double retireHealthDeduction() {
    Double amount = (this.getRetireSavings() + this.getHealthSavings()) * 0.65;
    if (amount > 17500.0) {
      amount = 17500.0;
    }
    return amount;
  }

  @Override
  public Double calculateTaxes() {
    Double basicTaxableIncome = this.getLastYearIncome() - this.getIncomeTaxPaid();
    Double retireHealthDeduction = this.retireHealthDeduction();
    Double mortgagePropertyDeduction = this.mortgagePropertyDeduction();
    Double childCareDeduction = this.childCareDeduction();

    Double taxableIncome =
        basicTaxableIncome - retireHealthDeduction - mortgagePropertyDeduction - childCareDeduction;
    taxableIncome = (taxableIncome > 0) ? taxableIncome : 0;

    return (taxableIncome < 90000) ? taxableIncome * 0.145 : taxableIncome * 0.185;
  }
}
