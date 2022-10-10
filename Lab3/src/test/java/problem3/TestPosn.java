package problem3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPosn {

  private Integer testX;
  private Integer testY;
  private Posn testPosn;
  private Posn testPosn1;

  @BeforeEach
  void setUp() {
    testX = 2;
    testY = 3;
    testPosn = new Posn(2, 3);
  }

  @Test
  void getX() {
    assertEquals(2, testPosn.getX());
  }

  @Test
  void getY() {
    assertEquals(3, testPosn.getY());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testPosn.equals(testPosn));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testPosn.equals(null));
  }

  @Test
  void testEquals_DifferentObject() {
    assertFalse(testPosn.equals(testX));
  }

  @Test
  void testEquals_DifferentX() {
    testPosn1 = new Posn(4, 3);
    assertFalse(testPosn.equals(testPosn1));
  }

  @Test
  void testEquals_NullX() {
    testPosn1 = new Posn(null, 3);
    assertFalse(testPosn.equals(testPosn1));
  }

  @Test
  void testEquals_SelfXIsNull() {
    testPosn = new Posn(null, 3);
    testPosn1 = new Posn(2, 3);
    assertFalse(testPosn.equals(testPosn1));
  }

  @Test
  void testEquals_DifferentY() {
    testPosn1 = new Posn(2, 9);
    assertFalse(testPosn.equals(testPosn1));
  }

  @Test
  void testEquals_NullY() {
    testPosn1 = new Posn(2, null);
    assertFalse(testPosn.equals(testPosn1));
  }

  @Test
  void testEquals_SelfYIsNull() {
    testPosn = new Posn(2, null);
    testPosn1 = new Posn(2, 3);
    assertFalse(testPosn.equals(testPosn1));
  }

  @Test
  void testEquals_BothXYNull() {
    testPosn = new Posn(null, null);
    testPosn1 = new Posn(null, null);
    assertTrue(testPosn.equals(testPosn1));
  }

  @Test
  void testEquals_SamePosn() {
    testPosn1 = new Posn(2, 3);
    assertTrue(testPosn.equals(testPosn1));
  }

  @Test
  void testHashCode_XNull() {
    testPosn = new Posn(null, 3);
    int expectedHashCode = 31 * 0 + testY.hashCode();
    assertEquals(expectedHashCode, testPosn.hashCode());
  }

  @Test
  void testHashCode_YNull() {
    testPosn = new Posn(2, null);
    int expectedHashCode = 31 * testPosn.getX().hashCode() + 0;
    assertEquals(expectedHashCode, testPosn.hashCode());
  }

  @Test
  void testHashCode_XYNull() {
    testPosn = new Posn(null, null);
    int expectedHashCode = 31 * 0 + 0;
    assertEquals(expectedHashCode, testPosn.hashCode());
  }

  @Test
  void testHashCode_XYNotNull() {
    int expectedHashCode = 31 * testPosn.getX().hashCode() + testPosn.getY().hashCode();
    assertEquals(expectedHashCode, testPosn.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "Posn{x=2, y=3}";
    assertEquals(expectedString, testPosn.toString());
  }
}
