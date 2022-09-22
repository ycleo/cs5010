package assignment1.problem2;

public class Vessel extends Vehicle {

  public enum PropulsionType {
    SAIL_POWER,
    INBOARD_ENGINE,
    OUTBOARD_ENGINE,
    JET_PROPULSION
  }

  private float length;
  private int numPassengers;
  private PropulsionType propulsionType;

  public Vessel(String id, int manufacturingYear, MakeModel makeModel, double msrPrice,
      float length, int numPassengers, PropulsionType propulsionType) {
    super(id, manufacturingYear, makeModel, msrPrice);
    this.length = length;
    this.numPassengers = numPassengers;
    this.propulsionType = propulsionType;
  }

  public float getLength() {
    return this.length;
  }

  public int getNumPassengers() {
    return this.numPassengers;
  }

  public PropulsionType getPropulsionType() {
    return this.propulsionType;
  }

  public void setLength(float newLength) {
    this.length = newLength;
  }

  public void setNumPassengers(int newNumPassengers) {
    this.numPassengers = newNumPassengers;
  }

  public void setPropulsionType(PropulsionType newPropulsionType) {
    this.propulsionType = newPropulsionType;
  }
}
