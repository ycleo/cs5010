package problem3;

public class Name {

  private String firstName;
  private String lastName;

  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  private String getFirstName() {
    return firstName;
  }

  private String getLastName() {
    return lastName;
  }
}
