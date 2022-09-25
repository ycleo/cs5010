package problem2;

import java.util.HashMap;

public interface VehicleInterface {

  String getId();

  Integer getManufactureYear();

  MakeModel getMakeModel();

  Double getMSRPrice(); // MSRP: Manufacturer Suggested Retail Price
}
