package problem3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DependentExpenseTest {

  private Double expectedChildCareExpense;
  private Double expectedDependentCareExpense;
  private DependentExpense testDependentExpense;

  @BeforeEach
  void setUp() {
    expectedChildCareExpense = 900.123;
    expectedDependentCareExpense = 0.0;
    testDependentExpense = new DependentExpense(900.123, 0.0);
  }

  @Test
  void getChildCareExpense() {
    assertEquals(expectedChildCareExpense, testDependentExpense.getChildCareExpense());
  }

  @Test
  void getDependentCareExpense() {
    assertEquals(expectedDependentCareExpense, testDependentExpense.getDependentCareExpense());
  }
}
