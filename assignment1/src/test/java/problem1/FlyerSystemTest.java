package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class FlyerSystemTest {

  private FlyerSystem flyerSystem;
  private HashMap<String, FrequentFlyer> flyersMap;
  private String flyerId;
  private Name flyerName;
  private String flyerEmail;
  private FrequentFlyer flyer;

  @BeforeEach
  void setUp() throws NoSuchFieldException, IllegalAccessException, IllegalArgumentException {
    // set up the flyers database
    flyerSystem = new FlyerSystem();
    Class flyerSystemClass = flyerSystem.getClass();
    Field flyerSystemField = flyerSystemClass.getDeclaredField("flyers");
    flyerSystemField.setAccessible(true);
    flyersMap = (HashMap<String, FrequentFlyer>) flyerSystemField.get(flyerSystemClass);
    flyerId = "0123456789ab";
    flyerName = new Name("YC", "Leo", "Lee");
    flyerEmail = "leo@neu.edu";
    flyer = new FrequentFlyer(flyerId, flyerName, flyerEmail);
  }

  // test account ID exits in flyers database
  @Test
  void flyerExists() {
    flyersMap.put(flyerId, flyer);
    assertTrue(FlyerSystem.flyerExists(flyerId));
  }

  // test new frequent flyer was properly added in the database
  @Test
  void addFlyer() {
    FlyerSystem.addFlyer(flyer);
    assertTrue(flyersMap.containsValue(flyer));
  }

  // test adding an existing (duplicated) flyer will throw an exception
  @Test
  void addDuplicatedFlyer() throws IllegalArgumentException {
    flyersMap.put(flyerId, flyer);
    FrequentFlyer duplicatedFlyer = new FrequentFlyer(flyerId, flyerName, flyerEmail);
    Exception e = assertThrows(NoSuchElementException.class, () -> {
      FlyerSystem.addFlyer(duplicatedFlyer);
    });

    String expectedMessage = "Account ID " + flyerId + " already exists!";
    String actualMessage = e.getMessage();
    assertTrue(actualMessage.equals(expectedMessage));
  }

  // test flyers database can correctly fetch the flyer based on account ID
  @Test
  void getFlyer() {
    flyersMap.put(flyerId, flyer);
    assertTrue(flyer.equals(FlyerSystem.getFlyer(flyerId)));
  }

  @Test
  void removeFlyer() {
    flyersMap.put(flyerId, flyer);
    FlyerSystem.removeFlyer(flyer.getAccountId());
    assertFalse(flyersMap.containsKey(flyerId));
  }

  @AfterEach
  void afterEachTest() {
    flyersMap.clear();
  }
}

//  // test new account ID characters within unicode range
//  @Test
//  void testNewAccountIdUnicodeRange() {
//    String newAccountId = FlyersDatabase.newAccountId();
//
//    for (int i = 0; i < 12; i++) {
//      int cp = newAccountId.codePointAt(i);
//      assertTrue(cp >= 48 && cp < 123);
//    }
//  }
