package problem2;

import java.util.UUID;

public abstract class Vehicle implements VehicleInterface {
  protected String id;
  protected Integer manufactureYear;
  protected MakeModel makeModel;
  protected Double mSRPrice;

  public Vehicle(Integer manufactureYear, MakeModel makeModel, Double mSRPrice) {
    // generate new ID in vehicles database
    this.id = UUID.randomUUID().toString();
    this.manufactureYear = manufactureYear;
    this.makeModel = makeModel;
    this.mSRPrice = mSRPrice;
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
}
