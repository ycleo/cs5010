package problem2;

public class NewCar extends Car{

  public NewCar(Integer manufactureYear, MakeModel makeModel, Double mSRPrice, Integer mileage) {
    super(manufactureYear, makeModel, mSRPrice, mileage);
    if (this.mileage <= 50) {
      Integer newCarWithinFiftyMiles = VehicleSystem.getNewCarWithinFiftyMiles();
      VehicleSystem.setNewCarWithinFiftyMiles(newCarWithinFiftyMiles + 1);
    }
  }
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
