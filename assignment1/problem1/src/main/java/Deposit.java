package assignment1.problem1;

public class Deposit {

  private int milesAmount;
  private String recipientId;
  private String recipientName;

  public Deposit(int milesAmount, String recipientId, String recipientName) {
    this.milesAmount = milesAmount;
    this.recipientId = recipientId;
    this.recipientName = recipientName;
  }

  public int getMilesAmount() {
    return this.milesAmount;
  }

  public String getRecipientId() {
    return this.recipientId;
  }

  public String getRecipientName() {
    return this.recipientName;
  }

  // check the recipient ID matches recipient's name
  public boolean idMatchesName() {
    // get the recipient ID and name (deposit info)
    String recipientId = this.getRecipientId();
    String recipientName = this.getRecipientName();
    // fetch the flyer from the system by recipient ID
    FrequentFlyer flyer = FlyersDatabase.getFlyer(recipientId);

    // check the frequent flyer's name matches the recipient's name
    if (recipientName.equals(flyer.getName())) {
      return true;
    } else {
      System.out.println("The recipient's ID does not match the recipient's name.");
      return false;
    }
  }

  // check the transfer miles are within the range
  public boolean depositMilesWithinRange() {
    if (this.milesAmount >= 1000 && this.milesAmount <= 10000) {
      return true;
    } else {
      System.out.println("Deposit miles amount should be within 1000 ~ 10000.");
      return false;
    }
  }
}
