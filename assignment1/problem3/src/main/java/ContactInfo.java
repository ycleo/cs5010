public class ContactInfo {

  private Name name;
  private String address;
  private String phone;
  private String email;

  public ContactInfo(Name name, String address, String phone, String email) {
    this.name = name;
    this.address = address;
    this.phone = phone;
    this.email = email;
  }

  public Name getName() {
    return this.name;
  }

  public String getAddress() {
    return this.address;
  }

  public String getPhone() {
    return this.phone;
  }

  public String getEmail() {
    return this.email;
  }

  public void setAddress(String newAddress) {
    this.address = newAddress;
  }

  public void setPhone(String newPhone) {
    this.phone = newPhone;
  }

  public void setEmail(String newEmail) {
    this.email = newEmail;
  }
}
