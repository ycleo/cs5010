package problem1;

import java.util.HashMap;
import java.util.Random;

public class FlyersDatabase {

  // Hash map to store <account ID, frequent flyer>
  private static HashMap<String, FrequentFlyer> flyers = new HashMap<String, FrequentFlyer>();

  // generate new account ID
  private static String generateAccountId() {
    int length = 12;
    Random random = new Random();

    String accountId = random.ints(48, 123).limit(length)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
    return accountId;
  }
  // give the new flyer an ID
  public static String newAccountId() {
    String newId = "0123456789ab"; // 12-char long
    while (flyerExists(newId)) {
      newId = generateAccountId();
    }
    return newId;
  }
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

