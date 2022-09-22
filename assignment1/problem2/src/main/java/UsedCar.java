package assignment1.problem2;

public class UsedCar extends Vehicle {

  private int mileage;
  private int numPrevOwner;
  private int numMinorAccidents;

  public UsedCar(String id, int manufacturingYear, MakeModel makeModel, double msrPrice,
      int mileage, int numPrevOwner, int numMinorAccidents) {
    super(id, manufacturingYear, makeModel, msrPrice);
    this.mileage = mileage;
    this.numPrevOwner = numPrevOwner;
    this.numMinorAccidents = numMinorAccidents;
  }

  public int getMileage() {
    return this.mileage;
  }

  public int getNumOfPrevOwner() {
    return this.numPrevOwner;
  }

  public int getNumOfMinorAccidents() {
    return this.numMinorAccidents;
  }

  public void setMileage(int mileage) {
    this.mileage = mileage;
  }

  public void setNumOfPrevOwner(int prevOwner) {
    this.numPrevOwner = prevOwner;
  }

  public void setNumOfMinorAccidents(int minorAccidents) {
    this.numMinorAccidents = minorAccidents;
  }
}
