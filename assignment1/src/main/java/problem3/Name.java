package problem3;

/**
 * Represents the name of a tax filer with first name and last name
 *
 * @author Yi-Cheng Lee
 */
public class Name {

  private String firstName;
  private String lastName;

  /**
   * Constructor for class Name
   *
   * @param firstName the first name of tax filer
   * @param lastName  the last name of tax filer
   */
  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * gets the first name
   *
   * @return the first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * gets the last name
   *
   * @return the last name
   */
  public String getLastName() {
    return lastName;
  }
}
