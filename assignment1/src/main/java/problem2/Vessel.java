package problem2;

public abstract class Vessel extends Vehicle {

  public Vessel(Integer manufactureYear, MakeModel makeModel, Double mSRPrice) {
    // generate new ID in vehicles database
    super(manufactureYear, makeModel, mSRPrice);
  }
}
