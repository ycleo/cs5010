package problem2;

import java.util.UUID;

/**
 * Represents a Vehicle with its ID, manufacturing year, make and model, and manufacturer suggested
 * retail price
 *
 * @author Yi-Cheng Lee
 */
public abstract class Vehicle implements VehicleInterface {

  /**
   * the vehicle ID
   */
  protected String id;
  /**
   * the manufacturing year
   */
  protected Integer manufactureYear;
  /**
   * the make and model
   */
  protected MakeModel makeModel;
  /**
   * the manufacturer suggested retail price
   */
  protected Double mSRPrice;

  /**
   * Constructor for class Vehicle (the ID property will be automatically generated as a UUID for a
   * new Vehicle)
   *
   * @param manufactureYear the manufacturing year
   * @param makeModel       the make and model
   * @param mSRPrice        the manufacturer suggested retail price
   */
  public Vehicle(Integer manufactureYear, MakeModel makeModel, Double mSRPrice) {
    // generate new ID in vehicles database
    this.id = UUID.randomUUID().toString();
    this.manufactureYear = manufactureYear;
    this.makeModel = makeModel;
    this.mSRPrice = mSRPrice;
  }

  /**
   * gets the vehicle ID
   *
   * @return the vehicle ID
   */
  public String getId() {
    return this.id;
  }

  /**
   * gets the manufacturing year of the vehicle
   *
   * @return the manufacturing year of the vehicle
   */
  public Integer getManufactureYear() {
    return this.manufactureYear;
  }

  /**
   * gets the make and model of the vehicle
   *
   * @return MakeModel of the vehicle
   */
  public MakeModel getMakeModel() {
    return this.makeModel;
  }

  /**
   * gets the manufacturer suggested retail price of the vehicle
   *
   * @return the manufacturer suggested retail price of the vehicle
   */
  public Double getMSRPrice() {
    return this.mSRPrice;
  }
}
