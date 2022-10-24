package assignment3.problem1;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class Main {
  final private static String NO_CV_FILE_IMPORT_ERROR_MESSAGE = "\nError: --csv-file operation was not provided.\n";
  final private static String NO_OUTPUT_DIR_ERROR_MESSAGE = "\nError: --output-dir operation was not provided.\n";
  final private static String OPERATION_BUT_NO_TEMPLATE_ERROR_MESSAGE = "\nError: --email provided but no --email-template was given.\n";
  final private static String TEMPLATE_BUT_NO_OPERATION_ERROR_MESSAGE = "\nError: --email-template provided with no --email operation.\n";

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
  final private static String ABSOLUTE_PATH = new File("").getAbsolutePath();  // ...../Student_ycleo/assignment3
//  final private static String CUSTOMER_INFO_CSV_PATH = ABSOLUTE_PATH.concat("/src/main/java/assignment3/problem1/insurance-company-members.csv");
  final private static String INFO_DELIMITER = ",(?=([^\\\"]|\\\"[^\\\"]*\\\")*$)";
  final private static String REMOVE_REDUNDANT_SPACE_REGEX = "\\s+";
  final private static String DOUBLE_LEFT_BRACKET_REGEX = "\\[\\[";
  final private static String DOUBLE_RIGHT_BRACKET_REGEX = "\\]\\]";
  final private static String SPACE = " ";
  final private static int ZERO = 0;
  final private static int ONE = 1;
  final private static String EMAIL = "email";
  final private static String LETTER = "letter";
  final private static String EMAIL_COMMAND = "--email";
  final private static String EMAIL_TEMPLATE_COMMAND = "--email-template";
  final private static String LETTER_COMMAND = "--letter";
  final private static String LETTER_TEMPLATE_COMMAND = "--letter-template";
  final private static String CSV_IMPORT_COMMAND = "--csv-file";
  final private static String OUTPUT_DIRECTORY_COMMAND = "--output-dir";
  final private static String EMAIL_OUTPUT = "/emails-output/email-to-";
  final private static String LETTER_OUTPUT = "/letters-output/letter-to-";
  final private static String TXT = ".txt";

  private static List<List<String>> customersIno = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    System.out.println(ABSOLUTE_PATH);
    // Parse the command input
    Scanner commandScanner = new Scanner(System.in);
    String[] command = commandScanner.nextLine().strip().replaceAll(REMOVE_REDUNDANT_SPACE_REGEX, SPACE).split(SPACE);
    commandScanner.close();

    // get the csv path, template files, and the output directory
    HashMap<String, String> arguments = getArguments(command);

    // Get the information types
    Scanner csvScanner = new Scanner(new File(ABSOLUTE_PATH.concat(arguments.get(CSV_IMPORT_COMMAND))));
    String[] infoType = csvScanner.nextLine().split(INFO_DELIMITER);
    for (int i = ZERO; i < infoType.length; i++)
      infoType[i] = infoType[i].substring(ONE, infoType[i].length() - ONE);
    int infoTypeNum = infoType.length;

    // Loads the csv file into customers' information array
    while(csvScanner.hasNext()) {
      String[] info = csvScanner.nextLine().split(INFO_DELIMITER);
      for (int i = ZERO; i < info.length; i++)
        info[i] = info[i].substring(ONE, info[i].length() - ONE);
      customersIno.add(Arrays.asList(info));
    }
    csvScanner.close();

    // generate email message
    generateMessage(EMAIL_TEMPLATE_COMMAND, infoType, customersIno, arguments);

    // generate letter message
    generateMessage(LETTER_TEMPLATE_COMMAND, infoType, customersIno, arguments);

  }

  private static HashMap<String, String> getArguments(String[] command) {
    HashMap<String, String> arguments = new HashMap<>();
    for (int i = ZERO; i < command.length; i++) {
      if (command[i].equals(CSV_IMPORT_COMMAND) ||
          command[i].equals(OUTPUT_DIRECTORY_COMMAND) ||
          command[i].equals(EMAIL_TEMPLATE_COMMAND) ||
          command[i].equals(LETTER_TEMPLATE_COMMAND)) {
          arguments.put(command[i], command[i + ONE]);
      }
      if (command[i].equals(EMAIL_COMMAND) || command[i].equals(LETTER_COMMAND))
        arguments.put(command[i], null);
    }

    // check the command is valid
    if (!arguments.containsKey(CSV_IMPORT_COMMAND))
      throw new IllegalArgumentException(NO_CV_FILE_IMPORT_ERROR_MESSAGE + USAGE);
    if (!arguments.containsKey(OUTPUT_DIRECTORY_COMMAND))
      throw new IllegalArgumentException(NO_OUTPUT_DIR_ERROR_MESSAGE + USAGE);
    if (arguments.containsKey(EMAIL_COMMAND) && !arguments.containsKey(EMAIL_TEMPLATE_COMMAND))
      throw new IllegalArgumentException(OPERATION_BUT_NO_TEMPLATE_ERROR_MESSAGE + USAGE);
    if (arguments.containsKey(LETTER_COMMAND) && !arguments.containsKey(LETTER_TEMPLATE_COMMAND))
      throw new IllegalArgumentException(OPERATION_BUT_NO_TEMPLATE_ERROR_MESSAGE.replaceAll(EMAIL, LETTER) + USAGE);
    if (arguments.containsKey(EMAIL_TEMPLATE_COMMAND) && !arguments.containsKey(EMAIL_COMMAND))
      throw new IllegalArgumentException(TEMPLATE_BUT_NO_OPERATION_ERROR_MESSAGE + USAGE);
    if (arguments.containsKey(LETTER_TEMPLATE_COMMAND) && !arguments.containsKey(LETTER_COMMAND))
      throw new IllegalArgumentException(TEMPLATE_BUT_NO_OPERATION_ERROR_MESSAGE.replaceAll(EMAIL, LETTER) + USAGE);

    return arguments;
  }

  private static void generateMessage(String templateCommand, String[] infoType, List<List<String>> customersIno, HashMap<String, String> arguments)
      throws IOException {
    if (!arguments.containsKey(templateCommand))
      return;
    // get the output directory and the email template file
    String outputDirectory = ABSOLUTE_PATH + arguments.get(OUTPUT_DIRECTORY_COMMAND);
    String templateFile = ABSOLUTE_PATH + arguments.get(templateCommand);

    Path emailTemplate = Paths.get(templateFile);
    Charset charset = StandardCharsets.UTF_8;

    for (List<String> strings : customersIno) {
      String content = Files.readString(emailTemplate, charset);
      for (int j = ZERO; j < infoType.length; j++) {
        String regex = DOUBLE_LEFT_BRACKET_REGEX + infoType[j] + DOUBLE_RIGHT_BRACKET_REGEX;
        content = content.replaceAll(regex, strings.get(j));
      }
      String outputFolder = templateCommand.equals(EMAIL_TEMPLATE_COMMAND) ? EMAIL_OUTPUT : LETTER_OUTPUT;
      Files.writeString(Path.of(outputDirectory + outputFolder + strings.get(0) + TXT), content, charset);
    }
  }

}


