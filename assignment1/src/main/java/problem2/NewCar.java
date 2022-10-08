package problem2;

/**
 * Represents a NewCar (a subclass of Car) with its manufacturing year, make and model, manufacturer
 * suggested retail price, and car mileage
 *
 * @author Yi-Cheng Lee
 */
public class NewCar extends Car {

  /**
   * Constructor for class NewCar
   *
   * @param manufactureYear the manufacturing year
   * @param makeModel       the make and model
   * @param mSRPrice        the manufacturer suggested retail price
   * @param mileage         the car mileage
   */
  public NewCar(Integer manufactureYear, MakeModel makeModel, Double mSRPrice, Integer mileage) {
    super(manufactureYear, makeModel, mSRPrice, mileage);
    if (this.mileage <= 50) {
      Integer newCarWithinFiftyMiles = VehicleSystem.getNewCarWithinFiftyMiles();
      VehicleSystem.setNewCarWithinFiftyMiles(newCarWithinFiftyMiles + 1);
    }
  }

  /**
   * sets the car mileage of new car
   *
   * @param mileage the car mileage
   */
  @Override
  public void setMileage(Integer mileage) {
    Integer newCarWithinFiftyMiles = VehicleSystem.getNewCarWithinFiftyMiles();
    if (this.getMileage() > 50 && mileage <= 50) {
      VehicleSystem.setNewCarWithinFiftyMiles(newCarWithinFiftyMiles + 1);
    } else if (this.getMileage() <= 50 && mileage > 50) {
      VehicleSystem.setNewCarWithinFiftyMiles(newCarWithinFiftyMiles - 1);
    }
    this.mileage = mileage;
  }

}
