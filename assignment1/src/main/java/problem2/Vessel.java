package problem2;

public abstract class Vessel implements Vehicle {

  protected String id;
  protected Integer manufactureYear;
  protected MakeModel makeModel;
  protected Double mSRPrice;

  public Vessel(Integer manufactureYear, MakeModel makeModel, Double mSRPrice, Float length,
      Integer numPassenger, PropulsionType propulsionType) {
    // generate new ID in vehicles database
    this.id = IdHelper.newVehicleId();
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
