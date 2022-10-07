package problem1;

import java.util.Objects;

/**
 * Class Name contains information about the first name and last name
 */
public class Name {

  private String firstName;
  private String lastName;

  /**
   * Constructs a new Name based on first name and last name
   *
   * @param firstName first name
   * @param lastName  last name
   */
  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Returns the first name of the Name object
   *
   * @return String first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Returns the last name of the Name object
   *
   * @return String last name
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Test two Name objects have same first name and last name
   *
   * @param o
   * @return boolean
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Name name = (Name) o;
    return Objects.equals(firstName, name.firstName) && Objects.equals(lastName, name.lastName);
  }

  /**
   * Returns the hash code of the Name object
   *
   * @return int the hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }

  /**
   * Returns the String represents the contents of the Name object
   *
   * @return String that represents the contents of the Name object
   */
  @Override
  public String toString() {
    return "Name{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
  }
}
