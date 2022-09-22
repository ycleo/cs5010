package assignment1.problem2;

public class Vehicle {
  protected String id;
  protected int manufacturingYear;
  protected MakeModel makeModel;
  protected double msrPrice;

  public Vehicle(String id, int manufacturingYear, MakeModel makeModel, double msrPrice) {
    this.id = id;
    this.manufacturingYear = manufacturingYear;
    this.makeModel = makeModel;
    this.msrPrice = msrPrice;
  }

  public String getId() {
    return this.id;
  }
  public int getManufacturingYear() {
    return this.manufacturingYear;
  }
  public MakeModel getMakeModel() {
    return this.makeModel;
  }
  public double getMsrPrice() {
    return this.msrPrice;
  }
}
