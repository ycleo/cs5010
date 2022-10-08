package problem3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NameTest {

  private Name testName;

  @BeforeEach
  void setUp() {
    testName = new Name("Stephen", "Curry");
  }

  @Test
  void getFirstName() {
    assertEquals("Stephen", testName.getFirstName());
  }

  @Test
  void getLastName() {
    assertEquals("Curry", testName.getLastName());
  }
}
