package problem2;

import java.util.HashMap;

public class VehicleSystem {

  private static final HashMap<String, Vehicle> vehicles = new HashMap<String, Vehicle>();
  private static Integer newCarWithinFiftyMiles = 0;

  public static Integer getNewCarWithinFiftyMiles() {
    return newCarWithinFiftyMiles;
  }

  public static void setNewCarWithinFiftyMiles(Integer num) {
    newCarWithinFiftyMiles = num;
  }
}

//  private static String generateId() {
//    final int length = 10;
//    Random random = new Random();
//
//    String id = random.ints(48, 123).limit(length)
//        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
//        .toString();
//    return id;
//  }
//
//  public static String newVehicleId() {
//    String id = "0123456789abcdef"; // 16-char long
//    while (vehicles.containsKey(id)) {
//      id = generateId();
//    }
//    return id;
//  }