package problem2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestRestaurant {

  private String expectedName;
  private Address expectedAddress;
  private Menu expectedMenu;
  private boolean expectedOpen;
  private Restaurant testRestaurant;
  private Restaurant testRestaurant2;

  @BeforeEach
  void setUp() {
    expectedName = "Taco Bell";
    expectedAddress = new Address("Ivory 123", "Irving", "99999", "CA", "US");
    expectedMenu = new Menu(new ArrayList<String>(), new ArrayList<String>(),
        new ArrayList<String>(), new ArrayList<String>());
    expectedOpen = true;
    testRestaurant = new Restaurant(expectedName, expectedAddress, expectedMenu, expectedOpen);
  }

  @Test
  void getName() {
    assertEquals(expectedName, testRestaurant.getName());
  }

  @Test
  void getAddress() {
    assertEquals(expectedAddress, testRestaurant.getAddress());
  }

  @Test
  void getMenu() {
    assertEquals(expectedMenu, testRestaurant.getMenu());
  }

  @Test
  void isOpen() {
    assertTrue(testRestaurant.isOpen());
  }

  @Test
  void setName() {
    testRestaurant.setName("Taco Belle");
    assertEquals("Taco Belle", testRestaurant.getName());
  }

  @Test
  void setAddress() {
    Address newAddress = new Address("1112 S", "Phoenix", "66666", "AZ", "US");
    testRestaurant.setAddress(newAddress);
    assertEquals(newAddress, testRestaurant.getAddress());
  }

  @Test
  void setMenu() {
    List<String> expectedMeals = new ArrayList<>() {
      {
        add("Taco");
        add("Cheese Chips");
      }
    };

    List<String> expectedDesserts = new ArrayList<String>() {
      {
        add("Cake");
        add("Cookie");
      }
    };

    List<String> expectedBeverages = new ArrayList<String>() {
      {
        add("Juice");
        add("Coke");
      }
    };

    List<String> expectedDrinks = new ArrayList<String>() {
      {
        add("Wine");
        add("Beer");
      }
    };

    Menu newMenu = new Menu(expectedMeals, expectedDesserts, expectedBeverages, expectedDrinks);
    testRestaurant.setMenu(newMenu);
    assertEquals(newMenu, testRestaurant.getMenu());
  }

  @Test
  void setOpen() {
    testRestaurant.setOpen(false);
    assertFalse(testRestaurant.isOpen());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testRestaurant.equals(testRestaurant));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testRestaurant.equals(null));
  }

  @Test
  void testEquals_DifferentObject() {
    assertFalse(testRestaurant.equals(expectedAddress));
  }

  @Test
  void testEquals_DifferentName() {
    String otherName = "jack in the box";
    testRestaurant2 = new Restaurant(otherName, expectedAddress, expectedMenu, expectedOpen);
    assertFalse(testRestaurant.equals(testRestaurant2));
  }

  @Test
  void testEquals_DifferentAddress() {
    testRestaurant2 = new Restaurant(expectedName,
        new Address("12", "Seattle", "66666", "WA", "US"), expectedMenu, expectedOpen);
    assertFalse(testRestaurant.equals(testRestaurant2));
  }

  @Test
  void testEquals_DifferentMenu() {
    List<String> otherMeals =
        new ArrayList<String>() {
          {
            add("Sushi");
          }
        };
    Menu otherMenu = new Menu(otherMeals, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    testRestaurant2 = new Restaurant(expectedName, expectedAddress, otherMenu, expectedOpen);
    assertFalse(testRestaurant.equals(testRestaurant2));
  }

  @Test
  void testEquals_DifferentOpenStatus() {
    testRestaurant2 = new Restaurant(expectedName, expectedAddress, expectedMenu, false);
    assertFalse(testRestaurant.equals(testRestaurant2));
  }

  @Test
  void testEquals_SameRestaurant() {
    testRestaurant2 = new Restaurant(expectedName, expectedAddress, expectedMenu, expectedOpen);
    assertTrue(testRestaurant.equals(testRestaurant2));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(expectedName, expectedAddress.hashCode(),
        expectedMenu.hashCode(), expectedOpen);
    assertEquals(expectedHashCode, testRestaurant.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "Restaurant{name: Taco Bell; address: Ivory 123 Irving CA US 99999; menu: meals: [], desserts: [], beverages: [], drinks: []; open: true}";
    assertEquals(expectedString, testRestaurant.toString());
  }
}
