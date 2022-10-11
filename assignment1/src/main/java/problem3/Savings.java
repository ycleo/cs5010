package problem3;

/**
 * Represent the contributions made to the tax filer's savings account including retirement savings
 * and health savings
 *
 * @author Yi-Cheng Lee
 */
public class Savings {

  private Double retireSavings;
  private Double healthSavings;

  /**
   * Constructor for the class Savings
   *
   * @param retireSavings Contributions made to a retirement savings account
   * @param healthSavings Contributions made to a health savings account
   */
  public Savings(Double retireSavings, Double healthSavings) {
    this.retireSavings = retireSavings;
    this.healthSavings = healthSavings;
  }

  /**
   * gets the contribution made to a retirement savings account
   *
   * @return the contribution made to a retirement savings account
   */
  public Double getRetireSavings() {
    return this.retireSavings;
  }

  /**
   * gets the contribution made to a health savings account
   *
   * @return the contribution made to a health savings account
   */
  public Double getHealthSavings() {
    return this.healthSavings;
  }

}
