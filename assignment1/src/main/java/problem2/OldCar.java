package problem2;

public class OldCar extends Car {

  private Integer numPrevOwner;
  private Integer numMinorAccident;

  public OldCar(Integer manufactureYear, MakeModel makeModel, Double mSRPrice, Integer mileage,
      Integer numPrevOwner, Integer numMinorAccident) {
    super(manufactureYear, makeModel, mSRPrice, mileage);
    this.numPrevOwner = numPrevOwner;
    this.numMinorAccident = numMinorAccident;
  }

  public Integer getNumPrevOwner() {
    return this.numPrevOwner;
  }

  public Integer getNumMinorAccident() {
    return this.numMinorAccident;
  }

  public void setNumPrevOwner(Integer numPrevOwner) {
    this.numPrevOwner = numPrevOwner;
  }

  public void setNumMinorAccident(Integer numMinorAccident) {
    this.numMinorAccident = numMinorAccident;
  }
}
