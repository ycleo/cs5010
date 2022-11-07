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
import java.util.Objects;

/**
 * Message generator can generate different messages based on the template
 */
public class MessageGenerator {

  private HashMap<String, String> arguments;
  private String[] infoType;
  private List<List<String>> customersInfo;

  /**
   * Constructs a Message Generator based on the command arguments and the loaded csv information
   *
   * @param infoType      Information type
   * @param customersInfo Customers' information
   * @param arguments     A hash map contains the operations mapped to their arguments
   */
  public MessageGenerator(String[] infoType, List<List<String>> customersInfo,
      HashMap<String, String> arguments) {
    this.arguments = arguments;
    this.infoType = infoType;
    this.customersInfo = customersInfo;
  }

  /**
   * The function that can generate messages based on the template type
   *
   * @param templateCommand The command operation specify the template type
   * @return boolean value that the message was generated successfully
   * @throws IOException Related to the Path access operations
   */
  public boolean generateMessage(String templateCommand) throws IOException {
    if (arguments.containsKey(templateCommand)) {
      // get the output directory absolute path
      String path = this.arguments.get(OUTPUT_DIRECTORY_COMMAND);
      if (!path.contains(ABSOLUTE_PATH)) {
        path = ABSOLUTE_PATH + path;
      }
      String outputDirectory = path;
      // write the information into the output directory
      writeToTextFile(templateCommand, outputDirectory);
      return true;
    }
    return false;
  }

  /**
   * Writes the contents into the specified text file
   *
   * @param templateCommand The command operation specify the template type
   * @param outputDirectory The directory path specified by the user for the output
   * @throws IOException Related to the Path access operations
   */
  private void writeToTextFile(String templateCommand, String outputDirectory) throws IOException {
    String templatePathString = this.arguments.get(templateCommand);
    if (!templatePathString.contains(ABSOLUTE_PATH)) {
      templatePathString = ABSOLUTE_PATH + templatePathString;
    }
    Path templatePath = Path.of(templatePathString);

    int customerCount = ZERO;
    for (List<String> info : this.customersInfo) {
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

  /**
   * Tests the object equals to the message generator or not
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
    MessageGenerator messageGenerator = (MessageGenerator) o;
    return this.arguments.equals(messageGenerator.arguments) &&
        this.infoType.equals(messageGenerator.infoType) &&
        this.customersInfo.equals(messageGenerator.customersInfo);
  }

  /**
   * Return the hash code represents the message generator
   *
   * @return the hash code represents the message generator
   */
  public int hashCode() {
    return Objects.hash(this.arguments, this.infoType, this.customersInfo);
  }

  /**
   * Returns the string represents the message generator
   *
   * @return the string represents the message generator
   */
  public String toString() {
    return "CommandParser: { "
        + "command arguments: " + this.arguments.toString()
        + "; information type: " + this.infoType.toString()
        + "; customers' information: " + this.customersInfo.toString()
        + " }";
  }
}
