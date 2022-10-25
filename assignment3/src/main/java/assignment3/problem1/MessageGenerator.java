package assignment3.problem1;

import static assignment3.problem1.StaticStrings.ABSOLUTE_PATH;
import static assignment3.problem1.StaticStrings.DASH;
import static assignment3.problem1.StaticStrings.DOUBLE_LEFT_BRACKET_REGEX;
import static assignment3.problem1.StaticStrings.DOUBLE_RIGHT_BRACKET_REGEX;
import static assignment3.problem1.StaticStrings.ONE;
import static assignment3.problem1.StaticStrings.OUTPUT_DIRECTORY_COMMAND;
import static assignment3.problem1.StaticStrings.SEND_TO;
import static assignment3.problem1.StaticStrings.TXT;
import static assignment3.problem1.StaticStrings.ZERO;
import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

/**
 * Message generator can generate different messages based on the template
 */
public class MessageGenerator {

  private HashMap<String, String> arguments;
  private String[] infoType;
  private List<List<String>> customersIno;

  /**
   * Constructs a Message Generator based on the command arguments and the loaded csv file
   *
   * @param csvLoader the csv loader that already contains customers' information
   * @param arguments A hash map contains the operations mapped to their arguments
   */
  public MessageGenerator(CSVLoader csvLoader, HashMap<String, String> arguments) {
    this.arguments = arguments;
    this.infoType = csvLoader.getInfoType();
    this.customersIno = csvLoader.getCustomersInfo();
  }

  /**
   * The function that can generate messages based on the template type
   *
   * @param templateCommand The command operation specify the template type
   * @throws IOException Related to the Path access operations
   */
  public void generateMessage(String templateCommand) throws IOException {
    if (arguments.containsKey(templateCommand)) {
      // get the output directory absolute path
      String outputDirectory = ABSOLUTE_PATH + this.arguments.get(OUTPUT_DIRECTORY_COMMAND);
      // write the information into the output directory
      writeToTextFile(templateCommand, outputDirectory);
    }
  }

  /**
   * Writes the contents into the specified text file
   *
   * @param templateCommand The command operation specify the template type
   * @param outputDirectory The directory path specified by the user for the output
   * @throws IOException Related to the Path access operations
   */
  private void writeToTextFile(String templateCommand, String outputDirectory) throws IOException {
    Path templatePath = Path.of(ABSOLUTE_PATH + this.arguments.get(templateCommand));

    int customerCount = ZERO;
    for (List<String> info : this.customersIno) {
      customerCount += ONE;
      String content = Files.readString(templatePath, UTF_8);
      for (int i = ZERO; i < infoType.length; i++) {
        String regex = DOUBLE_LEFT_BRACKET_REGEX + infoType[i] + DOUBLE_RIGHT_BRACKET_REGEX;
        content = content.replaceAll(regex, info.get(i));
      }
      String outputFilePath =
          outputDirectory + templateCommand + SEND_TO + customerCount + DASH + info.get(ZERO) + TXT;
      Files.writeString(Path.of(outputFilePath), content, UTF_8);
    }
  }
}
