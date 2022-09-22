package assignment1.problem1;

import java.util.HashMap;

public class FlyersDatabase {

  // Hash map to store <account ID, frequent flyer>
  private static HashMap<String, FrequentFlyer> flyers = new HashMap<String, FrequentFlyer>();

  // add new registered flyer
  public static void addFlyer(String name, String email) {
    FrequentFlyer newFlyer = new FrequentFlyer(name, email);
    flyers.put(newFlyer.getAccountId(), newFlyer);
  }

  // check the flyer exists by the accountId
  public static boolean flyerExists(String accountId) {
    if (flyers.containsKey(accountId)) {
      return true;
    } else {
      System.out.println("This flyer does not exist...");
      return false;
    }
  }

  // get the existing flyer
  public static FrequentFlyer getFlyer(String accountId) {
    return flyers.get(accountId);
  }
}
