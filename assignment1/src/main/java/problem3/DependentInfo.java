package problem3;

/**
 * Represents the dependent information of a certain group filer with the number of dependents,
 * minor children and the expense of childcare and dependent care
 *
 * @author Yi-Cheng Lee
 */
public class DependentInfo {

  private Integer numDependents;
  private Integer numMinorChildren;
  private Double childcareExpense;
  private Double dependentCareExpense;

  /**
   * Constructor for class DependentInfo
   *
   * @param numDependents        the number of dependents
   * @param numMinorChildren     the number of minor children
   * @param childrenExpense      the childcare expense
   * @param dependentCareExpense the dependent care expense
   */
  public DependentInfo(Integer numDependents, Integer numMinorChildren, Double childrenExpense,
      Double dependentCareExpense) {
    this.numDependents = numDependents;
    this.numMinorChildren = numMinorChildren;
    this.childcareExpense = childrenExpense;
    this.dependentCareExpense = dependentCareExpense;
  }

  /**
   * gets the number of dependents
   *
   * @return the number of dependents
   */

  public Integer getNumDependents() {
    return this.numDependents;
  }

  /**
   * gets the number of minor children
   *
   * @return the number of minor children
   */
  public Integer getNumMinorChildren() {
    return this.numMinorChildren;
  }

  /**
   * gets the childcare expense
   *
   * @return the childcare expense
   */
  public Double getChildcareExpense() {
    return this.childcareExpense;
  }

  /**
   * gets the dependent care expense
   *
   * @return the dependent care expense
   */
  public Double getDependentCareExpense() {
    return this.dependentCareExpense;
  }

}
