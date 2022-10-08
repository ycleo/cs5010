package problem2;

/**
 * Represents an abstract class Vessel (a subclass of Vehicle) with its manufacturing year, make and
 * model, and manufacturer suggested retail price
 *
 * @author Yi-Cheng Lee
 */
public abstract class Vessel extends Vehicle {

  /**
   * Constructor for class Vessel
   *
   * @param manufactureYear the manufacturing year
   * @param makeModel       the make and model
   * @param mSRPrice        the manufacturer suggested retail price
   */
  public Vessel(Integer manufactureYear, MakeModel makeModel, Double mSRPrice) {
    // generate new ID in vehicles database
    super(manufactureYear, makeModel, mSRPrice);
  }
}
