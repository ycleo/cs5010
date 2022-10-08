package problem2;

/**
 * Represents a Boat (a subclass of Vessel) with its length, passenger number, and propulsion type
 *
 * @author Yi-Cheng Lee
 */
public class Boat extends Vessel {

  private final Float length;
  private final Integer numPassenger;
  private final PropulsionType propulsionType;

  /**
   * Constructor for class Boat
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
   * gets the boat length
   *
   * @return the boat length
   */
  public Float getLength() {
    return this.length;
  }

  /**
   * gets the passenger number
   *
   * @return the passenger number
   */
  public Integer getNumPassenger() {
    return this.numPassenger;
  }

  /**
   * gets the propulsion type
   *
   * @return the propulsion type
   */
  public PropulsionType getPropulsionType() {
    return this.propulsionType;
  }

}
