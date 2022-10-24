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
  private static String EMAIL_COMMAND = "--email";
  private static String EMAIL_TEMPLATE_COMMAND = "--email-template";
  private static String LETTER_COMMAND = "--letter";
  private static String LETTER_TEMPLATE_COMMAND = "--letter-template";
  private static String OUTPUT_DIRECTORY_COMMAND = "--output-dir";
  private static List<List<String>> customersIno = new ArrayList<>();

  public static void main(String[] args) throws IOException {

    // Loads the csv file into customers' information array
    // System.out.println(CUSTOMER_INFO_CSV_PATH);
    Scanner scan = new Scanner(new File(CUSTOMER_INFO_CSV_PATH));
    String[] infoType = scan.nextLine().split(INFO_DELIMITER);
    int infoTypeNum = infoType.length;

    while(scan.hasNext()) {
      String[] info = scan.nextLine().split(INFO_DELIMITER);
      if (info.length == infoTypeNum) {
        customersIno.add(Arrays.asList(info));
      }
    }

    for (int i = 0; i < customersIno.size(); i++) {
      System.out.println(customersIno.get(i));
    }
    System.out.println(customersIno.size());

    // Parse the command input
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
//    outputMessagesToDirectory(input, customersIno);
    scanner.close();
  }

  public List<Message> generateMessages(String input, List<CustomerInfo> allCustomersInfo) throws IOException {
    return null;
  }

  public static void outputMessagesToDirectory(String input, List<CustomerInfo> allCustomersInfo) throws IOException {

  }
}


