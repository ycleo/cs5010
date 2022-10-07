package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestBaseballPlayer {

  private Name testName;
  private Name expectedName;
  private BaseballPlayer testBaseballPlayer1;
  private BaseballPlayer testBaseballPlayer2;

  @BeforeEach
  void setUp() {
    testName = new Name("Aaron", "Judge");
    expectedName = new Name("Aaron", "Judge");
    testBaseballPlayer1 = new BaseballPlayer(testName, 199.5, 200.3, "MLB",
        "Yankees", 0.356, 66);
  }

  @Test
  void getName() {
    assertEquals(expectedName, this.testBaseballPlayer1.getName());
  }

  @Test
  void getHeight() {
    assertEquals(199.5, this.testBaseballPlayer1.getHeight());
  }

  @Test
  void getWeight() {
    assertEquals(200.3, this.testBaseballPlayer1.getWeight());
  }

  @Test
  void getLeague() {
    assertEquals("MLB", this.testBaseballPlayer1.getLeague());
  }

  @Test
  void getTeam() {
    assertEquals("Yankees", this.testBaseballPlayer1.getTeam());
  }

  @Test
  void getAvgBatting() {
    assertEquals(0.356, this.testBaseballPlayer1.getAvgBatting());
  }

  @Test
  void getSeasonHomeRun() {
    assertEquals(66, this.testBaseballPlayer1.getSeasonHomeRun());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testBaseballPlayer1.equals(testBaseballPlayer1));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testBaseballPlayer1.equals(null));
  }

  @Test
  void testEquals_DifferentObject() {
    assertFalse(testBaseballPlayer1.equals(testName));
  }

  @Test
  void testEquals_DifferentName() {
    testBaseballPlayer2 = new BaseballPlayer(new Name("CH", "Wang"), 199.5, 200.3, "MLB",
        "Yankees", 0.356, 66);
    assertFalse(testBaseballPlayer1.equals(testBaseballPlayer2));
  }

  @Test
  void testEquals_DifferentHeight() {
    testBaseballPlayer2 = new BaseballPlayer(testName, 182.8, 200.3, "MLB",
        "Yankees", 0.356, 66);
    assertFalse(testBaseballPlayer1.equals(testBaseballPlayer2));
  }

  @Test
  void testEquals_DifferentWeight() {
    testBaseballPlayer2 = new BaseballPlayer(testName, 199.5, 120.7, "MLB",
        "Yankees", 0.356, 66);
    assertFalse(testBaseballPlayer1.equals(testBaseballPlayer2));
  }

  @Test
  void testEquals_DifferentLeague() {
    testBaseballPlayer2 = new BaseballPlayer(testName, 199.5, 200.3, "SBL",
        "Yankees", 0.356, 66);
    assertFalse(testBaseballPlayer1.equals(testBaseballPlayer2));
  }


  @Test
  void testEquals_DifferentTeam() {
    testBaseballPlayer2 = new BaseballPlayer(testName, 199.5, 200.3, "MLB",
        "Seattle", 0.356, 66);
    assertFalse(testBaseballPlayer1.equals(testBaseballPlayer2));
  }

  @Test
  void testEquals_DifferentAvgBatting() {
    testBaseballPlayer2 = new BaseballPlayer(testName, 199.5, 200.3, "MLB",
        "Yankees", 0.415, 66);
    assertFalse(testBaseballPlayer1.equals(testBaseballPlayer2));
  }

  @Test
  void testEquals_DifferentHomeRuns() {
    testBaseballPlayer2 = new BaseballPlayer(testName, 199.5, 200.3, "MLB",
        "Yankees", 0.356, 52);
    assertFalse(testBaseballPlayer1.equals(testBaseballPlayer2));
  }


  @Test
  void testEquals_SamePlayers() {
    testBaseballPlayer2 = new BaseballPlayer(testName, 199.5, 200.3, "MLB",
        "Yankees", 0.356, 66);
    assertTrue(testBaseballPlayer1.equals(testBaseballPlayer2));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(
        Objects.hash(testBaseballPlayer1.getName(), testBaseballPlayer1.getHeight(),
            testBaseballPlayer1.getWeight(), testBaseballPlayer1.getLeague()),
        testBaseballPlayer1.getTeam(),
        testBaseballPlayer1.getAvgBatting(), testBaseballPlayer1.getSeasonHomeRun());
    assertEquals(expectedHashCode, testBaseballPlayer1.hashCode());

  }

  @Test
  void testToString() {
    String expectedString = "BaseballPlayer{Name=Aaron Judge, height=199.5, weight=200.3, league=MLB, team=Yankees, average batting=0.356, season home runs=66}";
    assertEquals(expectedString, testBaseballPlayer1.toString());
  }
}
