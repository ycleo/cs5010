package problem2;

public abstract class Car extends Vehicle {
  protected Integer mileage;

  public Car(Integer manufactureYear, MakeModel makeModel, Double mSRPrice, Integer mileage) {
    super(manufactureYear, makeModel, mSRPrice);
    this.mileage = mileage;
  }

  public Integer getMileage() {
    return this.mileage;
  }

  public void setMileage(Integer mileage) {
    this.mileage = mileage;
  }

}
