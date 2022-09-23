package problem2;

import java.util.HashSet;

public interface Vehicle {
  HashSet<String> vehicles = new HashSet<String>();
  String getId();
  Integer getManufactureYear();
  MakeModel getMakeModel();
  Double getMSRPrice(); // MSRP: Manufacturer Suggested Retail Price
}
