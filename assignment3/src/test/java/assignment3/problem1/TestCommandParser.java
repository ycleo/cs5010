package assignment3.problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCommandParser {

  private String[] expectedCommand;
  private CommandParser testCommandParser1;
  private CommandParser testCommandParser;
  private HashMap<String, String> expectedArguments;

  @BeforeEach
  void setUp() throws IOException {
    this.expectedCommand = new String[]{
        "--email", "--email-template", "/testing-file/email-template.txt",
        "--letter", "--letter-template", "/testing-file/letter-template.txt",
        "--output-dir", "/testing-file/", "--csv-file", "/testing-file/test.csv"};
    this.testCommandParser = new CommandParser(expectedCommand);
    this.testCommandParser1 = new CommandParser(expectedCommand);
    this.expectedArguments = new HashMap<>() {{
      put("--letter-template", "/testing-file/letter-template.txt");
      put("--letter", null);
      put("--email-template", "/testing-file/email-template.txt");
      put("--email", null);
      put("--output-dir", "/testing-file/");
      put("--csv-file", "/testing-file/test.csv");
    }};
  }

  @Test
  void getCommandArguments() {
    assertEquals(expectedArguments, testCommandParser.getCommandArguments());
  }

  @Test
  void getCommand() {
    assertEquals(expectedCommand, testCommandParser.getCommand());
  }

  @Test
  void equals_SameObject() {
    assertTrue(testCommandParser.equals(testCommandParser));
  }

  @Test
  void equals_NullObject() {
    assertFalse(testCommandParser.equals(null));
  }

  @Test
  void equals_DifferentObject() {
    assertFalse(testCommandParser.equals(expectedCommand));
  }

  @Test
  void equals_DifferentCommandScanner() throws IOException {
    String[] expectedCommand1 = new String[]{
        "--email", "--email-template", "/testing-file/email-template.txt",
        "--output-dir", "/testing-file/", "--csv-file", "/testing-file/test.csv"};
    testCommandParser1 = new CommandParser(expectedCommand1);
    assertFalse(testCommandParser.equals(testCommandParser1));
  }

  @Test
  void testHashCode() {
    assertEquals(
        Objects.hash((Object) testCommandParser.getCommand()),
        testCommandParser.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "CommandParser: { "
        + "command: "
        + "[--email, --email-template, /testing-file/email-template.txt, --letter, --letter-template, /testing-file/letter-template.txt, --output-dir, /testing-file/, --csv-file, /testing-file/test.csv] }";
    assertEquals(expectedString, testCommandParser.toString());
  }

}
