package problem3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaxFilerTest {

  private String expectedTaxId;
  private ContactInfo expectedContactInfo;
  private Double expectedLastYearEarnings;
  private Double expectedIncomeTaxPaid;
  private TaxMitigateExpense expectedTaxMitigateExpense;
  private Double expectedBasicTaxableIncome;
  private Double expectedHouseExpenseDeduction;
  private TaxFiler testTaxFiler;


  @BeforeEach
  void setUp() {
    expectedContactInfo = new ContactInfo(new Name("Tony", "Stark"), "111 great place",
        "6267770000", "iron@gmail.com");
    expectedLastYearEarnings = 90000.0;
    expectedIncomeTaxPaid = 800.0;
    expectedTaxMitigateExpense = new TaxMitigateExpense(new Savings(900.0, 600.0),
        new HouseExpense(13000.0, 600.0), new DependentExpense(900.0, 600.0), 2000.0, 250.0);
    testTaxFiler = new IndividualFiler(expectedContactInfo, expectedLastYearEarnings,
        expectedIncomeTaxPaid, expectedTaxMitigateExpense);
    expectedTaxId = testTaxFiler.getTaxId();
    expectedBasicTaxableIncome = 90000.0 - 800.0;
    expectedHouseExpenseDeduction = 2500.0;
  }

  @Test
  void getTaxId() {
    assertEquals(expectedTaxId, testTaxFiler.getTaxId());
  }

  @Test
  void getContactInfo() {
    assertEquals(expectedContactInfo, testTaxFiler.getContactInfo());
  }

  @Test
  void getLastYearEarnings() {
    assertEquals(expectedLastYearEarnings, testTaxFiler.getLastYearEarnings());
  }

  @Test
  void getIncomeTaxPaid() {
    assertEquals(expectedIncomeTaxPaid, testTaxFiler.incomeTaxPaid);
  }

  @Test
  void getTaxMitigateExpense() {
    assertEquals(expectedTaxMitigateExpense, testTaxFiler.getTaxMitigateExpense());
  }

  @Test
  void calculateBasicTaxableIncome() {
    assertEquals(expectedBasicTaxableIncome, testTaxFiler.calculateBasicTaxableIncome());
  }

  @Test
  void calculateHouseExpenseDeduction() {
    assertEquals(expectedHouseExpenseDeduction, testTaxFiler.calculateHouseExpenseDeduction());
  }

  @Test
  void calculateHouseExpenseDeduction_GoodLastYearEarnings() {
    expectedLastYearEarnings = 300000.0;
    testTaxFiler = new IndividualFiler(expectedContactInfo, expectedLastYearEarnings,
        expectedIncomeTaxPaid, expectedTaxMitigateExpense);
    assertEquals(0.0, testTaxFiler.calculateHouseExpenseDeduction());
  }

  @Test
  void calculateHouseExpenseDeduction_LowHouseExpenseAmount() {
    expectedTaxMitigateExpense = new TaxMitigateExpense(new Savings(900.0, 600.0),
        new HouseExpense(0.0, 600.0), new DependentExpense(900.0, 600.0), 2000.0, 250.0);
    testTaxFiler = new IndividualFiler(expectedContactInfo, expectedLastYearEarnings,
        expectedIncomeTaxPaid, expectedTaxMitigateExpense);
    assertEquals(0.0, testTaxFiler.calculateHouseExpenseDeduction());
  }
}
