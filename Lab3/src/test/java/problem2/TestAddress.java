package problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestAddress {

  private Address testAddress;
  private Address testAddress2;
  private String expectedStreetAndNumber;
  private String expectedCity;
  private String expectedZIPCode;
  private String expectedState;
  private String expectedCountry;

  @BeforeEach
  void setUp() {
    expectedStreetAndNumber = "1256 N 88th ST";
    expectedCity = "Seattle";
    expectedZIPCode = "99231";
    expectedState = "WA";
    expectedCountry = "US";
    testAddress = new Address("1256 N 88th ST", "Seattle", "99231", "WA", "US");
  }

  @Test
  void getStreetAndNumber() {
    assertEquals(expectedStreetAndNumber, testAddress.getStreetAndNumber());
  }

  @Test
  void getCity() {
    assertEquals(expectedCity, testAddress.getCity());
  }

  @Test
  void getZIPCode() {
    assertEquals(expectedZIPCode, testAddress.getZIPCode());
  }

  @Test
  void getState() {
    assertEquals(expectedState, testAddress.getState());
  }

  @Test
  void getCountry() {
    assertEquals(expectedCountry, testAddress.getCountry());
  }

  @Test
  void setStreetAndNumber() {
    this.testAddress.setStreetAndNumber("222 S cool ST");
    assertEquals("222 S cool ST", testAddress.getStreetAndNumber());
  }

  @Test
  void setCity() {
    testAddress.setCity("Irvine");
    assertEquals("Irvine", testAddress.getCity());
  }

  @Test
  void setZIPCode() {
    testAddress.setZIPCode("99901");
    assertEquals("99901", testAddress.getZIPCode());
  }

  @Test
  void setState() {
    testAddress.setState("CA");
    assertEquals("CA", testAddress.getState());
  }

  @Test
  void setCountry() {
    testAddress.setCountry("Canada");
    assertEquals("Canada", testAddress.getCountry());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testAddress.equals(testAddress));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testAddress.equals(null));
  }

  @Test
  void testEquals_DifferentObject() {
    assertFalse(testAddress.equals(expectedCity));
  }

  @Test
  void testEquals_DifferentStreetAndNumber() {
    testAddress2 = new Address("1123 cool st", "Seattle", "99231", "WA", "US");
    assertFalse(testAddress.equals(testAddress2));
  }

  @Test
  void testEquals_DifferentCity() {
    testAddress2 = new Address("1256 N 88th ST", "San Jose", "99231", "WA", "US");
    assertFalse(testAddress.equals(testAddress2));
  }

  @Test
  void testEquals_DifferentZIPCode() {
    testAddress2 = new Address("1256 N 88th ST", "Seattle", "66666", "WA", "US");
    assertFalse(testAddress.equals(testAddress2));
  }

  @Test
  void testEquals_DifferentState() {
    testAddress2 = new Address("1256 N 88th ST", "Seattle", "99231", "CA", "US");
    assertFalse(testAddress.equals(testAddress2));
  }

  @Test
  void testEquals_DifferentCountry() {
    testAddress2 = new Address("1256 N 88th ST", "Seattle", "99231", "WA", "Japan");
    assertFalse(testAddress.equals(testAddress2));
  }

  @Test
  void testEquals_SameAddress() {
    testAddress2 = new Address("1256 N 88th ST", "Seattle", "99231", "WA", "US");
    assertTrue(testAddress.equals(testAddress2));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(testAddress.getStreetAndNumber(), testAddress.getCity(),
        testAddress.getZIPCode(), testAddress.getState(), testAddress.getCountry());
    assertEquals(expectedHashCode, testAddress.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "Address{street and number: 1256 N 88th ST, city: Seattle, ZIP code: 99231, state: WA, country: US}";
    assertEquals(expectedString, testAddress.toString());
  }

}
