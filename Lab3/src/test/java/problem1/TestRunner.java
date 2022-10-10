package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestRunner {

  private Name testName;
  private Name expectedName;
  private Runner testRunner1;
  private Runner testRunner2;

  @BeforeEach
  void setUp() {
    testName = new Name("Iron", "Man");
    expectedName = new Name("Iron", "Man");
    testRunner1 = new Runner(testName, 183.2, 130.6, "JBA", 25.2, 90.5, "Boston Marathon");
  }

  @Test
  void getName() {
    assertEquals(expectedName, testRunner1.getName());
  }

  @Test
  void getHeight() {
    assertEquals(183.2, testRunner1.getHeight());
  }

  @Test
  void getWeight() {
    assertEquals(130.6, testRunner1.getWeight());
  }

  @Test
  void getLeague() {
    assertEquals("JBA", testRunner1.getLeague());
  }

  @Test
  void getBest5KTime() {
    assertEquals(25.2, testRunner1.getBest5KTime());
  }

  @Test
  void getBestHalfMarathonTime() {
    assertEquals(90.5, testRunner1.getBestHalfMarathonTime());
  }

  @Test
  void getFavoriteRunningEvent() {
    assertEquals("Boston Marathon", testRunner1.getFavoriteRunningEvent());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testRunner1.equals(testRunner1));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testRunner1.equals(null));
  }

  @Test
  void testEquals_DifferentObject() {
    assertFalse(testRunner1.equals(testName));
  }

  @Test
  void testEquals_DifferentName() {
    testRunner2 = new Runner(new Name("new", "name"), 183.2, 130.6, "JBA", 25.2, 90.5,
        "Boston Marathon");
    assertFalse(testRunner1.equals(testRunner2));
  }

  @Test
  void testEquals_DifferentHeight() {
    testRunner2 = new Runner(testName, 188.2, 130.6, "JBA", 25.2, 90.5, "Boston Marathon");
    assertFalse(testRunner1.equals(testRunner2));
  }

  @Test
  void testEquals_DifferentWeight() {
    testRunner2 = new Runner(testName, 183.2, 122.7, "JBA", 25.2, 90.5, "Boston Marathon");
    assertFalse(testRunner1.equals(testRunner2));
  }

  @Test
  void testEquals_DifferentLeague() {
    testRunner2 = new Runner(testName, 183.2, 130.6, "CBB", 25.2, 90.5, "Boston Marathon");
    assertFalse(testRunner1.equals(testRunner2));
  }

  @Test
  void testEquals_DifferentBest5KTime() {
    testRunner2 = new Runner(testName, 183.2, 130.6, "JBA", 30.9, 90.5, "Boston Marathon");
    assertFalse(testRunner1.equals(testRunner2));
  }

  @Test
  void testEquals_DifferentBestHalfMarathonTime() {
    testRunner2 = new Runner(testName, 183.2, 130.6, "JBA", 25.2, 96.5, "Boston Marathon");
    assertFalse(testRunner1.equals(testRunner2));
  }

  @Test
  void testEquals_DifferentFavoriteRunningEvent() {
    testRunner2 = new Runner(testName, 183.2, 130.6, "JBA", 25.2, 90.5, "Tokyo Marathon");
    assertFalse(testRunner1.equals(testRunner2));
  }

  @Test
  void testEquals_SameRunner() {
    testRunner2 = new Runner(testName, 183.2, 130.6, "JBA", 25.2, 90.5, "Boston Marathon");
    assertTrue(testRunner1.equals(testRunner2));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(
        Objects.hash(testRunner1.getName(), testRunner1.getHeight(), testRunner1.getWeight(),
            testRunner1.getLeague()), testRunner1.getBest5KTime(),
        testRunner1.getBestHalfMarathonTime(), testRunner1.getFavoriteRunningEvent());
    assertEquals(expectedHashCode, testRunner1.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "Runner{Name=Iron Man, height=183.2, weight=130.6, league=JBA, best 5K time=25.2, best half-marathon time=90.5, favorite running event=Boston Marathon}";
    assertEquals(expectedString, testRunner1.toString());
  }

  @Test
  void testToStringWithoutLeague() {
    testRunner2 = new Runner(testName, 183.2, 130.6, 25.2, 90.5, "Boston Marathon");
    String expectedString = "Runner{Name=Iron Man, height=183.2, weight=130.6, league=null, best 5K time=25.2, best half-marathon time=90.5, favorite running event=Boston Marathon}";
    assertEquals(expectedString, testRunner2.toString());
  }
}
