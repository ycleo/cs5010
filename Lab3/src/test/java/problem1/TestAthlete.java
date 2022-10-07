package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestAthlete {

  private Name testName;
  private Athlete testAthlete;
  private Name expectedName;
  private Athlete testAthlete2;


  @BeforeEach
  void setUp() {
    testName = new Name("Mike", "Jordan");
    expectedName = new Name("Mike", "Jordan");
    testAthlete = new Athlete(new Name("Mike", "Jordan"), 193.5, 250.2, "NBA");
  }

  @Test
  void getName() {
    assertEquals(expectedName, this.testAthlete.getName());
  }

  @Test
  void getHeight() {
    assertEquals(193.5, this.testAthlete.getHeight());
  }

  @Test
  void getWeight() {
    assertEquals(250.2, this.testAthlete.getWeight());
  }

  @Test
  void getLeague() {
    assertEquals("NBA", this.testAthlete.getLeague());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testAthlete.equals(testAthlete));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testAthlete.equals(null));
  }

  @Test
  void testEquals_DifferentObject() {
    assertFalse(testAthlete.equals(testName));
  }

  @Test
  void testEquals_DifferentName() {
    testAthlete2 = new Athlete(new Name("Kobe", "Bryant"), 193.5, 250.2, "NBA");
    assertFalse(testAthlete.equals(testAthlete2));
  }

  @Test
  void testEquals_DifferentHeight() {
    testAthlete2 = new Athlete(new Name("Mike", "Jordan"), 221.5, 250.2, "NBA");
    assertFalse(testAthlete.equals(testAthlete2));
  }

  @Test
  void testEquals_DifferentWeight() {
    testAthlete2 = new Athlete(new Name("Mike", "Jordan"), 193.5, 200.8, "NBA");
    assertFalse(testAthlete.equals(testAthlete2));
  }

  @Test
  void testEquals_DifferentLeague() {
    testAthlete2 = new Athlete(new Name("Mike", "Jordan"), 193.5, 250.2, "P league");
    assertFalse(testAthlete.equals(testAthlete2));
  }

  @Test
  void testEquals_SameAthlete() {
    testAthlete2 = new Athlete(new Name("Mike", "Jordan"), 193.5, 250.2, "NBA");
    assertTrue(testAthlete.equals(testAthlete2));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(testName, testAthlete.getHeight(), testAthlete.getWeight(),
        testAthlete.getLeague());
    assertEquals(expectedHashCode, testAthlete.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "Athlete{name=Mike Jordan, height=193.5, weight=250.2, league=NBA}";
    assertEquals(expectedString, testAthlete.toString());
  }

}
