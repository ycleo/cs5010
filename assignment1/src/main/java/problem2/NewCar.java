package problem2;

public class NewCar extends Car{
  private static Integer numWithinFiftyMiles = 0;

  public NewCar(Integer manufactureYear, MakeModel makeModel, Double mSRPrice, Integer mileage) {
    super(manufactureYear, makeModel, mSRPrice, mileage);
    if (this.mileage.intValue() <= 50) {
      numWithinFiftyMiles++;
    }
  }

  public Integer getNumWithinFiftyMiles() {
    return numWithinFiftyMiles;
  }
  @Override
  public void setMileage(Integer mileage) {
    this.mileage = mileage;
    if (this.mileage > 50) {
      numWithinFiftyMiles--;
    }
  }

}
