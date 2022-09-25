package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FrequentFlyerTest {

  private FrequentFlyer testFlyer;
  private FrequentFlyer testFlyer1;
  private String expectedAccountId;
  private Name expectedName;
  private String expectedEmail;
  private MilesBalance expectedMilesBalance;
  private Name testName;

  @BeforeEach
  void setUp() throws IllegalArgumentException {
    expectedAccountId = "0123456789ab";
    expectedName = testName = new Name("YC", "Leo", "Lee");
    expectedEmail = "leo@neu.edu";
    testFlyer = new FrequentFlyer(expectedAccountId, expectedName, expectedEmail);
    expectedMilesBalance = testFlyer.getMilesBalance();
    FlyerSystem.addFlyer(testFlyer);

    testFlyer1 = new FrequentFlyer("987654321ab0", new Name("Tony", "Iron", "Stark"),
        "marvel@gmail.com");
    testFlyer1.getMilesBalance().setMilesAvailable(1500);
  }

  @Test
  void constructorException() {
    Exception e = assertThrows(IllegalArgumentException.class, () -> {
      new FrequentFlyer("0123", testName, "leo@neu.edu");
    });

    String expectedMessage = "Account ID must be 12 characters long!";
    String actualMessage = e.getMessage();
    assertTrue(actualMessage.equals(expectedMessage));
  }

  @Test
  void getAccountId() {
    assertEquals(expectedAccountId, testFlyer.getAccountId());
  }

  @Test
  void getName() {
    assertEquals(expectedName, testFlyer.getName());
  }

  @Test
  void getEmail() {
    assertEquals(expectedEmail, testFlyer.getEmail());
  }

  @Test
  void getMilesBalance() {
    assertEquals(expectedMilesBalance, testFlyer.getMilesBalance());
  }

  @Test
  void transferMiles() {
    Deposit testDeposit = new Deposit(1500, "0123456789ab", testName);
    testFlyer1.transferMiles(testDeposit);

    assertTrue(testFlyer.getMilesBalance().getMilesAvailable() == 1500
        && testFlyer1.getMilesBalance().getMilesAvailable() == 0);
  }

  @Test
  void recipientExistenceCheck() {
    Deposit testDepositRecipientNotExist = new Deposit(1500, "0", testName);

    Exception e = assertThrows(NoSuchElementException.class, () -> {
      testFlyer1.transferMiles(testDepositRecipientNotExist);
    });
    String expectedMessage = "Recipient doesn't exist!";
    String actualMessage = e.getMessage();

    assertTrue(actualMessage.equals(expectedMessage));
  }

  @Test
  void recipientIdMatchesNameCheck() {
    Deposit testDepositRecipientIdNotMatchName = new Deposit(1500, "0123456789ab",
        new Name("Steve", "Captain", "Rogers"));

    Exception e = assertThrows(SecurityException.class, () -> {
      testFlyer1.transferMiles(testDepositRecipientIdNotMatchName);
    });
    String expectedMessage = "Recipient's ID doesn't match recipient's name in the system!";
    String actualMessage = e.getMessage();

    assertTrue(actualMessage.equals(expectedMessage));
  }

  @Test
  void transferMilesAmountAvailabilityCheck() {
    Deposit testDepositGiverMilesNotAvailable = new Deposit(9999, "0123456789ab", testName);

    Exception e = assertThrows(IllegalArgumentException.class, () -> {
      testFlyer1.transferMiles(testDepositGiverMilesNotAvailable);
    });
    String expectedMessage = "Deposit miles amount exceeds giver's available miles amount.";
    String actualMessage = e.getMessage();

    assertTrue(actualMessage.equals(expectedMessage));
  }

  @AfterEach
  void afterEachTest() {
    FlyerSystem.removeFlyer(testFlyer.getAccountId());
  }
}
