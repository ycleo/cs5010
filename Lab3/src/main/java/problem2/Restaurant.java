package problem2;

import java.util.Objects;

/**
 * Class Restaurant contains information about name, address, menu, and the open status
 */
public class Restaurant {

  private String name;
  private Address address;
  private Menu menu;
  private boolean open;

  /**
   * Constructs a new Restaurant, based upon all the provided input parameters
   *
   * @param name    Name object containing first name and last name
   * @param address Address object containing String contents
   * @param menu    Menu object containing List object contents
   * @param open    boolean about the open status
   */
  public Restaurant(String name, Address address, Menu menu, boolean open) {
    this.name = name;
    this.address = address;
    this.menu = menu;
    this.open = open;
  }

  /**
   * Returns restaurant name as a String
   *
   * @return restaurant name
   */
  public String getName() {
    return name;
  }

  /**
   * Returns restaurant address as an Address object
   *
   * @return restaurant address
   */
  public Address getAddress() {
    return address;
  }

  /**
   * Returns restaurant menu as a Menu object
   *
   * @return restaurant menu
   */
  public Menu getMenu() {
    return menu;
  }

  /**
   * Returns restaurant open status as a boolean
   *
   * @return restaurant open status
   */
  public boolean isOpen() {
    return open;
  }

  /**
   * Sets restaurant name with a new name String
   *
   * @param name restaurant new name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Sets restaurant address with a new Address
   *
   * @param address new restaurant address
   */
  public void setAddress(Address address) {
    this.address = address;
  }

  /**
   * Sets restaurant menu with a new menu
   *
   * @param menu new restaurant menu
   */
  public void setMenu(Menu menu) {
    this.menu = menu;
  }

  /**
   * Sets restaurant open status with a new open status
   *
   * @param status restaurant open status
   */
  public void setOpen(boolean status) {
    this.open = status;
  }

  /**
   * Tests two Restaurant objects have the same property values
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
    Restaurant restaurant = (Restaurant) o;
    return Objects.equals(name, restaurant.getName())
        && address.equals(restaurant.getAddress())
        && menu.equals(restaurant.getMenu())
        && open == restaurant.isOpen();
  }

  /**
   * Returns the hash code of the restaurant object
   *
   * @return int hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, address.hashCode(), menu.hashCode(), open);
  }

  /**
   * Returns the string represents the restaurant information
   *
   * @return String about the restaurant
   */
  @Override
  public String toString() {
    return "Restaurant{" +
        "name: " + name +
        "; address: " + address.getStreetAndNumber() + ' ' + address.getCity() + ' '
        + address.getState() + ' ' + address.getCountry() + ' ' + address.getZIPCode() +
        "; menu: meals: " + menu.getMeals().toString() + ", desserts: " + menu.getDesserts()
        .toString() + ", beverages: "
        + menu.getBeverages().toString() + ", drinks: " + menu.getDrinks().toString() +
        "; open: " + open +
        "}";
  }
}
