package problem2;

import java.util.Random;

public abstract class Car implements Vehicle {
  protected String id;
  protected Integer manufactureYear;
  protected MakeModel makeModel;
  protected Double mSRPrice;
  protected Integer mileage;

  public Car(Integer manufactureYear, MakeModel makeModel, Double mSRPrice, Integer mileage) {
    // generate new ID in vehicles database
    this.id = IdHelper.newVehicleId();
    this.manufactureYear = manufactureYear;
    this.makeModel = makeModel;
    this.mSRPrice = mSRPrice;
    this.mileage = mileage;
  }

  public String getId() {
    return this.id;
  }

  public Integer getManufactureYear() {
    return this.manufactureYear;
  }

  public MakeModel getMakeModel() {
    return this.makeModel;
  }

  public Double getMSRPrice() {
    return this.mSRPrice;
  }

  public Integer getMileage() {
    return this.mileage;
  }

  public void setMileage(Integer mileage) {
    this.mileage = mileage;
  }

}
