package problem2;

import java.util.HashMap;

/**
 * Represents the interface for the Vehicle class with methods including getId(),
 * getManufactureYear(), getMakeModel(), and getMSRPrice()
 *
 * @author Yi-Cheng Lee
 */
public interface VehicleInterface {

  /**
   * gets the vehicle ID
   *
   * @return the vehicle ID
   */
  String getId();

  /**
   * gets the manufacturing year
   *
   * @return the manufacturing year
   */
  Integer getManufactureYear();

  /**
   * gets the make and model
   *
   * @return the make and model (MakeModel object)
   */
  MakeModel getMakeModel();

  /**
   * gets the manufacturer suggested retail price
   *
   * @return the manufacturer suggested retail price
   */
  Double getMSRPrice(); // MSRP: Manufacturer Suggested Retail Price
}
