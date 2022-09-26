package problem1;

/**
 * Represents the miles balance information including total miles available, miles earned this year,
 * and miles expiring by the end of the year
 *
 * @author Yi-Cheng Lee
 */
public class MilesBalance {

  private int milesAvailable = 0;
  private int milesEarnedThisYear = 0;
  private int milesExpireThisYear = 0;

  /**
   * gets the total miles available
   *
   * @return the total miles available
   */
  public int getMilesAvailable() {
    return this.milesAvailable;
  }

  /**
   * gets the miles amount earned this year
   *
   * @return the miles amount earned this year
   */
  public int getMilesEarnedThisYear() {
    return this.milesEarnedThisYear;
  }

  /**
   * gets the miles expiring by the end of the year
   *
   * @return the miles expiring by the end of the year
   */
  public int getMilesExpireThisYear() {
    return this.milesExpireThisYear;
  }

  /**
   * sets the total miles available
   *
   * @param milesAmount the total miles available
   */
  public void setMilesAvailable(int milesAmount) {
    this.milesAvailable = milesAmount;
  }

  /**
   * sets the miles amount earned this year
   *
   * @param milesEarnedThisYear the miles amount earned this year
   */
  public void setMilesEarnedThisYear(int milesEarnedThisYear) {
    this.milesEarnedThisYear = milesEarnedThisYear;
  }

  /**
   * sets the miles expiring by the end of the year
   *
   * @param milesExpireThisYear the miles expiring by the end of the year
   */
  public void setMilesExpireThisYear(int milesExpireThisYear) {
    this.milesExpireThisYear = milesExpireThisYear;
  }
}

