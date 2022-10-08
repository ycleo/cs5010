package problem3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SavingsTest {

  private Double expectedRetireSavings;
  private Double expectedHealthSavings;
  private Savings testSavings;

  @BeforeEach
  void setUp() {
    expectedRetireSavings = 950000.0;
    expectedHealthSavings = 1000000.5;
    testSavings = new Savings(950000.0, 1000000.5);
  }

  @Test
  void getRetireSavings() {
    assertEquals(expectedRetireSavings, testSavings.getRetireSavings());
  }

  @Test
  void getHealthSavings() {
    assertEquals(expectedHealthSavings, testSavings.getHealthSavings());
  }
}
