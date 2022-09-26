package problem3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaxMitigateExpenseTest {

  private Savings expectedSavings;
  private HouseExpense expectedHouseExpense;
  private DependentExpense expectedDependentExpense;
  private Double expectedStudentDebtExpense;
  private Double expectedCharity;
  private TaxMitigateExpense testTaxMitigateExpense;

  @BeforeEach
  void setUp() {
    expectedSavings = new Savings(900.0, 800.0);
    expectedHouseExpense = new HouseExpense(650.33, 590.5);
    expectedDependentExpense = new DependentExpense(95.2, 55.88);
    expectedStudentDebtExpense = 570.0;
    expectedCharity = 1.1;
    testTaxMitigateExpense = new TaxMitigateExpense(new Savings(900.0, 800.0),
        new HouseExpense(650.33, 590.5), new DependentExpense(95.2, 55.88), 570.0, 1.1);
  }

  @Test
  void getSavings() {
    Savings actualSavings = testTaxMitigateExpense.getSavings();
    Double actualRetireSavings = actualSavings.getRetireSavings();
    Double actualHealthSavings = actualSavings.getHealthSavings();
    assertTrue(expectedSavings.getRetireSavings().equals(actualRetireSavings)
        && expectedSavings.getHealthSavings().equals(actualHealthSavings));
  }

  @Test
  void getHouseExpense() {
    HouseExpense actualHouseExpense = testTaxMitigateExpense.getHouseExpense();
    Double actualMortgageInterestPaid = actualHouseExpense.getMortgageInterestPaid();
    Double actualPropertyTaxPaid = actualHouseExpense.getPropertyTaxPaid();
    assertTrue(expectedHouseExpense.getMortgageInterestPaid().equals(actualMortgageInterestPaid)
        && expectedHouseExpense.getPropertyTaxPaid().equals(actualPropertyTaxPaid));
  }

  @Test
  void getDependentExpense() {
    DependentExpense actualDependentExpense = testTaxMitigateExpense.getDependentExpense();
    Double actualChildCareExpense = actualDependentExpense.getChildCareExpense();
    Double actualDependentCareExpense = actualDependentExpense.getDependentCareExpense();
    assertTrue(expectedDependentExpense.getChildCareExpense().equals(actualChildCareExpense)
        && expectedDependentExpense.getDependentCareExpense().equals(actualDependentCareExpense));
  }

  @Test
  void getStudentDebtExpense() {
    assertEquals(expectedStudentDebtExpense, testTaxMitigateExpense.getStudentDebtExpense());
  }

  @Test
  void getCharity() {
    assertEquals(expectedCharity, testTaxMitigateExpense.getCharity());
  }

}
