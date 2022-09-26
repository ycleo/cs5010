package problem2;

/**
 * Represents the Make and Model of a Vehicle
 *
 * @author Yi-Cheng Lee
 */
public class MakeModel {

  private final String make;
  private final String model;

  /**
   * Constructor for class MakeModel
   *
   * @param make  vehicle make
   * @param model vehicle model
   */
  public MakeModel(String make, String model) {
    this.make = make;
    this.model = model;
  }

  /**
   * gets the vehicle make
   *
   * @return vehicle make
   */
  public String getMake() {
    return this.make;
  }

  /**
   * gets the vehicle model
   *
   * @return vehicle model
   */
  public String getModel() {
    return this.model;
  }

  /**
   * compare two MakModel object to determine they have the same contents of make and model
   *
   * @param makeModelCompare the MakeModel object to be compared
   * @return boolean result of the comparison with the MakeModel object
   */
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

