package problem2;

import java.util.HashMap;

public interface Vehicle {

  HashMap<String, Vehicle> vehicles = new HashMap<String, Vehicle>();

  String getId();

  Integer getManufactureYear();

  MakeModel getMakeModel();

  Double getMSRPrice(); // MSRP: Manufacturer Suggested Retail Price
}
