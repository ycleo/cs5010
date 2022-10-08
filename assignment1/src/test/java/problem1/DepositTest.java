package problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DepositTest {

  private int expectedMilesAmount;
  private String expectedRecipientId;
  private Name expectedRecipientName;
  private Name testName;

  @BeforeEach
  void setUp() {
    expectedMilesAmount = 1200;
    expectedRecipientId = "0123456789ab";
    expectedRecipientName = testName = new Name("YC", "Leo", "Lee");
  }

  @Test
  void constructorException() {
    Exception e = assertThrows(IllegalArgumentException.class, () -> {
      new Deposit(10, "0123456789ab", expectedRecipientName);
    });
    String expectedMessage = "Deposit miles amount out of range (1,000 ~ 10,000).";
    String actualMessage = e.getMessage();
    assertEquals(actualMessage, expectedMessage);
  }

  @Test
  void getMilesAmount() {
    assertEquals(expectedMilesAmount, 1200);
  }

  @Test
  void getRecipientId() {
    assertEquals(expectedRecipientId, "0123456789ab");
  }

  @Test
  void getRecipientName() {
    assertEquals(expectedRecipientName, testName);
  }
}
