package problem1;

import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * Represents the Flyer System with a static HashMap as the flyers database
 *
 * @author Yi-Cheng Lee
 */
public class FlyerSystem {

  // Hash map to store <account ID, frequent flyer>
  private static HashMap<String, FrequentFlyer> flyers = new HashMap<String, FrequentFlyer>();

  /**
   * checks the flyer exists by the accountId
   *
   * @param accountId the flyer's account ID
   * @return boolean result of the flyer's existence
   */
  public static boolean flyerExists(String accountId) {
    return flyers.containsKey(accountId);
  }

  /**
   * adds a new registered flyer
   *
   * @param flyer new registered flyer
   */
  public static void addFlyer(FrequentFlyer flyer) {
    String flyerId = flyer.getAccountId();

    // check it is not in the flyers database
    if (!flyerExists(flyerId)) {
      flyers.put(flyerId, flyer);
    } else {
      throw new NoSuchElementException("Account ID " + flyerId + " already exists!");
    }
  }

  /**
   * gets the flyer by account ID
   *
   * @param accountId the account ID
   * @return the flyer
   */
  public static FrequentFlyer getFlyer(String accountId) {
    return flyers.get(accountId);
  }

  /**
   * removes a certain flyer by the account ID
   *
   * @param accountId the account ID
   */
  public static void removeFlyer(String accountId) {
    flyers.remove(accountId);
  }
}