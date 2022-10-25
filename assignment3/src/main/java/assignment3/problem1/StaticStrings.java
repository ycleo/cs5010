package assignment3.problem1;

import java.io.File;

/**
 * All the static strings for this project
 */
public class StaticStrings {

  /**
   * The absolute path to the current project folder
   */
  final public static String ABSOLUTE_PATH = new File(
      "").getAbsolutePath();  // ...../Student_ycleo/assignment3
  /**
   * number zero
   */
  final public static int ZERO = 0;
  /**
   * number one
   */
  final public static int ONE = 1;
  /**
   * number seven
   */
  final public static int SEVEN = 7;
  /**
   * The email template importing command
   */
  final public static String EMAIL_TEMPLATE_COMMAND = "--email-template";
  /**
   * The letter template importing command
   */
  final public static String LETTER_TEMPLATE_COMMAND = "--letter-template";
  /**
   * The prefix for each customer message file
   */
  final public static String SEND_TO = "-send-to-customer-";
  /**
   * Dash symbol
   */
  final public static String DASH = "-";
  /**
   * The csv file importing command
   */
  final public static String CSV_IMPORT_COMMAND = "--csv-file";
  /**
   * The output directory command
   */
  final public static String OUTPUT_DIRECTORY_COMMAND = "--output-dir";
  /**
   * The regex to recognize the double left bracket
   */
  final public static String DOUBLE_LEFT_BRACKET_REGEX = "\\[\\[";
  /**
   * The regex to recognize the double right bracket
   */
  final public static String DOUBLE_RIGHT_BRACKET_REGEX = "\\]\\]";
  /**
   * Text file extension
   */
  final public static String TXT = ".txt";
  /**
   * The regex to help remove redundant white space
   */
  final public static String REMOVE_REDUNDANT_SPACE_REGEX = "\\s+";
  /**
   * White space
   */
  final public static String SPACE = " ";
  /**
   * The Usage prompt when command error happens
   */
  final public static String USAGE =
      "\nUsage:\n"
          + "   --email                    only generate email messages\n"
          + "   --email-template <file>    accept a filename that holds the email template.\n"
          + "                              Required if --email is used\n\n"
          + "   --letter                   only generate letters\n"
          + "   --letter-template <file>   accept a filename that holds the letter template.\n"
          + "                              Required if --letter is used\n\n"
          + "   --output-dir <path>        accept the name of a folder, all output is placed in this folder\n\n"
          + "   --csv-file <path>          accept the name of the csv file to process\n";
  /**
   * Error when user did not input --csv-file command
   */
  final public static String NO_CSV_FILE_IMPORT_ERROR_MESSAGE = "\nError: --csv-file operation was not provided.\n";
  /**
   * Error when user did not input --output-dir command
   */
  final public static String NO_OUTPUT_DIR_ERROR_MESSAGE = "\nError: --output-dir operation was not provided.\n";
  /**
   * Error when user did not input --email-template command when --email command provided
   */
  final public static String OPERATION_BUT_NO_TEMPLATE_ERROR_MESSAGE = "\nError: --email provided but no --email-template was given.\n";
  /**
   * Error when user did not input --email command when --email-template command provided
   */
  final public static String TEMPLATE_BUT_NO_OPERATION_ERROR_MESSAGE = "\nError: --email-template provided with no --email operation.\n";
  /**
   * email string
   */
  final public static String EMAIL = "email";
  /**
   * letter string
   */
  final public static String LETTER = "letter";
  /**
   * --email command
   */
  final public static String EMAIL_COMMAND = "--email";
  /**
   * --letter command
   */
  final public static String LETTER_COMMAND = "--letter";
  /**
   * The regex to help separate the customer's information
   */
  final public static String INFO_DELIMITER = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
  /**
   * The quotation mark
   */
  final public static String QUOTATION_MARK = "\"";
  /**
   * Empty string
   */
  final public static String EMPTY = "";
}
