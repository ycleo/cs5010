package problem1;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class FlyersDatabase {

  // Hash map to store <account ID, frequent flyer>
  private static HashMap<String, FrequentFlyer> flyers = new HashMap<String, FrequentFlyer>();


  // add new registered flyer
  public static void addFlyer(FrequentFlyer flyer) {
    String flyerId = flyer.getAccountId();

    // check it is not in the flyers database
    if (!accountIdExists(flyerId)) {
      flyers.put(flyerId, flyer);
    } else {
      throw new NoSuchElementException("Account ID " + flyerId + " already exists!");
    }
  }

  // check the flyer exists by the accountId
  public static boolean accountIdExists(String accountId) { return flyers.containsKey(accountId); }

  // get the existing flyer
  public static FrequentFlyer getFlyer(String accountId) {
    return flyers.get(accountId);
  }

  public static void removeFlyer(String accountId) {
    flyers.remove(accountId);
  }
}

//  // generate new account ID
//  private static String generateAccountId() {
//    int length = 12;
//    Random random = new Random();
//
//    String accountId = random.ints(48, 123).limit(length)
//        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
//        .toString();
//    return accountId;
//  }
//
//  // give the new flyer an ID
//  public static String newAccountId() {
//    String newId = "0123456789ab"; // 12-char long
//    while (accountIdExists(newId)) {
//      newId = generateAccountId();
//    }
//    return newId;
//  }
