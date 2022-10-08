package problem2;

import java.util.HashMap;

/**
 * Represents a VehicleSystem with its static HashMap as the vehicles database
 *
 * @author Yi-Cheng Lee
 */
public class VehicleSystem {

  private static final HashMap<String, Vehicle> vehicles = new HashMap<String, Vehicle>();
  private static Integer newCarWithinFiftyMiles = 0;

  /**
   * gets the number of new car within 50 miles
   *
   * @return the number of new car within 50 miles
   */
  public static Integer getNewCarWithinFiftyMiles() {
    return newCarWithinFiftyMiles;
  }

  /**
   * sets the number of new car within 50 miles
   *
   * @param num the number of new car within 50 miles
   */
  public static void setNewCarWithinFiftyMiles(Integer num) {
    newCarWithinFiftyMiles = num;
  }
}