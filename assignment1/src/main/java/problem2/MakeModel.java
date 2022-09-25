package problem2;

public class MakeModel {
  private final String make;
  private final String model;
  public MakeModel(String make, String model) {
    this.make = make;
    this.model = model;
  }
  public String getMake() {
    return this.make;
  }
  public String getModel() {
      return this.model;
  }

  public boolean equals(MakeModel makeModelCompare) {
      if (this == makeModelCompare) {
        return true;
      }
      if (makeModelCompare == null) {
        return false;
      }
      String makeCompare = makeModelCompare.getMake();
      String modelCompare = makeModelCompare.getModel();

      return makeCompare.equals(this.make)
          && modelCompare.equals(this.model);
  }
}

