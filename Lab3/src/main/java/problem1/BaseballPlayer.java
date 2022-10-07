package problem1;

import java.util.Objects;

/**
 * Class BaseballPlayer contains information about a baseball player, including name, height,
 * weight, league, team, average batting, season home run number.
 */
public class BaseballPlayer extends Athlete {

  private String team;
  private Double avgBatting;
  private Integer seasonHomeRun;

  /**
   * Constructs a new baseball player, based upon all the provided input parameters.
   *
   * @param name          - object Name, containing the first and last name
   * @param height        - player's height, expressed as a Double in cm
   * @param weight        - player's weigh, expressed as a Double in pounds
   * @param league        - player's league, expressed as String
   * @param team          - player's team, expressed as String
   * @param avgBatting    - player's average batting, expressed as Double
   * @param seasonHomeRun - player's season home run number, expressed as Integer
   */
  public BaseballPlayer(Name name, Double height, Double weight, String league, String team,
      Double avgBatting, Integer seasonHomeRun) {
    super(name, height, weight, league);
    this.team = team;
    this.avgBatting = avgBatting;
    this.seasonHomeRun = seasonHomeRun;
  }

  /**
   * Constructs a new baseball player, based upon all the provided input parameters.
   *
   * @param name          - object Name, containing athlete's first and last name
   * @param height        - player's height, expressed as a Double in cm
   * @param weight        - player's weigh, expressed as a Double in pounds
   * @param team          - player's team, expressed as String
   * @param avgBatting    - player's average batting, expressed as Double
   * @param seasonHomeRun - player's season home run number, expressed as Integer
   */
  public BaseballPlayer(Name name, Double height, Double weight, String team,
      Double avgBatting, Integer seasonHomeRun) {
    super(name, height, weight);
    this.team = team;
    this.avgBatting = avgBatting;
    this.seasonHomeRun = seasonHomeRun;
  }

  /**
   * Returns player's team as String
   *
   * @return String player's team
   */
  public String getTeam() {
    return this.team;
  }

  /**
   * Returns player's average batting as Double
   *
   * @return Double average batting
   */
  public Double getAvgBatting() {
    return this.avgBatting;
  }

  /**
   * Returns player's season home run number as Integer
   *
   * @return Integer player's season home run number
   */
  public Integer getSeasonHomeRun() {
    return this.seasonHomeRun;
  }

  /**
   * Test two BaseballPlayer objects have the same property values
   *
   * @param o tested object
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
    if (!super.equals(o)) {
      return false;
    }
    BaseballPlayer baseballPlayer = (BaseballPlayer) o;
    return Objects.equals(team, baseballPlayer.team) && Objects.equals(avgBatting,
        baseballPlayer.avgBatting) && Objects.equals(seasonHomeRun, baseballPlayer.seasonHomeRun);
  }

  /**
   * Returns the hash code of the BaseballPlayer object
   *
   * @return int hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), team, avgBatting, seasonHomeRun);
  }

  /**
   * Returns the string represents the baseball player information
   *
   * @return String about baseball player
   */
  @Override
  public String toString() {
    return "BaseballPlayer{" +
        "Name=" + getName().getFirstName() + ' ' + getName().getLastName() +
        ", height=" + getHeight() +
        ", weight=" + getWeight() +
        ", league=" + getLeague() +
        ", team=" + getTeam() +
        ", average batting=" + getAvgBatting() +
        ", season home runs=" + getSeasonHomeRun() +
        '}';
  }
}
