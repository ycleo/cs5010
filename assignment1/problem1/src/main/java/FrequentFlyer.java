package assignment1.problem1;

import java.util.Random;

public class FrequentFlyer {

  private String accountId;
  private String name;
  private String email;
  private MilesBalance milesBalance;

  public FrequentFlyer(String name, String email) {
    // generate a new account ID
    String id = "000000000000"; // 12-char long
    while (FlyersDatabase.flyerExists(id)) {
      id = generateAccountId();
    }
    this.accountId = id;
    this.name = name;
    this.email = email;
    this.milesBalance = new MilesBalance();
  }

  // generate new account ID
  private String generateAccountId() {
    int length = 12;
    Random random = new Random();

    String accountId = random.ints(48, 123).limit(length)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
    return accountId;
  }

  // get flyer's account ID
  public String getAccountId() {
    return this.accountId;
  }

  // get flyer's name
  public String getName() {
    return this.name;
  }

  // get flyer's email
  public String getEmail() {
    return this.email;
  }

  // get flyer's miles balance
  public MilesBalance getMilesBalance() {
    return this.milesBalance;
  }

  // transfer miles to the other frequent flyer
  public void transferMiles(Deposit deposit) {
    // get the deposit info (miles amount, recipient ID, recipient name)
    int milesAmount = deposit.getMilesAmount();
    String recipientId = deposit.getRecipientId();

    // deposit availability check
    if (FlyersDatabase.flyerExists(recipientId) && deposit.idMatchesName()
        && deposit.depositMilesWithinRange() && this.milesBalance.enoughForDecrement(milesAmount)) {
      // get the frequent flyer (recipient)
      FrequentFlyer recipient = FlyersDatabase.getFlyer(recipientId);
      // add miles to the balance of the recipient
      recipient.milesBalance.incrementMiles(milesAmount);
      // deduct miles from the balance of the sender
      this.milesBalance.decrementMiles(milesAmount);
    }
  }
}
