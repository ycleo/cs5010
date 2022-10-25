package assignment3.problem1;

import static assignment3.problem1.StaticStrings.ABSOLUTE_PATH;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCSVLoader {

  private CSVLoader testCSVLoader;
  private CSVLoader testCSVLoader1;
  private Scanner expectedScanner;
  private String[] expectedInfoType;
  private List<List<String>> expectedCustomersInfo;

  @BeforeEach
  void setUp() throws FileNotFoundException {
    testCSVLoader = new CSVLoader("/csv&templates/insurance-company-members.csv");
    testCSVLoader1 = new CSVLoader("/csv&templates/insurance-company-members.csv");
    expectedScanner = testCSVLoader.getCSVScanner();
    expectedInfoType = testCSVLoader.getInfoType();
    expectedCustomersInfo = testCSVLoader.getCustomersInfo();
  }

  @Test
  void getCSVScanner() {
    assertEquals(expectedScanner, testCSVLoader.getCSVScanner());
  }

  @Test
  void getInfoType() {
    assertEquals(expectedInfoType, testCSVLoader.getInfoType());
  }

  @Test
  void getCustomersInfo() {
    assertEquals(expectedCustomersInfo, testCSVLoader.getCustomersInfo());
  }

  @Test
  void equals_SameObject() {
    assertTrue(testCSVLoader.equals(testCSVLoader));
  }

  @Test
  void equals_NullObject() {
    assertFalse(testCSVLoader.equals(null));
  }

  @Test
  void equals_DifferentObject() {
    assertFalse(testCSVLoader.equals(expectedInfoType));
  }

  @Test
  void equals_DifferentCommandScanner() throws FileNotFoundException {
    assertFalse(testCSVLoader.equals(testCSVLoader1));
  }

  @Test
  void equals_DifferentInfoType() {
    assertFalse(testCSVLoader.equals(testCSVLoader1));
  }

  @Test
  void equals_DifferentCustomersInfo() {
    assertFalse(testCSVLoader.equals(testCSVLoader1));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(testCSVLoader.getCSVScanner(), testCSVLoader.getInfoType(),
        testCSVLoader.getCustomersInfo());
    assertEquals(expectedHashCode, testCSVLoader.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "CommandParser: { "
        + "csv scanner: " + testCSVLoader.getCSVScanner()
        + "; information type: " + testCSVLoader.getInfoType()
        + "; customers' information: " + testCSVLoader.getCustomersInfo()
        + " }";
  }

}
