package problem3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DependentInfoTest {

  private Integer expectedNumDependents;
  private Integer expectedNumMinorChildren;
  private Double expectedChildcareExpense;
  private Double expectedDependentCareExpense;
  private DependentInfo testDependentInfo;

  @BeforeEach
  void setUp() {
    expectedNumDependents = 3;
    expectedNumMinorChildren = 2;
    expectedChildcareExpense = 5000.0;
    expectedDependentCareExpense = 8000.0;
    testDependentInfo = new DependentInfo(3, 2, 5000.0, 8000.0);
  }

  @Test
  void getNumDependents() {
    assertEquals(expectedNumDependents, testDependentInfo.getNumDependents());
  }

  @Test
  void getNumMinorChildren() {
    assertEquals(expectedNumMinorChildren, testDependentInfo.getNumMinorChildren());
  }

  @Test
  void getChildcareExpense() {
    assertEquals(expectedChildcareExpense, testDependentInfo.getChildcareExpense());
  }

  @Test
  void getDependentCareExpense() {
    assertEquals(expectedDependentCareExpense, testDependentInfo.getDependentCareExpense());
  }

}
