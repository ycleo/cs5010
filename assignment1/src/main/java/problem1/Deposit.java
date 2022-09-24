package problem1;

public class Deposit {

  private int milesAmount;
  private String recipientId;
  private Name recipientName;

  public Deposit(int milesAmount, String recipientId, Name recipientName) throws IllegalArgumentException{
    if (milesAmount >=  1000 && milesAmount <= 10000) {
      this.milesAmount = milesAmount;
      this.recipientId = recipientId;
      this.recipientName = recipientName;
    } else {
      throw new IllegalArgumentException("Deposit miles amount out of range (1,000 ~ 10,000).");
    }
  }

  public int getMilesAmount() {
    return this.milesAmount;
  }

  public String getRecipientId() {
    return this.recipientId;
  }

  public Name getRecipientName() {
    return this.recipientName;
  }
}

