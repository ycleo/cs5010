package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for class Name. Note: this class contains an example of how to test methods equals()
 * and hashCode().
 */
class TestName {

  private Name testName;
  private Name testName2;
  private String expectedFirstName;
  private String expectedLastName;

  private int expectedHashCode;

  @BeforeEach
  void setUp() {
    testName = new Name("Cersei", "Lannister");
    testName2 = new Name("Cersei", "Lannister");
    expectedFirstName = "Cersei";
    expectedLastName = "Lannister";
    expectedHashCode = Objects.hash(expectedFirstName, expectedLastName);
  }

  @Test
  void getFirstName() {
    assertEquals(expectedFirstName, testName.getFirstName());

  }

  @Test
  void getLastName() {
    assertEquals(expectedLastName, testName.getLastName());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testName.equals(testName));
  }

  @Test
  void testEquals_Null() {
    assertFalse(testName.equals(null));
  }

  @Test
  void testEquals_DifferentDataTypes() {
    assertFalse(testName.equals(expectedFirstName));
  }

  @Test
  void testEquals_DifferentObjects() {
    assertTrue(testName.equals(testName2));
  }

  @Test
  void testEquals_DifferentFirstNames() {
    testName2 = new Name("Jamie", "Lannister");
    assertFalse(testName.equals(testName2));
  }

  @Test
  void testEquals_DifferentLastNames() {
    testName2 = new Name("Cersei", "N/A");
    assertFalse(testName.equals(testName2));
  }

  @Test
  void testEquals_SameName() {
    testName2 = new Name("Cersei", "Lannister");
    assertTrue(testName.equals(testName2));
  }

  @Test
  void testHashCode() {
    assertEquals(expectedHashCode, testName.hashCode());
  }

  @Test
  void testToString() {
    assertEquals("Name{firstName='Cersei', lastName='Lannister'}", testName.toString());
  }
}
