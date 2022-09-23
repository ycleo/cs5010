package problem3;

public class DependentExpense {

  private Double childCareExpense;
  private Double dependentCareExpense;

  public DependentExpense(Double childCareExpense, Double dependentCareExpense) {
    this.childCareExpense = childCareExpense;
    this.dependentCareExpense = dependentCareExpense;
  }

  public Double getChildCareExpense() {
    return this.childCareExpense;
  }

  public Double getDependentCareExpense() {
    return this.dependentCareExpense;
  }
}
