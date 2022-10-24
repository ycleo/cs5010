package assignment3.problem1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class MessageGenerator {
  private static String ABSOLUTE_PATH = new File("").getAbsolutePath();
  private static String CUSTOMER_INFO_CSV_PATH = ABSOLUTE_PATH.concat("/src/main/java/assignment3/problem1/insurance-company-members.csv");
  private static String INFO_DELIMITER = ",(?=([^\\\"]|\\\"[^\\\"]*\\\")*$)";
  private static String REMOVE_REDUNDANT_SPACE_REGEX = "\\s+";
  private static String SPACE = " ";
  private static String EMAIL_COMMAND = "--email";
  private static String EMAIL_TEMPLATE_COMMAND = "--email-template";
  private static String LETTER_COMMAND = "--letter";
  private static String LETTER_TEMPLATE_COMMAND = "--letter-template";
  private static String OUTPUT_DIRECTORY_COMMAND = "--output-dir";
  private static List<List<String>> customersIno = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    // Get the information types
    Scanner csvScanner = new Scanner(new File(CUSTOMER_INFO_CSV_PATH));
    String[] infoType = csvScanner.nextLine().split(INFO_DELIMITER);
    int infoTypeNum = infoType.length;

    // Loads the csv file into customers' information array
    while(csvScanner.hasNext()) {
      String[] info = csvScanner.nextLine().split(INFO_DELIMITER);
        customersIno.add(Arrays.asList(info));
    }
    csvScanner.close();

    // Parse the command input
    Scanner commandScanner = new Scanner(System.in);
    String[] command = commandScanner.nextLine().strip().replaceAll(REMOVE_REDUNDANT_SPACE_REGEX, SPACE).split(SPACE);
    outputMessagesToDirectory(command, customersIno);
    commandScanner.close();
  }

  private static void outputMessagesToDirectory(String[] command, List<List<String>> customersIno) throws IOException {

  }

  public List<Message> generateMessages(String[] command, List<List<String>> customersIno) throws IOException {
    return null;
  }
}


