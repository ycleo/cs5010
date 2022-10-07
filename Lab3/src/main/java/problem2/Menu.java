package problem2;

import java.util.List;
import java.util.Objects;

/**
 * Class Menu contains information about meals, desserts, beverages, and drinks
 */
public class Menu {

  private List<String> meals;
  private List<String> desserts;
  private List<String> beverages;
  private List<String> drinks;

  /**
   * Constructs a new menu, based upon all the provided input parameters
   *
   * @param meals     List object containing meal Strings
   * @param desserts  List object containing dessert Strings
   * @param beverages List object containing beverage Strings
   * @param drinks    List object containing drink Strings
   */
  public Menu(List<String> meals, List<String> desserts, List<String> beverages,
      List<String> drinks) {
    this.meals = meals;
    this.desserts = desserts;
    this.beverages = beverages;
    this.drinks = drinks;
  }

  /**
   * Returns meals as a List object
   *
   * @return meals
   */
  public List<String> getMeals() {
    return meals;
  }

  /**
   * Returns desserts as a List object
   *
   * @return desserts
   */
  public List<String> getDesserts() {
    return desserts;
  }

  /**
   * Returns beverages as a List object
   *
   * @return beverages
   */
  public List<String> getBeverages() {
    return beverages;
  }

  /**
   * Returns drinks as a List object
   *
   * @return drinks
   */
  public List<String> getDrinks() {
    return drinks;
  }

  /**
   * Sets meals with a new meals List object
   *
   * @param meals new meals List object
   */
  public void setMeals(List<String> meals) {
    this.meals = meals;
  }

  /**
   * Sets desserts with a new desserts List object
   *
   * @param desserts new desserts List object
   */
  public void setDesserts(List<String> desserts) {
    this.desserts = desserts;
  }

  /**
   * Sets beverages with a new beverages List object
   *
   * @param beverages new beverages List object
   */
  public void setBeverages(List<String> beverages) {
    this.beverages = beverages;
  }

  /**
   * Sets drinks with a new drinks List object
   *
   * @param drinks new drinks List object
   */
  public void setDrinks(List<String> drinks) {
    this.drinks = drinks;
  }

  /**
   * Tests two Menu objects have the same property values
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
    Menu menu = (Menu) o;
    return Objects.equals(meals, menu.getMeals())
        && Objects.equals(desserts, menu.getDesserts())
        && Objects.equals(beverages, menu.getBeverages())
        && Objects.equals(drinks, menu.getDrinks());
  }

  /**
   * Returns the hash code of the menu object
   *
   * @return int hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(meals, desserts, beverages, drinks);
  }

  /**
   * Returns the string represents the menu information
   *
   * @return String about the menu
   */
  @Override
  public String toString() {
    return "Menu{" +
        "meals: " + meals.toString() +
        ", desserts: " + desserts.toString() +
        ", beverages: " + beverages.toString() +
        ", drinks: " + drinks.toString() +
        "}";
  }
}
