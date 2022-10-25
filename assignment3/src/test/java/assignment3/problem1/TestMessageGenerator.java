package assignment3.problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMessageGenerator {

  private MessageGenerator testMessageGenerator;
  private MessageGenerator testMessageGenerator1;
  private HashMap<String, String> expectedArguments;
  private String[] expectedInfoType;
  private List<List<String>> expectedCustomersInfo;

  @BeforeEach
  void setUp() {
    expectedArguments = new HashMap<>() {{
      put("--email-template", "/testing-file/email-template.txt");
      put("--email", null);
      put("--output-dir", "/testing-file/");
      put("--csv-file", "/testing-file/test.csv");
    }};
    expectedInfoType = new String[]{"first_name", "last_name"};
    expectedCustomersInfo = new ArrayList<>();
    List<String> customerInfo = new ArrayList<>(Arrays.asList("Tony", "Stark"));
    expectedCustomersInfo.add(customerInfo);

    testMessageGenerator = new MessageGenerator(expectedInfoType, expectedCustomersInfo,
        expectedArguments);
  }

  @Test
  void generateMessage_NoTemplateCommand() throws IOException {
    assertFalse(testMessageGenerator.generateMessage("--letter-template"));
  }

  @Test
  void generateMessage() throws IOException {
    assertTrue(testMessageGenerator.generateMessage("--email-template"));
  }

  @Test
  void equals_SameObject() {
    assertTrue(testMessageGenerator.equals(testMessageGenerator));
  }

  @Test
  void equals_NullObject() {
    assertFalse(testMessageGenerator.equals(null));
  }

  @Test
  void equals_DifferentObject() {
    assertFalse(testMessageGenerator.equals(expectedInfoType));
  }

  @Test
  void equals_DifferentArguments() throws FileNotFoundException {
    expectedArguments = new HashMap<>() {
    };
    testMessageGenerator1 = new MessageGenerator(expectedInfoType, expectedCustomersInfo,
        expectedArguments);
    assertFalse(testMessageGenerator.equals(testMessageGenerator1));
  }

  @Test
  void equals_DifferentInfoType() {
    expectedInfoType = new String[]{};
    testMessageGenerator1 = new MessageGenerator(expectedInfoType, expectedCustomersInfo,
        expectedArguments);
    assertFalse(testMessageGenerator.equals(testMessageGenerator1));
  }

  @Test
  void equals_DifferentCustomersInfo() {
    expectedCustomersInfo = new ArrayList<>();
    List<String> customerInfo = new ArrayList<>(Arrays.asList("Hello", "Stark"));
    expectedCustomersInfo.add(customerInfo);
    testMessageGenerator1 = new MessageGenerator(expectedInfoType, expectedCustomersInfo,
        expectedArguments);
    assertFalse(testMessageGenerator.equals(testMessageGenerator1));
  }

  @Test
  void equals_SameMessageGenerator() {
    testMessageGenerator1 = new MessageGenerator(expectedInfoType, expectedCustomersInfo,
        expectedArguments);
    assertTrue(testMessageGenerator.equals(testMessageGenerator1));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(expectedArguments, expectedInfoType, expectedCustomersInfo);
    assertEquals(expectedHashCode, testMessageGenerator.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "CommandParser: { "
        + "command arguments: " + expectedArguments.toString()
        + "; information type: " + expectedInfoType.toString()
        + "; customers' information: " + expectedCustomersInfo.toString()
        + " }";
    assertEquals(expectedString, testMessageGenerator.toString());
  }

}
