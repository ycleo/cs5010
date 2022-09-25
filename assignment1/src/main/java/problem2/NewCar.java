package problem2;

public class NewCar extends Car{

  public NewCar(Integer manufactureYear, MakeModel makeModel, Double mSRPrice, Integer mileage) {
    super(manufactureYear, makeModel, mSRPrice, mileage);
    if (this.mileage.intValue() <= 50) {
      Integer newCarWithinFiftyMiles = VehicleSystem.getNewCarWithinFiftyMiles();
      VehicleSystem.setNewCarWithinFiftyMiles(Integer.valueOf(newCarWithinFiftyMiles.intValue() + 1));
    }
  }
  @Override
  public void setMileage(Integer mileage) {
    Integer newCarWithinFiftyMiles = VehicleSystem.getNewCarWithinFiftyMiles();
    if (this.getMileage().intValue() > 50 && mileage.intValue() <= 50) {
      VehicleSystem.setNewCarWithinFiftyMiles(Integer.valueOf(newCarWithinFiftyMiles.intValue() + 1));
    } else if (this.getMileage().intValue() <= 50 && mileage.intValue() > 50) {
      VehicleSystem.setNewCarWithinFiftyMiles(Integer.valueOf(newCarWithinFiftyMiles.intValue() - 1));
    }
    this.mileage = mileage;
  }

}
