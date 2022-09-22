package assignment1.problem2;

public class NewCar extends Vehicle {

  private static int numWithinFiftyMiles = 0;

  public NewCar(String id, int manufacturingYear, MakeModel makeModel, double msrPrice) {
    super(id, manufacturingYear, makeModel, msrPrice);
  }

  public int getNumWithinFiftyMiles() {
    return numWithinFiftyMiles;
  }

  public void setNumWithinFiftyMiles(int num) {
    numWithinFiftyMiles = num;
  }
}
