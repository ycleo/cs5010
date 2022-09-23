package problem3;

public class DependentInfo {

  private Integer numDependents;
  private Integer numMinorChildren;
  private Double childcareExpense;
  private Double dependentCareExpense;

  public DependentInfo(Integer numDependents, Integer numMinorChildren, Double childrenExpense,
      Double dependentCareExpense) {
    this.numDependents = numDependents;
    this.numMinorChildren = numMinorChildren;
    this.childcareExpense = childrenExpense;
    this.dependentCareExpense = dependentCareExpense;
  }

  public Integer getNumDependents() {
    return this.numDependents;
  }

  public Integer getNumMinorChildren() {
    return this.numMinorChildren;
  }

  public Double getChildcareExpense() {
    return this.childcareExpense;
  }

  public Double getDependentCareExpense() {
    return this.dependentCareExpense;
  }

}
