package problem3;

public class TaxMitigateExpense {

  private Savings savings;
  private HouseExpense houseExpense;
  private DependentExpense dependentExpense;
  private Double studentDebtExpense;
  private Double charity;

  public TaxMitigateExpense(Savings savings, HouseExpense houseExpense,
      DependentExpense dependentExpense, Double studentDebtPaid, Double charity) {
    this.savings = savings;
    this.houseExpense = houseExpense;
    this.dependentExpense = dependentExpense;
    this.studentDebtExpense = studentDebtPaid;
    this.charity = charity;
  }

  public Savings getSavings() {
    return this.savings;
  }

  public HouseExpense getHouseExpense() {
    return this.houseExpense;
  }

  public DependentExpense getDependentExpense() {
    return this.dependentExpense;
  }

  public Double getStudentDebtExpense() {
    return this.studentDebtExpense;
  }

  public Double getCharity() {
    return this.charity;
  }

}
