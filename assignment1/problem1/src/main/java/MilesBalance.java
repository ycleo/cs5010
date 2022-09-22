package assignment1.problem1;

public class MilesBalance {

  private int milesAvailable = 0;
  private int milesEarnedThisYear = 0;
  private int milesExpireThisYear = 0;

  public MilesBalance() {
  }

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
  public void incrementMiles(int milesAmount) {
    this.milesAvailable += milesAmount;
    this.milesEarnedThisYear += milesAmount;
    this.milesExpireThisYear += milesAmount;
  }

  // check available miles is enough for decrement
  public boolean enoughForDecrement(int milesAmount) {
    if (this.milesAvailable >= milesAmount) {
      return true;
    } else {
      System.out.println("The flyer has not enough miles to deduct...");
      return false;
    }
  }

  // decrement available miles
  public void decrementMiles(int milesAmount) {
    // decrement available miles
    this.milesAvailable -= milesAmount;
    this.milesExpireThisYear -= milesAmount;
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
}
