package assignment3.problem1;

import static assignment3.problem1.StaticStrings.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * CSVLoader class to read the csv file and extract the customers' information
 */
public class CSVLoader {

  private String[] infoType;
  private List<List<String>> customersInfo;
  private Scanner csvScanner;

  /**
   * Constructs CSVLoader with the path of the csv file
   *
   * @param path the path of the csv file
   * @throws FileNotFoundException Exception if the csv file cannot be found
   */
  public CSVLoader(String path) throws FileNotFoundException {
    this.csvScanner = new Scanner(new File(ABSOLUTE_PATH.concat(path)));
    this.infoType = trimQuotationMark(this.csvScanner.nextLine().split(INFO_DELIMITER));
    this.customersInfo = new ArrayList<>();
    while (this.csvScanner.hasNext()) {
      String[] info = trimQuotationMark(this.csvScanner.nextLine().split(INFO_DELIMITER));
      this.customersInfo.add(Arrays.asList(info));
    }
    this.csvScanner.close();
  }

  /**
   * Gets the information types (1st row in the csv file)
   *
   * @return A string list that contains the information types
   */
  public String[] getInfoType() {
    return this.infoType;
  }

  /**
   * Gets the customers' information
   *
   * @return A two-dimensional List contains each customer's information per row
   */
  public List<List<String>> getCustomersInfo() {
    return this.customersInfo;
  }

  /**
   * Trims the quotation mark extracting from the csv file
   *
   * @param csvRow A certain row from the csv file
   * @return The row that the quotation marks of every element has been removed
   */
  private String[] trimQuotationMark(String[] csvRow) {
    for (int i = ZERO; i < csvRow.length; i++) {
      csvRow[i] = csvRow[i].replaceAll(QUOTATION_MARK, EMPTY);
    }
    return csvRow;
  }
}
