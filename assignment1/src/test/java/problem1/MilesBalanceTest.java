package problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MilesBalanceTest {

  private MilesBalance testMilesBalance;
  private int expectedMilesAvailable;
  private int expectedMilesEarnedThisYear;
  private int expectedMilesExpireThisYear;

  @BeforeEach
  void setUp() {
    expectedMilesAvailable = 1500;
    expectedMilesEarnedThisYear = 80000;
    expectedMilesExpireThisYear = 1500;
    testMilesBalance = new MilesBalance();
  }

  @Test
  void getMilesAvailable() {
    assertEquals(expectedMilesAvailable, 1500);
  }

  @Test
  void getMilesEarnedThisYear() {
    assertEquals(expectedMilesEarnedThisYear, 80000);
  }

  @Test
  void getMilesExpireThisYear() {
    assertEquals(expectedMilesExpireThisYear, 1500);
  }

  @Test
  void setMilesAvailable() {
    testMilesBalance.setMilesAvailable(1500);
    assertEquals(1500, testMilesBalance.getMilesAvailable());
  }

  @Test
  void setMilesEarnedThisYear() {
    testMilesBalance.setMilesEarnedThisYear(80000);
    assertEquals(80000, testMilesBalance.getMilesEarnedThisYear());
  }

  @Test
  void setExpectedMilesExpireThisYear() {
    testMilesBalance.setMilesExpireThisYear(1500);
    assertEquals(1500, testMilesBalance.getMilesExpireThisYear());
  }

}
