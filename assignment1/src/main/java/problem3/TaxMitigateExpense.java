package problem3;

/**
 * Represents the expenses for tax mitigation including contributions made to savings, house related
 * expense paid, expense for dependents, student loan and tuition paid, and charitable donations
 *
 * @author Yi-Cheng Lee
 */
public class TaxMitigateExpense {

  private Savings savings;
  private HouseExpense houseExpense;
  private DependentExpense dependentExpense;
  private Double studentDebtExpense;
  private Double charity;

  /**
   * Constructor for the class TaxMitigateExpense
   *
   * @param savings          the contributions made to savings
   * @param houseExpense     the house related expense paid
   * @param dependentExpense the dependent expense paid
   * @param studentDebtPaid  the student loan and tuition paid
   * @param charity          the charitable donations and contributions
   */
  public TaxMitigateExpense(Savings savings, HouseExpense houseExpense,
      DependentExpense dependentExpense, Double studentDebtPaid, Double charity) {
    this.savings = savings;
    this.houseExpense = houseExpense;
    this.dependentExpense = dependentExpense;
    this.studentDebtExpense = studentDebtPaid;
    this.charity = charity;
  }

  /**
   * gets the contributions made to savings
   *
   * @return the contributions made to savings
   */
  public Savings getSavings() {
    return this.savings;
  }

  /**
   * gets the house related expense paid
   *
   * @return the house related expense paid
   */
  public HouseExpense getHouseExpense() {
    return this.houseExpense;
  }

  /**
   * gets the dependent expense paid
   *
   * @return the dependent expense paid
   */
  public DependentExpense getDependentExpense() {
    return this.dependentExpense;
  }

  /**
   * gets the student loan and tuition paid
   *
   * @return the student loan and tuition paid
   */
  public Double getStudentDebtExpense() {
    return this.studentDebtExpense;
  }

  /**
   * gets the charitable donations and contributions
   *
   * @return the charitable donations and contributions
   */
  public Double getCharity() {
    return this.charity;
  }

}
