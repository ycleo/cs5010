package problem2;

import java.util.Objects;

/**
 * Class Address contains information about street and number, city, ZIP code, state, and country
 */
public class Address {

  private String streetAndNumber;
  private String city;
  private String ZIPCode;
  private String state;
  private String country;

  /**
   * Constructs a new address, based upon all the provided input parameters.
   *
   * @param streetAndNumber street and number
   * @param city            city
   * @param ZIPCode         ZIP code
   * @param state           state
   * @param country         country
   */
  public Address(String streetAndNumber, String city, String ZIPCode, String state,
      String country) {
    this.streetAndNumber = streetAndNumber;
    this.city = city;
    this.ZIPCode = ZIPCode;
    this.state = state;
    this.country = country;
  }

  /**
   * Returns street and number as a String
   *
   * @return String street and number
   */
  public String getStreetAndNumber() {
    return this.streetAndNumber;
  }

  /**
   * Returns city as a String
   *
   * @return String city
   */
  public String getCity() {
    return this.city;
  }

  /**
   * Returns ZIP code as a String
   *
   * @return String ZIP code
   */
  public String getZIPCode() {
    return this.ZIPCode;
  }

  /**
   * Returns state as a String
   *
   * @return String state
   */
  public String getState() {
    return this.state;
  }

  /**
   * Returns country as a String
   *
   * @return String country
   */
  public String getCountry() {
    return this.country;
  }

  /**
   * Sets street and number with a new street and number String
   *
   * @param streetAndNumber new street and number
   */
  public void setStreetAndNumber(String streetAndNumber) {
    this.streetAndNumber = streetAndNumber;
  }

  /**
   * Sets city with a new city String
   *
   * @param city new city
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * Sets ZIP code with a new ZIP code
   *
   * @param ZIPCode new ZIP code
   */
  public void setZIPCode(String ZIPCode) {
    this.ZIPCode = ZIPCode;
  }

  /**
   * Sets state with a new state String
   *
   * @param state new state
   */
  public void setState(String state) {
    this.state = state;
  }

  /**
   * Sets country with a new country String
   *
   * @param country new country
   */
  public void setCountry(String country) {
    this.country = country;
  }

  /**
   * Tests two Address objects have the same property values
   *
   * @param o tested object
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
    Address address = (Address) o;
    return Objects.equals(streetAndNumber, address.streetAndNumber)
        && Objects.equals(city, address.city)
        && Objects.equals(ZIPCode, address.ZIPCode)
        && Objects.equals(state, address.state)
        && Objects.equals(country, address.country);
  }

  /**
   * Returns the hash code of the address object
   *
   * @return int hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(streetAndNumber, city, ZIPCode, state, country);
  }

  /**
   * Returns the string represents the address information
   *
   * @return String about the address
   */
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


