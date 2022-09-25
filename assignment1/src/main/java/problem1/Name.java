package problem1;

public class Name {

  private String firstName;
  private String middleName;
  private String lastName;

  public Name(String firstName, String middleName, String lastName) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getMiddleName() {
    return this.middleName;
  }

  public String getLastName() {
    return this.lastName;
  }

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
