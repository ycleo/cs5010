package problem1;

/**
 * Represents the deposit transferring from one flyer to another one with information including
 * deposit miles amount, recipient ID, and recipient name
 *
 * @author Yi-Cheng Lee
 */
public class Deposit {

  private int milesAmount;
  private String recipientId;
  private Name recipientName;

  /**
   * Constructor for the class Deposit
   *
   * @param milesAmount   the deposit miles amount
   * @param recipientId   the recipient ID
   * @param recipientName the recipient name
   * @throws IllegalArgumentException exception when the miles amount out of range
   */
  public Deposit(int milesAmount, String recipientId, Name recipientName)
      throws IllegalArgumentException {
    if (milesAmount >= 1000 && milesAmount <= 10000) {
      this.milesAmount = milesAmount;
      this.recipientId = recipientId;
      this.recipientName = recipientName;
    } else {
      throw new IllegalArgumentException("Deposit miles amount out of range (1,000 ~ 10,000).");
    }
  }

  /**
   * gets the deposit miles amount
   *
   * @return the deposit miles amount
   */
  public int getMilesAmount() {
    return this.milesAmount;
  }

  /**
   * gets the recipient ID
   *
   * @return the recipient ID
   */
  public String getRecipientId() {
    return this.recipientId;
  }

  /**
   * gets the recipient name
   *
   * @return the recipient name
   */
  public Name getRecipientName() {
    return this.recipientName;
  }
}

