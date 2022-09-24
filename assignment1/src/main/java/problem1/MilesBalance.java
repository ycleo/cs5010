package problem1;

public class MilesBalance {

  private int milesAvailable = 0;
  private int milesEarnedThisYear = 0;
  private int milesExpireThisYear = 0;

  // get available balance
  public int getMilesAvailable() {
    return this.milesAvailable;
  }

  // get miles earned this year
  public int getMilesEarnedThisYear() {
    return this.milesEarnedThisYear;
  }

  // get miles Expiring this year
  public int getMilesExpireThisYear() {
    return this.milesExpireThisYear;
  }

  // increment available miles
  public void setMilesAvailable(int milesAmount) {
    this.milesAvailable = milesAmount;
  }

  public void setMilesEarnedThisYear(int milesEarnedThisYear) {
    this.milesEarnedThisYear = milesEarnedThisYear;
  }

  public void setMilesExpireThisYear(int milesExpireThisYear) {
    this.milesExpireThisYear = milesExpireThisYear;
  }
}


//  // set miles earned this year to zero
//  public void setMilesEarnedThisYearToZero() {
//    // this year passed -> set to zero
//    this.milesEarnedThisYear = 0;
//  }
//
//  // set miles expiring this year to zero
//  public void setMilesExpireThisYearToZero() {
//    // this year passed -> miles expires -> set to zero
//    this.milesExpireThisYear = 0;
//  }

