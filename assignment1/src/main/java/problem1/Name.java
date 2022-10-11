package problem1;

/**
 * Represents the name of a frequent flyer with first name, middle name, and last name
 *
 * @author Yi-Cheng Lee
 */
public class Name {

  private String firstName;
  private String middleName;
  private String lastName;

  /**
   * Constructor for the class Name
   *
   * @param firstName  the first name
   * @param middleName the middle name
   * @param lastName   the last name
   */
  public Name(String firstName, String middleName, String lastName) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
  }

  /**
   * gets the first name
   *
   * @return the first name
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * gets the middle name
   *
   * @return the middle name
   */
  public String getMiddleName() {
    return this.middleName;
  }

  /**
   * gets the last name
   *
   * @return the last name
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * compare two Name object to determine they have the same contents of first, middle, and last
   * name
   *
   * @param nameCompare the Name object to be compared
   * @return boolean result of the comparison with the Name object
   */
  public boolean equals(Name nameCompare) {

    if (this == nameCompare) {
      return true;
    }
    if (nameCompare == null) {
      return false;
    }

    String firstNameCompare = nameCompare.getFirstName();
    String middleNameCompare = nameCompare.getMiddleName();
    String lastNameCompare = nameCompare.getLastName();

    return firstNameCompare.equals(this.firstName)
        && middleNameCompare.equals(this.middleName)
        && lastNameCompare.equals(this.lastName);
  }
}
