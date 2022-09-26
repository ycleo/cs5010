package problem3;

/**
 * Represents a package of contact information of certain tax filer with his/her name, address,
 * phone number, and email address
 *
 * @author Yi-Cheng Lee
 */
public class ContactInfo {

  private Name name;
  private String address;
  private String phone;
  private String email;

  /**
   * Constructor for class ContactInfo
   *
   * @param name    the name of the tax filer
   * @param address the address of the tax filer
   * @param phone   the phone of the tax filer
   * @param email   the email of the tax filer
   */
  public ContactInfo(Name name, String address, String phone, String email) {
    this.name = name;
    this.address = address;
    this.phone = phone;
    this.email = email;
  }

  /**
   * gets the name of the tax filer
   *
   * @return the name of the tax filer
   */
  public Name getName() {
    return this.name;
  }

  /**
   * gets the address of the tax filer
   *
   * @return the address of the tax filer
   */
  public String getAddress() {
    return this.address;
  }

  /**
   * gets the phone of the tax filer
   *
   * @return the phone of the tax filer
   */
  public String getPhone() {
    return this.phone;
  }

  /**
   * gets the email of the tax filer
   *
   * @return the email of the tax filer
   */
  public String getEmail() {
    return this.email;
  }

}
