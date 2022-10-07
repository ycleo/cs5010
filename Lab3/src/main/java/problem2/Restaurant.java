package problem2;

import java.util.Objects;

public class Restaurant {

  private String name;
  private Address address;
  private Menu menu;
  private boolean open;

  public Restaurant(String name, Address address, Menu menu, boolean open) {
    this.name = name;
    this.address = address;
    this.menu = menu;
    this.open = open;
  }

  public String getName() {
    return name;
  }

  public Address getAddress() {
    return address;
  }

  public Menu getMenu() {
    return menu;
  }

  public boolean isOpen() {
    return open;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public void setMenu(Menu menu) {
    this.menu = menu;
  }

  public void setOpen(boolean status) {
    this.open = status;
  }

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
        && Objects.equals(address, restaurant.getAddress())
        && Objects.equals(menu, restaurant.getMenu())
        && open == restaurant.isOpen();
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, address, menu, open);
  }

  @Override
  public String toString() {
    return "Restaurant{" +
        "name: " + name +
        ", address: " + address.getStreetAndNumber() + ' ' + address.getCity() + ' '
        + address.getState() + ' ' + address.getCountry() + ' ' + address.getZIPCode() +
        ", menu: " + menu.getMeals().toString() + ' ' + menu.getDesserts().toString() + ' '
        + menu.getBeverages().toString() + ' ' + menu.getDrinks().toString() +
        ", open: " + open +
        "}";
  }
}
