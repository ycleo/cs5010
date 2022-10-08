package problem3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GroupFilerTest {

  private FilerType expectedFilerType;
  private FilerType individualFilerType;
  private DependentInfo expectedDependentInfo;

  private ContactInfo testContactInfo;
  private TaxMitigateExpense testTaxMitigateExpense;
  private GroupFiler testGroupFiler;

  private Double testBasicTaxableIncome;

  @BeforeEach
  void setUp() {
    expectedFilerType = FilerType.HEAD_OF_THE_HOUSEHOLD;
    individualFilerType = FilerType.EMPLOYEE;
    expectedDependentInfo = new DependentInfo(6, 2, 5000.1, 6000.0);

    testContactInfo = new ContactInfo(new Name("Tony", "Stark"), "111 great place",
        "6267770000", "iron@gmail.com");
    testTaxMitigateExpense = new TaxMitigateExpense(new Savings(80000.0, 600.0),
        new HouseExpense(13000.0, 600.0), new DependentExpense(900.0, 600.0), 2000.0, 250.0);
    testGroupFiler = new GroupFiler(testContactInfo, 199999.9, 800.0, testTaxMitigateExpense,
        FilerType.HEAD_OF_THE_HOUSEHOLD, expectedDependentInfo);
    testBasicTaxableIncome = testGroupFiler.calculateBasicTaxableIncome();
  }

  @Test
  void constructorException() {
    Exception e = assertThrows(IllegalArgumentException.class, () -> {
      new GroupFiler(testContactInfo, 90000.0, 800.0, testTaxMitigateExpense,
          individualFilerType, expectedDependentInfo);
    });

    String expectedMessage = "Employee belongs to individual tax filer, not group tax filer.";
    String actualMessage = e.getMessage();
    assertEquals(actualMessage, expectedMessage);
  }

  @Test
  void getFilerType() {
    assertEquals(expectedFilerType, testGroupFiler.getFilerType());
  }

  @Test
  void getDependentInfo() {
    assertEquals(expectedDependentInfo, testGroupFiler.getDependentInfo());
  }

  @Test
  void calculateSavingsDeduction() {
    Double expectedSavingsDeduction = 17500.0;
    Double actualSavingsDeduction = testGroupFiler.calculateSavingsDeduction();

    assertEquals(expectedSavingsDeduction, actualSavingsDeduction);
  }

  @Test
  void calculateChildcareDeduction() {
    Double expectedChildcareDeduction = 1250.0;
    Double actualChildcareDeduction = testGroupFiler.calculateChildcareDeduction();

    assertEquals(expectedChildcareDeduction, actualChildcareDeduction);
  }

  @Test
  void calculateTaxes() {
    Double expectedTaxes =
        testBasicTaxableIncome - 17500.0 - testGroupFiler.calculateHouseExpenseDeduction() - 1250.0;
    expectedTaxes =
        (expectedTaxes.compareTo(90000.0) > 0) ? expectedTaxes * 0.185 : expectedTaxes * 0.145;
    Double actualTaxes = testGroupFiler.calculateTaxes();

    assertEquals(expectedTaxes, actualTaxes);
  }


}
