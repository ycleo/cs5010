package problem1;

import java.util.Objects;

/**
 * Class Athlete contains information about an athlete, including athlete's name, their height,
 * weight and league.
 */
public class Athlete {

  private Name name;
  private Double height;
  private Double weight;
  private String league;


  /**
   * Constructs a new athlete, based upon all the provided input parameters.
   *
   * @param name   - object Name, containing athlete's first and last name
   * @param height - athlete's height, expressed as a Double in cm
   * @param weight - athlete's weigh, expressed as a Double in pounds
   * @param league - athelete's league, expressed as String
   */
  public Athlete(Name name, Double height, Double weight, String league) {
    this.name = name;
    this.height = height;
    this.weight = weight;
    this.league = league;
  }

  /**
   * Constructs a new athlete, based upon all the provided input parameters.
   *
   * @param name   - object Name, containing athlete's first and last name
   * @param height - athlete's height, expressed as a Double in cm
   * @param weight - athlete's weigh, expressed as a Double in pounds
   */
  public Athlete(Name name, Double height, Double weight) {
    this.name = name;
    this.height = height;
    this.weight = weight;
    this.league = null;
  }

  /**
   * Returns athlete's name as an object Name
   *
   * @return Name
   */
  public Name getName() {
    return name;
  }

  /**
   * Returns athlete's height as a Double
   *
   * @return Double athlete's height
   */
  public Double getHeight() {
    return height;
  }

  /**
   * Returns athlete's weight as a Double
   *
   * @return Double athlete's weight
   */
  public Double getWeight() {
    return weight;
  }


  /**
   * Returns athlete's league as a String
   *
   * @return String athlete's league
   */
  public String getLeague() {
    return league;
  }

  /**
   * Test two Athlete objects have the same property values
   *
   * @param o
   * @return boolean
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Athlete athlete = (Athlete) o;
    return Objects.equals(getName(), athlete.getName())
        && Objects.equals(getHeight(), athlete.getHeight())
        && Objects.equals(getWeight(), athlete.getWeight())
        && Objects.equals(getLeague(), athlete.getLeague());
  }

  /**
   * Returns the hash code of the athlete object
   *
   * @return int hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(getName(), getHeight(), getWeight(), getLeague());
  }

  /**
   * Returns the string represents the athlete information
   *
   * @return String about athlete
   */
  @Override
  public String toString() {
    return "Athlete{name=" + name.getFirstName() + ' ' + name.getLastName() + ", " +
        "height=" + height + ", " +
        "weight=" + weight + ", " +
        "league=" + league + "}";
  }
}
