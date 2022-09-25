package problem1;

import java.util.NoSuchElementException;

public class FrequentFlyer implements FrequentFlyerInterface {

  private String accountId;
  private Name name;
  private String email;
  private MilesBalance milesBalance;

  public FrequentFlyer(String accountId, Name name, String email) throws IllegalArgumentException {
    if (accountId.length() == 12) {
      this.accountId = accountId;
      this.name = name;
      this.email = email;
      this.milesBalance = new MilesBalance();
    } else {
      throw new IllegalArgumentException("Account ID must be 12 characters long!");
    }
  }

  // get flyer's account ID
  public String getAccountId() {
    return this.accountId;
  }

  // get flyer's name
  public Name getName() {
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
    // transfer pre-check
    recipientExistenceCheck(deposit);
    recipientIDMatchesNameCheck(deposit);
    transferMilesAmountAvailabilityCheck(deposit);

    // get the deposit info (miles amount, recipient)
    int depositMilesAmount = deposit.getMilesAmount();
    FrequentFlyer recipient = FlyerSystem.getFlyer(deposit.getRecipientId());
    // add miles to the balance of the recipient
    recipient.milesBalance.setMilesAvailable(
        recipient.getMilesBalance().getMilesAvailable() + depositMilesAmount);
    recipient.milesBalance.setMilesExpireThisYear(
        recipient.getMilesBalance().getMilesExpireThisYear() + depositMilesAmount);
    // deduct miles from the balance of the sender
    this.milesBalance.setMilesAvailable(
        this.getMilesBalance().getMilesAvailable() - depositMilesAmount);
    this.milesBalance.setMilesEarnedThisYear(
        this.getMilesBalance().getMilesEarnedThisYear() - depositMilesAmount);
    this.milesBalance.setMilesExpireThisYear(
        this.getMilesBalance().getMilesExpireThisYear() - depositMilesAmount);
  }

  protected void recipientExistenceCheck(Deposit deposit) {
    if (!FlyerSystem.flyerExists(deposit.getRecipientId())) {
      throw new NoSuchElementException("Recipient doesn't exist!");
    }

  }

  protected void recipientIDMatchesNameCheck(Deposit deposit) {
    // get the recipient ID and name (deposit info)
    String recipientId = deposit.getRecipientId();
    Name recipientName = deposit.getRecipientName();
    // fetch the flyer from the system by recipient ID
    FrequentFlyer flyer = FlyerSystem.getFlyer(recipientId);
    if (!recipientName.equals(flyer.getName())) {
      throw new SecurityException("Recipient's ID doesn't match recipient's name in the system!");
    }
  }

  protected void transferMilesAmountAvailabilityCheck(Deposit deposit) {
    int giverAvailableMiles = this.getMilesBalance().getMilesAvailable();
    int depositMilesAmount = deposit.getMilesAmount();
    if (giverAvailableMiles < depositMilesAmount) {
      throw new IllegalArgumentException(
          "Deposit miles amount exceeds giver's available miles amount.");
    }
  }
}

