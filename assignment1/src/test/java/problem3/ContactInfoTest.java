package problem3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactInfoTest {

  private Name expectedName;
  private String expectedAddress;
  private String expectedPhone;
  private String expectedEmail;
  private ContactInfo testContactInfo;

  @BeforeEach
  void setUp() {
    expectedName = new Name("Ben", "Simon");
    expectedAddress = "111 Cool address";
    expectedPhone = "6266665252";
    expectedEmail = "ben@gmail.com";
    testContactInfo = new ContactInfo(expectedName, expectedAddress, expectedPhone, expectedEmail);
  }

  @Test
  void getName() {
    assertEquals(expectedName, testContactInfo.getName());
  }

  @Test
  void getAddress() {
    assertEquals(expectedAddress, testContactInfo.getAddress());
  }

  void getPhone() {
    assertEquals(expectedPhone, testContactInfo.getPhone());
  }

  void getEmail() {
    assertEquals(expectedEmail, testContactInfo.getEmail());
  }

}


