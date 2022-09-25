package problem3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class HouseExpenseTest {
  private Double expectedMortgageInterestPaid;
  private Double expectedPropertyTaxPaid;
  private HouseExpense testHouseExpense;

  @BeforeEach
  void setUp() {
    expectedMortgageInterestPaid = 5600.32;
    expectedPropertyTaxPaid = 0.0;
    testHouseExpense = new HouseExpense(5600.32, 0.0);
  }
  @Test
  void getMortgageInterestPaid() {
    assertEquals(expectedMortgageInterestPaid, testHouseExpense.getMortgageInterestPaid());
  }

  @Test
  void getPropertyTaxPaid() {
    assertEquals(expectedPropertyTaxPaid, testHouseExpense.getPropertyTaxPaid());
  }

}
