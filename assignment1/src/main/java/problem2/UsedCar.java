package problem2;

/**
 * Represents an UsedCar (a subclass of Car) with its manufacturing year, make and model,
 * manufacturer suggested retail price, car mileage, the number of previous owners, and the number
 * of minor accidents
 *
 * @author Yi-Cheng Lee
 */
public class UsedCar extends Car {

  private Integer numPrevOwner;
  private Integer numMinorAccident;

  /**
   * Constructor for class UsedCar
   *
   * @param manufactureYear  the manufacturing year
   * @param makeModel        the make and model
   * @param mSRPrice         the manufacturer suggested retail price
   * @param mileage          the car mileage
   * @param numPrevOwner     the number of previous owners
   * @param numMinorAccident the number of minor accidents
   */
  public UsedCar(Integer manufactureYear, MakeModel makeModel, Double mSRPrice, Integer mileage,
      Integer numPrevOwner, Integer numMinorAccident) {
    super(manufactureYear, makeModel, mSRPrice, mileage);
    this.numPrevOwner = numPrevOwner;
    this.numMinorAccident = numMinorAccident;
  }

  /**
   * gets the number of previous owners
   *
   * @return the number of previous owners
   */
  public Integer getNumPrevOwner() {
    return this.numPrevOwner;
  }

  /**
   * gets the number of minor accidents
   *
   * @return the number of minor accidents
   */
  public Integer getNumMinorAccident() {
    return this.numMinorAccident;
  }

  /**
   * sets the number of previous owners
   *
   * @param numPrevOwner the number of previous owners
   */
  public void setNumPrevOwner(Integer numPrevOwner) {
    this.numPrevOwner = numPrevOwner;
  }

  /**
   * sets the number of minor accidents
   *
   * @param numMinorAccident the number of minor accidents
   */
  public void setNumMinorAccident(Integer numMinorAccident) {
    this.numMinorAccident = numMinorAccident;
  }
}
