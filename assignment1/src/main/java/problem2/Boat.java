package problem2;

public class Boat extends Vessel {

  private Float length;
  private Integer numPassenger;
  private PropulsionType propulsionType;

  public Boat(Integer manufactureYear, MakeModel makeModel, Double mSRPrice, Float length,
      Integer numPassenger, PropulsionType propulsionType) {
    super(manufactureYear, makeModel, mSRPrice);
    this.length = length;
    this.numPassenger = numPassenger;
    this.propulsionType = propulsionType;
  }

  public Float getLength() {
    return this.length;
  }

  public Integer getNumPassenger() {
    return this.numPassenger;
  }

  public PropulsionType getPropulsionType() {
    return this.propulsionType;
  }

}

//  public static void main(String[] args) {
//    MakeModel makeModel = new MakeModel("Steel", "Honda");
//    Boat boat = new Boat(2022, makeModel, 2000.0, 90.8f, 10, PropulsionType.SAIL_POWER);
//    System.out.println(boat.getPropulsionType());
//  }
