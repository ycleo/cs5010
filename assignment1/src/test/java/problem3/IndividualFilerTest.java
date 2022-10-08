package problem3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IndividualFilerTest {

  private FilerType expectedFilerType;
  private ContactInfo testContactInfo;
  private TaxMitigateExpense testTaxMitigateExpense;
  private IndividualFiler testIndividualFiler;

  @BeforeEach
  void setUp() {
    expectedFilerType = FilerType.EMPLOYEE;
    testContactInfo = new ContactInfo(new Name("Tony", "Stark"), "111 great place",
        "6267770000", "iron@gmail.com");
    testTaxMitigateExpense = new TaxMitigateExpense(new Savings(80000.0, 600.0),
        new HouseExpense(13000.0, 600.0), new DependentExpense(900.0, 600.0), 2000.0, 250.0);
    testIndividualFiler = new IndividualFiler(testContactInfo, 600000.0, 60000.0,
        testTaxMitigateExpense);
  }

  @Test
  void getFilerType() {
    assertEquals(expectedFilerType, testIndividualFiler.getFilerType());
  }

  @Test
  void calculateSavingsDeduction() {
    Double expectedSavingsDeduction = (testTaxMitigateExpense.getSavings().getRetireSavings()
        + testTaxMitigateExpense.getSavings().getHealthSavings()) * 0.7;
    Double actualSavingsDeduction = testIndividualFiler.calculateSavingsDeduction();
    assertEquals(expectedSavingsDeduction, actualSavingsDeduction);
  }

  @Test
  void calculateTaxes() {
    Double expectedTaxes = (testIndividualFiler.calculateBasicTaxableIncome()
        - testIndividualFiler.calculateSavingsDeduction()
        - testIndividualFiler.calculateHouseExpenseDeduction()) * 0.19;
    Double actualTaxes = testIndividualFiler.calculateTaxes();
    assertEquals(expectedTaxes, actualTaxes);
  }
}
