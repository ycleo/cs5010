package problem1;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

public class FlyersDatabaseTest {
  private static HashMap<String, FrequentFlyer> flyers = new HashMap<String, FrequentFlyer>();
  @Test
  void addFlyer(String name, String email) {
    FrequentFlyer newFlyer = new FrequentFlyer(name, email);
  }
}
