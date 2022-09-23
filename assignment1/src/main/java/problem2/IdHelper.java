package problem2;

import java.util.Random;

public class IdHelper {

  private static String generateId() {
    int length = 16;
    Random random = new Random();

    String id = random.ints(48, 123).limit(length)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
    return id;
  }

  private static boolean vehicleIdExists(String id) {
    return Vehicle.vehicles.contains(id);
  }

  public static String newVehicleId() {
    String id = "0123456789abcdef"; // 16-char long
    while (vehicleIdExists(id)) {
      id = generateId();
    }
    return id;
  }

}
