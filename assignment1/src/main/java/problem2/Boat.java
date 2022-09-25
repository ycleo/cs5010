package problem2;

/**
 * Represents a Boat with its length, passenger number, and propulsion type
 *
 */
public class Boat extends Vessel {

  private final Float length;
  private final Integer numPassenger;
  private final PropulsionType propulsionType;

  /**
   *
   * @param manufactureYear the manufacturing year
   * @param makeModel       the make and model
   * @param mSRPrice        the manufacturer suggested retail price
   * @param length          the boat length
   * @param numPassenger    the boat passenger number
   * @param propulsionType  the boat propulsion type
   */
  public Boat(Integer manufactureYear, MakeModel makeModel, Double mSRPrice, Float length,
      Integer numPassenger, PropulsionType propulsionType) {
    super(manufactureYear, makeModel, mSRPrice);
    this.length = length;
    this.numPassenger = numPassenger;
    this.propulsionType = propulsionType;
  }

  /**
   * @return the boat length
   */
  public Float getLength() {
    return this.length;
  }

  /**
   * @return the passenger number
   */
  public Integer getNumPassenger() {
    return this.numPassenger;
  }

  /**
   * @return the propulsion type
   */
  public PropulsionType getPropulsionType() {
    return this.propulsionType;
  }

}

//  public static void main(String[] args) {
//    MakeModel makeModel = new MakeModel("Steel", "Honda");
//    Boat boat = new Boat(2022, makeModel, 2000.0, 90.8f, 10, PropulsionType.SAIL_POWER);
//    System.out.println(boat.getPropulsionType());
//  }
