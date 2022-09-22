package assignment1.problem2;

import java.util.HashMap;

public class VehicleManagementSystem {

  private HashMap<String, Vehicle> vehilcles = new HashMap<String, Vehicle>();

  public void addVehicle(Vehicle vehicle) {
    this.vehilcles.put(vehicle.getId(), vehicle);
  }

  public void removeVehicle(String id) {
    this.vehilcles.remove(id);
  }
}
