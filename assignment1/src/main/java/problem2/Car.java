package problem2;

/**
 * Represents an abstract class Car (a subclass of Vehicle) with its manufacturing year, make and
 * model, manufacturer suggested retail price, and car mileage
 *
 * @author Yi-Cheng Lee
 */
public abstract class Car extends Vehicle {

  /**
   * the car mileage
   */
  protected Integer mileage;

  /**
   * Constructor for class Car
   *
   * @param manufactureYear the manufacturing year
   * @param makeModel       the make and model
   * @param mSRPrice        the manufacturer suggested retail price
   * @param mileage         the car mileage
   */
  public Car(Integer manufactureYear, MakeModel makeModel, Double mSRPrice, Integer mileage) {
    super(manufactureYear, makeModel, mSRPrice);
    this.mileage = mileage;
  }

  /**
   * gets the car mileage
   *
   * @return the car mileage
   */
  public Integer getMileage() {
    return this.mileage;
  }

  /**
   * sets the car mileage
   *
   * @param mileage the car mileage
   */
  public void setMileage(Integer mileage) {
    this.mileage = mileage;
  }

}
