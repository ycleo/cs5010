package problem1;

/**
 * Represents the interface for the FrequentFlyer class with methods including getAccountId(),
 * getName(), getEmail(), getMilesBalance(), and transferMiles(Deposit deposit)
 *
 * @author Yi-Cheng Lee
 */
public interface FrequentFlyerInterface {

  /**
   * gets the account ID
   *
   * @return the account ID
   */
  String getAccountId();

  /**
   * gets the name
   *
   * @return the name
   */
  Name getName();

  /**
   * gets the email address
   *
   * @return the email address
   */
  String getEmail();

  /**
   * gets the miles balance
   *
   * @return the miles balance
   */
  MilesBalance getMilesBalance();

  /**
   * transfers miles to the other flyer
   *
   * @param deposit transfer or deposit information
   */
  void transferMiles(Deposit deposit);
}
