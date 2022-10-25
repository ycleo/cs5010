package assignment3.problem1;

import static assignment3.problem1.StaticStrings.CSV_IMPORT_COMMAND;
import static assignment3.problem1.StaticStrings.EMAIL_TEMPLATE_COMMAND;
import static assignment3.problem1.StaticStrings.LETTER_TEMPLATE_COMMAND;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Main function to auto-generate messages (email or letter) by taking user's commands to specify
 * the template file, csv file, and the output directory
 */
public class Main {

  /**
   * The main program to auto-generate messages and output to the specific directory
   *
   * @param args The command typed in by the user
   * @throws IOException Related to the Scanner IO
   */
  public static void main(String[] args) throws IOException {
    // Instantiate a command parser
    CommandParser commandParser = new CommandParser();

    // Parse the command input
    commandParser.parseCommand();

    // Get the command arguments: commands mapping to csv path, template files, and the output directory
    HashMap<String, String> arguments = commandParser.getCommandArguments();

    // Instantiate a csv loader with csv path provided
    CSVLoader csvLoader = new CSVLoader(arguments.get(CSV_IMPORT_COMMAND));

    // Instantiate a message generator
    MessageGenerator messageGenerator = new MessageGenerator(csvLoader, arguments);
    // generate email message
    messageGenerator.generateMessage(EMAIL_TEMPLATE_COMMAND);
    // generate letter message
    messageGenerator.generateMessage(LETTER_TEMPLATE_COMMAND);
  }
}


