package assignment3.problem1;

import static assignment3.problem1.StaticStrings.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

/**
 * Command parser function that can help extract the arguments for each important operation
 */
public class CommandParser {

  private String[] command;

  /**
   * Constructs the CommandParser with a new Scanner
   *
   * @param command command instructions
   */
  public CommandParser(String[] command) {
    this.command = command;
  }

  /**
   * The function that can extracts the arguments for each important operation
   *
   * @return A hash map contains the operations mapped to their arguments
   */
  public HashMap<String, String> getCommandArguments() {
    HashMap<String, String> arguments = new HashMap<>();
    for (int i = ZERO; i < command.length; i++) {
      if (command[i].equals(CSV_IMPORT_COMMAND) ||
          command[i].equals(OUTPUT_DIRECTORY_COMMAND) ||
          command[i].equals(EMAIL_TEMPLATE_COMMAND) ||
          command[i].equals(LETTER_TEMPLATE_COMMAND)) {
        arguments.put(command[i], command[i + ONE]);
      }
      if (command[i].equals(EMAIL_COMMAND) || command[i].equals(LETTER_COMMAND)) {
        arguments.put(command[i], null);
      }
    }
    this.checkCommandValid(arguments);
    return arguments;
  }

  /**
   * Check the command is valid or not
   *
   * @param arguments A hash map contains the operations mapped to their arguments
   */
  private void checkCommandValid(HashMap<String, String> arguments) {
    // check the command is valid
    if (!arguments.containsKey(CSV_IMPORT_COMMAND)) {
      throw new IllegalArgumentException(NO_CSV_FILE_IMPORT_ERROR_MESSAGE + USAGE);
    }
    if (!arguments.containsKey(OUTPUT_DIRECTORY_COMMAND)) {
      throw new IllegalArgumentException(NO_OUTPUT_DIR_ERROR_MESSAGE + USAGE);
    }
    if (arguments.containsKey(EMAIL_COMMAND) && !arguments.containsKey(EMAIL_TEMPLATE_COMMAND)) {
      throw new IllegalArgumentException(OPERATION_BUT_NO_TEMPLATE_ERROR_MESSAGE + USAGE);
    }
    if (arguments.containsKey(LETTER_COMMAND) && !arguments.containsKey(LETTER_TEMPLATE_COMMAND)) {
      throw new IllegalArgumentException(
          OPERATION_BUT_NO_TEMPLATE_ERROR_MESSAGE.replaceAll(EMAIL, LETTER) + USAGE);
    }
    if (arguments.containsKey(EMAIL_TEMPLATE_COMMAND) && !arguments.containsKey(EMAIL_COMMAND)) {
      throw new IllegalArgumentException(TEMPLATE_BUT_NO_OPERATION_ERROR_MESSAGE + USAGE);
    }
    if (arguments.containsKey(LETTER_TEMPLATE_COMMAND) && !arguments.containsKey(LETTER_COMMAND)) {
      throw new IllegalArgumentException(
          TEMPLATE_BUT_NO_OPERATION_ERROR_MESSAGE.replaceAll(EMAIL, LETTER) + USAGE);
    }
  }

  /**
   * Gets the commands list
   *
   * @return the commands list
   */
  public String[] getCommand() {
    return this.command;
  }

  /**
   * Tests the object equals to the command parser or not
   *
   * @param o tested object
   * @return boolean result
   */
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    CommandParser commandParser = (CommandParser) o;
    return Arrays.equals(this.command, commandParser.command);
  }

  /**
   * Return the hash code represents the command parser
   *
   * @return the hash code represents the command parser
   */
  public int hashCode() {
    return Objects.hash((Object) this.command);
  }

  /**
   * Returns the string represents the command parser
   *
   * @return the string represents the command parser
   */
  public String toString() {
    return "CommandParser: { command: "
        + Arrays.toString(this.command) + " }";
  }
}
