package assignment3.problem1;

import static assignment3.problem1.StaticStrings.ABSOLUTE_PATH;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCommandParser {

  private String[] expectedCommand;
  private CommandParser testCommandParser1;
  private Scanner expectedScanner1;
  private CommandParser testCommandParser;
  private Scanner expectedScanner;
  private Path expectedCommandExamplePath;
  private HashMap<String, String> expectedArguments;

  @BeforeEach
  void setUp() throws IOException {
    expectedCommandExamplePath = Path.of(ABSOLUTE_PATH + "/testing-file/command-example.txt");
    expectedScanner = new Scanner(expectedCommandExamplePath);
    this.testCommandParser = new CommandParser(expectedScanner);
    this.testCommandParser1 = new CommandParser(expectedScanner);
    this.expectedScanner = testCommandParser.getCommandScanner();
    this.expectedCommand = testCommandParser.getCommand();
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
  void parseCommand_NotEmptyCommand() {
    assertTrue(this.testCommandParser.parseCommand());
  }

  @Test
  void parseCommand_EmptyCommand() throws IOException {
    expectedScanner = new Scanner(Path.of(ABSOLUTE_PATH + "/testing-file/empty-command.txt"));
    testCommandParser = new CommandParser(expectedScanner);
    assertFalse(this.testCommandParser.parseCommand());
  }

  @Test
  void getCommandArguments() {
    testCommandParser.parseCommand();
    assertEquals(expectedArguments, testCommandParser.getCommandArguments());
  }

  @Test
  void getCommandScanner() {
    assertEquals(expectedScanner, testCommandParser.getCommandScanner());
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
    expectedScanner1 = new Scanner(Path.of(ABSOLUTE_PATH + "/testing-file/empty-command.txt"));
    testCommandParser1 = new CommandParser(expectedScanner1);
    testCommandParser1.parseCommand();
    assertFalse(testCommandParser.equals(testCommandParser1));
  }

  @Test
  void testHashCode() {
    assertEquals(
        Objects.hash(testCommandParser.getCommandScanner(), testCommandParser.getCommand()),
        testCommandParser.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "CommandParser: { command scanner: "
        + testCommandParser.getCommandScanner().toString()
        + "; command: "
        + "null }";
    assertEquals(expectedString, testCommandParser.toString());
  }

}
