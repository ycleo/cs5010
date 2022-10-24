package assignment3.problem1;

import static assignment3.problem1.Main.CSV_IMPORT_COMMAND;
import static assignment3.problem1.Main.EMAIL_TEMPLATE_COMMAND;
import static assignment3.problem1.Main.LETTER_TEMPLATE_COMMAND;
import static assignment3.problem1.Main.ONE;
import static assignment3.problem1.Main.OUTPUT_DIRECTORY_COMMAND;
import static assignment3.problem1.Main.ZERO;

import java.util.HashMap;

/**
 * Command parser function that can help extract the arguments for each important operation
 */
public class CommandParser {

  final private static String USAGE =
      "\nUsage:\n"
          + "   --email                    only generate email messages\n"
          + "   --email-template <file>    accept a filename that holds the email template.\n"
          + "                              Required if --email is used\n\n"
          + "   --letter                   only generate letters\n"
          + "   --letter-template <file>   accept a filename that holds the letter template.\n"
          + "                              Required if --letter is used\n\n"
          + "   --output-dir <path>        accept the name of a folder, all output is placed in this folder\n\n"
          + "   --csv-file <path>          accept the name of the csv file to process\n";
  final private static String NO_CV_FILE_IMPORT_ERROR_MESSAGE = "\nError: --csv-file operation was not provided.\n";
  final private static String NO_OUTPUT_DIR_ERROR_MESSAGE = "\nError: --output-dir operation was not provided.\n";
  final private static String OPERATION_BUT_NO_TEMPLATE_ERROR_MESSAGE = "\nError: --email provided but no --email-template was given.\n";
  final private static String TEMPLATE_BUT_NO_OPERATION_ERROR_MESSAGE = "\nError: --email-template provided with no --email operation.\n";
  final private static String EMAIL = "email";
  final private static String LETTER = "letter";
  final private static String EMAIL_COMMAND = "--email";
  final private static String LETTER_COMMAND = "--letter";

  /**
   * The function that can extracts the arguments for each important operation
   *
   * @param command The command typed in by the user
   * @return A hash map contains the operations mapped to their arguments
   */
  public static HashMap<String, String> getArguments(String[] command) {
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

    // check the command is valid
    if (!arguments.containsKey(CSV_IMPORT_COMMAND)) {
      throw new IllegalArgumentException(NO_CV_FILE_IMPORT_ERROR_MESSAGE + USAGE);
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

    return arguments;
  }

}
