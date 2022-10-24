package assignment3.problem1;

import static assignment3.problem1.Main.ABSOLUTE_PATH;
import static assignment3.problem1.Main.EMAIL_TEMPLATE_COMMAND;
import static assignment3.problem1.Main.OUTPUT_DIRECTORY_COMMAND;
import static assignment3.problem1.Main.ZERO;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class MessageGenerator {

  final private static String DOUBLE_LEFT_BRACKET_REGEX = "\\[\\[";
  final private static String DOUBLE_RIGHT_BRACKET_REGEX = "\\]\\]";
  final private static String EMAIL_OUTPUT = "/emails-output/email-to-";
  final private static String LETTER_OUTPUT = "/letters-output/letter-to-";
  final private static String TXT = ".txt";

  public static void generateMessage(String templateCommand, String[] infoType,
      List<List<String>> customersIno, HashMap<String, String> arguments)
      throws IOException {
    if (!arguments.containsKey(templateCommand)) {
      return;
    }
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
      String outputFolder =
          templateCommand.equals(EMAIL_TEMPLATE_COMMAND) ? EMAIL_OUTPUT : LETTER_OUTPUT;
      Files.writeString(Path.of(outputDirectory + outputFolder + strings.get(ZERO) + TXT), content,
          charset);
    }
  }
}
