package assignment3.problem1;

import static assignment3.problem1.StaticStrings.*;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Command parser function that can help extract the arguments for each important operation
 */
public class CommandParser {

  private Scanner commandScanner;
  private String[] command;

  /**
   * Constructs the CommandParser with a new internal Scanner
   */
  public CommandParser() {
    this.commandScanner = new Scanner(System.in);
  }

  /**
   * Parses the user input command and store into our command field
   */
  public void parseCommand() {
    this.command = this.commandScanner.nextLine().strip()
        .replaceAll(REMOVE_REDUNDANT_SPACE_REGEX, SPACE).split(SPACE);
    this.commandScanner.close();
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
}
