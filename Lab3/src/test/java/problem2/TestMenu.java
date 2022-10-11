package problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMenu {

  private List<String> expectedMeals;
  private List<String> expectedDesserts;
  private List<String> expectedBeverages;
  private List<String> expectedDrinks;
  private Menu testMenu;
  private Menu testMenu2;

  @BeforeEach
  void setUp() {
    expectedMeals = new ArrayList<String>() {
      {
        add("Taco");
        add("Cheese Chips");
      }
    };

    expectedDesserts = new ArrayList<String>() {
      {
        add("Cake");
        add("Cookie");
      }
    };

    expectedBeverages = new ArrayList<String>() {
      {
        add("Juice");
        add("Coke");
      }
    };

    expectedDrinks = new ArrayList<String>() {
      {
        add("Wine");
        add("Beer");
      }
    };

    testMenu = new Menu(expectedMeals, expectedDesserts, expectedBeverages, expectedDrinks);
  }

  @Test
  void getMeals() {
    assertEquals(expectedMeals, testMenu.getMeals());
  }

  @Test
  void getDesserts() {
    assertEquals(expectedDesserts, testMenu.getDesserts());
  }

  @Test
  void getBeverages() {
    assertEquals(expectedBeverages, testMenu.getBeverages());
  }

  @Test
  void getDrinks() {
    assertEquals(expectedDrinks, testMenu.getDrinks());
  }

  @Test
  void setMeals() {
    List<String> newMeals = new ArrayList<String>() {
      {
        add("Chicken");
        add("Fries");
      }
    };
    testMenu.setMeals(newMeals);
    assertEquals(newMeals, testMenu.getMeals());
  }

  @Test
  void setDesserts() {
    List<String> newDesserts = new ArrayList<String>() {
      {
        add("Macronon");
        add("Icecream");
      }
    };
    testMenu.setDesserts(newDesserts);
    assertEquals(newDesserts, testMenu.getDesserts());
  }

  @Test
  void setBeverages() {
    List<String> newBeverages = new ArrayList<String>() {
      {
        add("Ice tea");
      }
    };
    testMenu.setBeverages(newBeverages);
    assertEquals(newBeverages, testMenu.getBeverages());
  }

  @Test
  void setDrinks() {
    List<String> newDrinks = new ArrayList<String>() {
      {
        add("White wine");
      }
    };
    testMenu.setDrinks(newDrinks);
    assertEquals(newDrinks, testMenu.getDrinks());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testMenu.equals(testMenu));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testMenu.equals(null));
  }

  @Test
  void testEquals_DifferentObject() {
    assertFalse(testMenu.equals(expectedBeverages));
  }

  @Test
  void testEquals_DifferentMeals() {
    List<String> newMeals = new ArrayList<String>() {
      {
        add("Chicken");
        add("Fries");
      }
    };
    testMenu2 = new Menu(newMeals, expectedDesserts, expectedBeverages, expectedDrinks);
    assertFalse(testMenu.equals(testMenu2));
  }

  @Test
  void testEquals_DifferentDesserts() {
    List<String> newDesserts = new ArrayList<String>() {
      {
        add("Macronon");
        add("Icecream");
      }
    };
    testMenu2 = new Menu(expectedMeals, newDesserts, expectedBeverages, expectedDrinks);
    assertFalse(testMenu.equals(testMenu2));
  }

  @Test
  void testEquals_DifferentBeverages() {
    List<String> newBeverages = new ArrayList<String>() {
      {
        add("Ice tea");
      }
    };
    testMenu2 = new Menu(expectedMeals, expectedDesserts, newBeverages, expectedDrinks);
    assertFalse(testMenu.equals(testMenu2));
  }

  @Test
  void testEquals_DifferentDrinks() {
    List<String> newDrinks = new ArrayList<String>() {
      {
        add("White wine");
      }
    };
    testMenu2 = new Menu(expectedMeals, expectedDesserts, expectedBeverages, newDrinks);
    assertFalse(testMenu.equals(testMenu2));
  }

  @Test
  void testEquals_SameMenu() {
    testMenu2 = new Menu(expectedMeals, expectedDesserts, expectedBeverages, expectedDrinks);
    assertTrue(testMenu.equals(testMenu2));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(expectedMeals, expectedDesserts, expectedBeverages,
        expectedDrinks);
    assertEquals(expectedHashCode, testMenu.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "Menu{meals: [Taco, Cheese Chips], desserts: [Cake, Cookie], beverages: [Juice, Coke], drinks: [Wine, Beer]}";
    assertEquals(expectedString, testMenu.toString());
  }
}
