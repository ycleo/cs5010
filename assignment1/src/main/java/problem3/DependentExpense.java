package problem3;

/**
 * Represents the dependent expense of certain tax filer with his/her childcare expense and
 * dependent care expense
 *
 * @author Yi-Cheng Lee
 */
public class DependentExpense {

  private Double childCareExpense;
  private Double dependentCareExpense;

  /**
   * Constructor for class DependentExpense
   *
   * @param childCareExpense     the childcare expense of the tax filer
   * @param dependentCareExpense the dependent care expense of the tax filer
   */

  public DependentExpense(Double childCareExpense, Double dependentCareExpense) {
    this.childCareExpense = childCareExpense;
    this.dependentCareExpense = dependentCareExpense;
  }

  /**
   * gets the childcare expense of the tax filer
   *
   * @return the childcare expense of the tax filer
   */
  public Double getChildCareExpense() {
    return this.childCareExpense;
  }

  /**
   * gets the dependent care expense of the tax filer
   *
   * @return the dependent care expense of the tax filer
   */
  public Double getDependentCareExpense() {
    return this.dependentCareExpense;
  }
}
