package problem2;

import java.util.Objects;

public class Address {

  private String streetAndNumber;
  private String city;
  private String ZIPCode;
  private String state;
  private String country;

  public Address(String streetAndNumber, String city, String ZIPCode, String state,
      String country) {
    this.streetAndNumber = streetAndNumber;
    this.city = city;
    this.ZIPCode = ZIPCode;
    this.state = state;
    this.country = country;
  }

  public String getStreetAndNumber() {
    return this.streetAndNumber;
  }

  public String getCity() {
    return this.city;
  }

  public String getZIPCode() {
    return this.ZIPCode;
  }

  public String getState() {
    return this.state;
  }

  public String getCountry() {
    return this.country;
  }

  public void setStreetAndNumber(String streetAndNumber) {
    this.streetAndNumber = streetAndNumber;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setZIPCode(String ZIPCode) {
    this.ZIPCode = ZIPCode;
  }

  public void setState(String state) {
    this.state = state;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Address address = (Address) o;
    return Objects.equals(streetAndNumber, address.streetAndNumber)
        && Objects.equals(city, address.city)
        && Objects.equals(ZIPCode, address.ZIPCode)
        && Objects.equals(state, address.state)
        && Objects.equals(country, address.country);
  }

  @Override
  public int hashCode() {
    return Objects.hash(streetAndNumber, city, ZIPCode, state, country);
  }

  @Override
  public String toString() {
    return "Address{" +
        "street and number: " + streetAndNumber +
        ", city: " + city +
        ", ZIP code: " + ZIPCode +
        ", state: " + state +
        ", country: " + country +
        "}";
  }
}


