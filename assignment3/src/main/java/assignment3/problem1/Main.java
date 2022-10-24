package assignment3.problem1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class Main {

  final public static String ABSOLUTE_PATH = new File(
      "").getAbsolutePath();  // ...../Student_ycleo/assignment3
  final public static int ZERO = 0;
  final public static int ONE = 1;
  final public static String EMAIL_TEMPLATE_COMMAND = "--email-template";
  final public static String LETTER_TEMPLATE_COMMAND = "--letter-template";
  final public static String CSV_IMPORT_COMMAND = "--csv-file";
  final public static String OUTPUT_DIRECTORY_COMMAND = "--output-dir";
  final private static List<List<String>> customersIno = new ArrayList<>();
  final private static String INFO_DELIMITER = ",(?=([^\\\"]|\\\"[^\\\"]*\\\")*$)";
  final private static String REMOVE_REDUNDANT_SPACE_REGEX = "\\s+";
  final private static String QUOTATION_MARK = "\"";
  final private static String EMPTY = "";
  final private static String SPACE = " ";

  public static void main(String[] args) throws IOException {
    System.out.println(ABSOLUTE_PATH);
    // Parse the command input
    Scanner commandScanner = new Scanner(System.in);
    String[] command = commandScanner.nextLine().strip()
        .replaceAll(REMOVE_REDUNDANT_SPACE_REGEX, SPACE).split(SPACE);
    commandScanner.close();

    // get the csv path, template files, and the output directory
    HashMap<String, String> arguments = CommandParser.getArguments(command);

    // Get the information types
    Scanner csvScanner = new Scanner(
        new File(ABSOLUTE_PATH.concat(arguments.get(CSV_IMPORT_COMMAND))));
    String[] infoType = csvScanner.nextLine().replaceAll(QUOTATION_MARK, EMPTY)
        .split(INFO_DELIMITER);

    // Loads the csv file into customers' information array
    while (csvScanner.hasNext()) {
      String[] info = csvScanner.nextLine().replaceAll(QUOTATION_MARK, EMPTY).split(INFO_DELIMITER);
      customersIno.add(Arrays.asList(info));
    }
    csvScanner.close();

    // generate email message
    MessageGenerator.generateMessage(EMAIL_TEMPLATE_COMMAND, infoType, customersIno, arguments);
    // generate letter message
    MessageGenerator.generateMessage(LETTER_TEMPLATE_COMMAND, infoType, customersIno, arguments);
  }
}


