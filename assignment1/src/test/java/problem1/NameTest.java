package problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NameTest {
  private Name testName;
  private String expectedFirstName;
  private String expectedMiddleName;
  private String expectedLastName;

  @BeforeEach
  void setUp() {
    expectedFirstName = "YC";
    expectedMiddleName = "Leo";
    expectedLastName = "Lee";
    testName = new Name("YC", "Leo", "Lee");
  }

  @Test
  void getFirstName() {
    assertEquals(expectedFirstName, "YC");
  }

  @Test
  void getMiddleName() {
    assertEquals(expectedMiddleName, "Leo");
  }

  @Test
  void getLastName() {
    assertEquals(expectedLastName, "Lee");
  }

  @Test
  void equalsGetSameNameObject() {
    assertTrue(testName.equals(testName));
  }

  @Test
  void equalsGetNullObject() {
    assertFalse(testName.equals(null));
  }
  @Test
  void equalsGetSameName() {
    Name testName1 = new Name("YC", "Leo", "Lee");
    assertTrue(testName.equals(testName1));
  }
}
